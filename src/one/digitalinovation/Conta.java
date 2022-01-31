package one.digitalinovation;


/*
     por ser apenas um exemplo e um teste para os novos conhecimentos, foram configurados apenas
     dois requisitos para a obtenção do emprestimo (o cliente não pode estar negativo e o emprestimo
     máximo desse banco ser de apenas 5000 pessoa fisica e 10000 para pessoa juridica
     foi instaurado também os limites das contas PF e PJ.
*/

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected boolean saldoNegativo;
    protected final double limitePF = 500, limitePJ = 2000;
    protected double limite, limiteReferencia;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        if (cliente.getTipo().equals("FISICA")){
            limite = limiteReferencia = limitePF;
            System.out.println("Conta PF com limite pré-aprovado de R$"+limite);
        }
        if (cliente.getTipo().equals("JURIDICA")){
            limite = limiteReferencia = limitePJ;
            System.out.println("Conta PJ com limite pré-aprovado de R$"+limite);
        }
    }

    @Override
    public void sacar(double valor) {
        if (saldo>valor){
            saldo -= valor;
        }

        if (saldo<valor && saldo>0 ){
            if (saldo+limite>=valor){
               saldo -= valor;
               limite += saldo;
            }else{
                System.out.println("======================================================================");
                System.out.println("Saldo+limite insuficientes para essa transacao, operacao nao realizada");
                System.out.println("======================================================================");
            }
        }else if (saldo<=0 ){
            if (limite>=valor){
                saldo -= valor;
                limite -= valor;
            }else{
                System.out.println("======================================================================");
                System.out.println("Saldo+limite insuficientes para essa transacao, operacao nao realizada");
                System.out.println("======================================================================");
            }

        }

        if (saldo<0){
            saldoNegativo=true;
        }else saldoNegativo=false;
    }

    @Override
    public void depositar(double valor) {
        if (saldo>=0){
            saldo += valor;
        }else{
            saldo += valor;
            if (saldo>=0){
                limite = limiteReferencia;
            }else limite +=valor;
        }
        if (saldo<0){
            saldoNegativo=true;
        }else saldoNegativo=false;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isSaldoNegativo() {
        return saldoNegativo;
    }

    public void setSaldoNegativo(boolean saldoNegativo) {
        this.saldoNegativo = saldoNegativo;
    }

    private boolean checarConta(Conta conta){
        if (conta.isSaldoNegativo()){
            System.out.println("===============================================");
            System.out.println("Cliente com debitos anteriores a esta consulta.");
            System.out.println("Lamentamos mas o emprestimo negado.");
            System.out.println("===============================================");
        }
        return conta.isSaldoNegativo();
    }
    private boolean checarRegraDeNegocio(Cliente cliente, double valor){
        boolean aprovado = false;
        if (cliente.getTipo().equals("FISICA")&&valor<5001){
            System.out.println("======================================================================================");
            System.out.println("Prezado cliente PF informamos que seu emprestimo no valor de R$"+valor+" foi aprovado.");
            System.out.println("======================================================================================");
            aprovado = true;

        }else if (cliente.getTipo().equals("JURIDICA")&&valor<10001){
            System.out.println("======================================================================================");
            System.out.println("Prezado cliente PJ informamos que seu emprestimo no valor de R$"+valor+" foi aprovado.");
            System.out.println("======================================================================================");
            aprovado = true;
        }else {
            System.out.println("======================================================================================");
            System.out.println("Caro cliente pessoa "+cliente.getTipo()+" ha um problema quanto ao montante pretendido");
            System.out.println("Infelizmente seu emprestimo foi recusado.");
            System.out.println("======================================================================================");
        }
        return aprovado;
    }

    public void tomarEmprestimo(Cliente cliente, double valor){

        if (!checarConta(this)){
            if (checarRegraDeNegocio(cliente, valor)){
                System.out.println("Parabens!");
                this.depositar(valor);
            }
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Limite: %.2f", this.limite));

    }
}
