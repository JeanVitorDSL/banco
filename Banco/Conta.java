package Banco;

/**
 * Classe abstrata que serve como modelo base para todos os tipos de contas.
 * Define os atributos e comportamentos essenciais de uma conta bancária.
 */
public abstract class Conta {
    private String numeroConta;
    private double saldo;

    // Construtor
    public Conta(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    // Getters
    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setter protegido para que apenas as classes filhas possam alterar o saldo
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Método abstrato para saque. Cada tipo de conta deve implementar sua própria lógica.
     * @param valor A quantia a ser sacada.
     */
    public abstract void sacar(double valor);

    /**
     * Realiza um depósito na conta.
     * @param valor O valor a ser depositado (deve ser positivo).
     */
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
            verSaldo();
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    /**
     * Exibe o saldo atual da conta.
     */
    public void verSaldo() {
        System.out.println("Saldo atual da conta " + this.numeroConta + ": R$" + String.format("%.2f", this.saldo));
    }
}