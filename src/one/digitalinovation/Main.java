package one.digitalinovation;

public class Main {
    public static void main(String[] args) {
        Cliente ivan = new Cliente("Ivan","JURIDICA" );
        //ivan.setNome("Ivan");

        Conta cc = new ContaCorrente(ivan);
        Conta poupanca = new ContaPoupanca(ivan);

        cc.depositar(1110);
        cc.transferir(1110, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        cc.tomarEmprestimo(ivan, 500);
        poupanca.tomarEmprestimo(ivan, 20000);




    }

}
