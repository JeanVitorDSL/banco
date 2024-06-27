package Banco;

public class ContaPoupança extends ContaBancaria{
    private double taxaDeRendimento;

    public double getTaxaDeRendimento() {
        return taxaDeRendimento;
    }

    public void setTaxaDeRendimento(double taxaDeRendimento) {
        this.taxaDeRendimento = taxaDeRendimento;
    }

    public ContaPoupança(int numeroConta, double saldo, double taxaDeRendimento) {
        super(numeroConta, saldo);
        this.taxaDeRendimento = taxaDeRendimento;
    }
}
