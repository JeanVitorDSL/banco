public class Conta {
    String numeroConta;
    Double saldo;
    
    // Cons
    public Conta(String numeroConta, Double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }
    
    // Get
    public String getNumeroConta() {
        return numeroConta;
    }
    
    public Double getSaldo() {
        return saldo;
    }
    
    // Set
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}

public class Conta {
    String numeroConta;
    Double saldo;
    
    // Construtor
    public Conta(String numeroConta, Double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }
    
    // Getters
    public String getNumeroConta() {
        return numeroConta;
    }
    
    public Double getSaldo() {
        return saldo;
    }
    
    // Setters
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    
    public void sacar(Double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }
    
    
    public void depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }
    
    
    public void verSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }
}