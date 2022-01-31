package one.digitalinovation;

public class Main {
    public static void main(String[] args) {
        Cliente ivanPF = new Cliente("Ivan","FISICA" );
        Cliente ivanPJ = new Cliente("Ivan","JURIDICA" );


        Conta cp = new ContaPoupanca(ivanPF);
        Conta cc = new ContaCorrente(ivanPJ);

        cc.depositar(110);
        cc.transferir(200, cp);
        cc.sacar(100);
        cc.sacar(100);
        cc.depositar(290);


        cc.imprimirExtrato();
        cp.imprimirExtrato();

        cc.tomarEmprestimo(ivanPJ, 500);
        cp.tomarEmprestimo(ivanPF, 20000);

        cp.sacar(1650);
        cc.sacar(2000);
        cc.imprimirExtrato();
        cc.sacar(100);
        cp.tomarEmprestimo(ivanPF,5000);
        cp.imprimirExtrato();

        cc.depositar(1999);
        cc.depositar(101);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        cp.sacar(5700);
        cp.imprimirExtrato();

        cp.sacar(1);





    }

}
