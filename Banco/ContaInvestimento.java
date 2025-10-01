package Banco;

public class ContaInvestimento extends Conta {
    private double taxaRendimento;

    public ContaInvestimento(String numeroConta, double saldoInicial, double taxaRendimento) {
        super(numeroConta, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
            verSaldo();
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * this.taxaRendimento;
        depositar(rendimento);
        System.out.println("Rendimento de investimento de R$" + String.format("%.2f", rendimento) + " aplicado.");
    }

    // Getter e Setter
    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}