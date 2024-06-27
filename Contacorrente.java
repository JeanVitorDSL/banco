public class ContaCorrente {
    double taxaDeManutencao;
    double chequeEspecial;

    public ContaCorrente(double taxaDeManutencao, double chequeEspecial) {
        this.taxaDeManutencao = taxaDeManutencao;
        this.chequeEspecial = chequeEspecial;
    }

    public double getTaxaDeManutencao() {
        return taxaDeManutencao;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setTaxaDeManutencao(double taxaDeManutencao) {
        this.taxaDeManutencao = taxaDeManutencao;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void cobrarTaxaDeManutencao() {
        System.out.println("Taxa de manutenção de R$" + taxaDeManutencao + " cobrada com sucesso.");
    }

    public void usarChequeEspecial(double valor) {
        if (valor <= chequeEspecial) {
            chequeEspecial -= valor;
            System.out.println("Cheque especial utilizado com sucesso. Saldo do cheque especial: R$" + chequeEspecial);
        } else {
            System.out.println("Saldo insuficiente no cheque especial.");