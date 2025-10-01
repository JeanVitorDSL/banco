package Banco;

public class ContaSalario extends Conta {
    private double limiteSaque;

    public ContaSalario(String numeroConta, double saldoInicial, double limiteSaque) {
        super(numeroConta, saldoInicial);
        this.limiteSaque = limiteSaque;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser positivo.");
            return;
        }
        if (valor > this.limiteSaque) {
            System.out.println("Tentativa de saque (R$" + String.format("%.2f", valor) + ") acima do seu limite de R$" + String.format("%.2f", this.limiteSaque) + ".");
            return;
        }
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
            verSaldo();
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    // Getter e Setter
    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
}