package Banco;

public class ContaInvestimento extends ContaCorrente{
    private double taxaRendimento;

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public ContaInvestimento(int numeroConta, double saldo, double taxaDeManutenção, double limiteChequeEspecial, double taxaRendimento) {
        super(numeroConta, saldo, taxaDeManutenção, limiteChequeEspecial);
        this.taxaRendimento = taxaRendimento;
    }
}
