package Banco;

public class ContaPoupanca extends Conta {
    private double taxaDeRendimento; // Ex: 0.05 para 5%

    public ContaPoupanca(String numeroConta, double saldoInicial, double taxaDeRendimento) {
        super(numeroConta, saldoInicial);
        this.taxaDeRendimento = taxaDeRendimento;
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
        double rendimento = getSaldo() * this.taxaDeRendimento;
        depositar(rendimento); // Reutiliza o método depositar para adicionar o rendimento
        System.out.println("Rendimento de R$" + String.format("%.2f", rendimento) + " aplicado.");
    }

    // Getter e Setter para taxaDeRendimento
    public double getTaxaDeRendimento() {
        return taxaDeRendimento;
    }

    public void setTaxaDeRendimento(double taxaDeRendimento) {
        this.taxaDeRendimento = taxaDeRendimento;
    }
}