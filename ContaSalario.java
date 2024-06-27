package Banco;

public class ContaSalario extends ContaCorrente{
    private double limiteSaque;

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public ContaSalario(int numeroConta, double saldo, double taxaDeManutenção, double limiteChequeEspecial, double limiteSaque) {
        super(numeroConta, saldo, taxaDeManutenção, limiteChequeEspecial);
        this.limiteSaque = limiteSaque;
    }
}
