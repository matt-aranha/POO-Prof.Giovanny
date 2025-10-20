
/**
 * ENUNCIADO: crie um novo projeto chamado banco. Crie uma classe para contas bancárias. Toda conta pertence a algum cliente do banco.
 * Para cada cliente considere somente como informação o CPF. Uma conta tem um saldo e as operações possíveis são depositar, sacar e ver o saldo.
 * Por simplicidade, a conta não mantém o histórico de transações..
 * 
 * @author (Mateus Aranha) 
 * @version (19/10/2025)
 */

public class ContaBancaria {
    // --- ATRIBUTOS ---
    private String cpf;
    private int saldo;

    // Construtor: pede CPF ao criar um nova conta, iniciando-a com saldo R$0.
    public ContaBancaria(String cpf) {
        this.setCpf(cpf);
        this.saldo = 0;
    }

    // Método que define o CPF e verifica se seu comprimento é 11.
    public void setCpf(String novoCpf) {
        if (novoCpf != null && novoCpf.length() == 11) {
            this.cpf = novoCpf;
        } else {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos."); 
        }
    }
    
    // Método para consultar o CPF da conta em uso.
    public String consultarCpf() {
        return this.cpf;
    }
    
    
    // --- OPERAÇÕES BANCÁRIAS ---
    // Método para depositar dinheiro na conta.
    public void depositar(int deposito) {
        if (deposito > 0) {
            this.saldo = saldo + deposito;
            System.out.println("Depósito de R$" + deposito + " realizado com sucesso! Novo saldo: R$" + this.saldo + ".");
        } else {
            System.out.println("Erro de Transação: Depósito inválido. Saldo atual: R$" + this.saldo + ".");
        }
    }
    
    // Método para sacar dinheiro da conta.
    public void sacar(int saque) {
        if (saque > 0 && this.saldo >= saque) {
            this.saldo = this.saldo - saque;
            System.out.println("Saque de R$" + saque + " realizado com sucesso! Novo saldo: R$" + this.saldo + ".");
        } else {
            System.out.println("Erro de Transação: Saldo insuficiente ou valor do saque inválido. Saldo atual: R$" + this.saldo + ".");
        }
    }
    
    // Método para olhar o saldo da conta.
    public int consultarSaldo() { 
            return this.saldo;                 //obs: eu havia esquecido do "this.", o que é um erro! Apesar de que nesse caso, como não tem uma variável local ou parâmetro chamado "saldo", o Java entenderia. O "this." se refere ao atributo. não esquecer! =D
        }
}