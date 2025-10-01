package Banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Usamos um Map para armazenar todas as contas criadas, usando o número da conta como chave.
    private static Map<String, Conta> contas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Populando com algumas contas para facilitar os testes
        contas.put("123-4", new Contacorrente("123-4", 1000.0, 15.0, 500.0));
        contas.put("567-8", new ContaPoupanca("567-8", 2000.0, 0.05));
        contas.put("910-1", new ContaSalario("910-1", 1500.0, 500.0));

        while (true) {
            exibirMenuPrincipal();
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    criarConta();
                    break;
                case "2":
                    acessarConta();
                    break;
                case "3":
                    System.out.println("Obrigado por utilizar nosso sistema. Até logo!");
                    return; // Encerra o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- BEM-VINDO AO BANCO DIGITAL ---");
        System.out.println("1. Criar Nova Conta");
        System.out.println("2. Acessar Conta Existente");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarConta() {
        System.out.println("\n--- CRIAÇÃO DE CONTA ---");
        System.out.println("Qual tipo de conta deseja criar?");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.println("3. Conta Salário");
        System.out.print("Tipo de conta: ");
        String tipoConta = scanner.nextLine();

        System.out.print("Digite o número da nova conta (ex: 999-9): ");
        String numeroConta = scanner.nextLine();
        if (contas.containsKey(numeroConta)) {
            System.out.println("Erro: Já existe uma conta com este número.");
            return;
        }

        System.out.print("Digite o saldo inicial: R$");
        double saldoInicial = Double.parseDouble(scanner.nextLine());

        try {
            switch (tipoConta) {
                case "1":
                    System.out.print("Defina a taxa de manutenção mensal: R$");
                    double taxa = Double.parseDouble(scanner.nextLine());
                    System.out.print("Defina o limite do cheque especial: R$");
                    double chequeEspecial = Double.parseDouble(scanner.nextLine());
                    contas.put(numeroConta, new Contacorrente(numeroConta, saldoInicial, taxa, chequeEspecial));
                    break;
                case "2":
                    System.out.print("Defina a taxa de rendimento (ex: 0.05 para 5%): ");
                    double rendimentoPoupanca = Double.parseDouble(scanner.nextLine());
                    contas.put(numeroConta, new ContaPoupanca(numeroConta, saldoInicial, rendimentoPoupanca));
                    break;
                case "3":
                    System.out.print("Defina o limite de saque por transação: R$");
                    double limiteSaque = Double.parseDouble(scanner.nextLine());
                    contas.put(numeroConta, new ContaSalario(numeroConta, saldoInicial, limiteSaque));
                    break;
                default:
                    System.out.println("Tipo de conta inválido.");
                    return;
            }
            System.out.println("Conta criada com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Valor numérico inválido.");
        }
    }

    private static void acessarConta() {
        System.out.print("\nDigite o número da conta para acessar: ");
        String numeroConta = scanner.nextLine();

        Conta conta = contas.get(numeroConta);

        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.println("Acesso realizado com sucesso! Bem-vindo, titular da conta " + numeroConta);

        while (true) {
            exibirMenuDaConta(conta);
            String opcao = scanner.nextLine();

            if (opcao.equals("0")) {
                break; // Volta ao menu principal
            }

            try {
                realizarOperacao(opcao, conta);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Valor numérico inválido.");
            }
        }
    }

    private static void exibirMenuDaConta(Conta conta) {
        System.out.println("\n--- CONTA " + conta.getNumeroConta() + " ---");
        conta.verSaldo();
        System.out.println("O que você gostaria de fazer?");
        System.out.println("1. Ver Saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Transferir");

        // Mostra opções específicas para cada tipo de conta
        if (conta instanceof Contacorrente) {
            System.out.println("5. Cobrar Taxa de Manutenção");
        }
        if (conta instanceof ContaPoupanca) {
            System.out.println("5. Aplicar Rendimento da Poupança");
        }
        if (conta instanceof ContaInvestimento) {
            System.out.println("5. Aplicar Rendimento de Investimento");
        }

        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void realizarOperacao(String opcao, Conta conta) {
        double valor;

        switch (opcao) {
            case "1":
                conta.verSaldo();
                break;
            case "2":
                System.out.print("Digite o valor para depositar: R$");
                valor = Double.parseDouble(scanner.nextLine());
                conta.depositar(valor);
                break;
            case "3":
                System.out.print("Digite o valor para sacar: R$");
                valor = Double.parseDouble(scanner.nextLine());
                conta.sacar(valor);
                break;
            case "4":
                System.out.print("Digite o número da conta de destino: ");
                String numDestino = scanner.nextLine();
                Conta contaDestino = contas.get(numDestino);

                if (contaDestino == null) {
                    System.out.println("Conta de destino não encontrada.");
                    return;
                }

                if (conta.getNumeroConta().equals(numDestino)) {
                    System.out.println("Não é possível transferir para a mesma conta.");
                    return;
                }

                System.out.print("Digite o valor a ser transferido: R$");
                valor = Double.parseDouble(scanner.nextLine());

                // A lógica de transferência é uma composição de saque e depósito
                // Para simplificar, vamos simular isso. Primeiro, verificamos se o saque é possível.
                // Uma melhoria seria o método sacar() retornar um booleano. Por enquanto, a simulação é suficiente.
                if (conta instanceof Contacorrente && (conta.getSaldo() + ((Contacorrente) conta).getLimiteChequeEspecial()) >= valor) {
                    conta.sacar(valor);
                    contaDestino.depositar(valor);
                    System.out.println("--- Transferência realizada com sucesso! ---");
                } else if (!(conta instanceof Contacorrente) && conta.getSaldo() >= valor) {
                    conta.sacar(valor);
                    contaDestino.depositar(valor);
                    System.out.println("--- Transferência realizada com sucesso! ---");
                } else {
                    System.out.println("--- Transferência falhou. Saldo insuficiente na conta de origem. ---");
                }
                break;
            case "5":
                // Executa a ação específica da conta
                if (conta instanceof Contacorrente) {
                    ((Contacorrente) conta).cobrarTaxaDeManutencao();
                } else if (conta instanceof ContaPoupanca) {
                    ((ContaPoupanca) conta).aplicarRendimento();
                } else if (conta instanceof ContaInvestimento) {
                    ((ContaInvestimento) conta).aplicarRendimento();
                }
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }
}