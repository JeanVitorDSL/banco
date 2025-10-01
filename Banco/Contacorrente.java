package Banco;

public class Contacorrente extends Conta {
    private double taxaDeManutencao;
    private double limiteChequeEspecial;

    public Contacorrente(String numeroConta, double saldoInicial, double taxaDeManutencao, double limiteChequeEspecial) {
        // Chama o construtor da classe mãe (Conta)
        super(numeroConta, saldoInicial);
        this.taxaDeManutencao = taxaDeManutencao;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        double saldoDisponivel = getSaldo() + this.limiteChequeEspecial;
        if (valor > 0 && valor <= saldoDisponivel) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
            verSaldo();
        } else {
            System.out.println("Saldo e limite de cheque especial insuficientes para o saque.");
        }
    }

    public void cobrarTaxaDeManutencao() {
        setSaldo(getSaldo() - this.taxaDeManutencao);
        System.out.println("Taxa de manutenção de R$" + String.format("%.2f", this.taxaDeManutencao) + " cobrada com sucesso.");
        verSaldo();
    }

    // Getters e Setters para os atributos específicos
    public double getTaxaDeManutencao() {
        return taxaDeManutencao;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}