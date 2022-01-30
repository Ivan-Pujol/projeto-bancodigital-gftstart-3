package one.digitalinovation;

public class Main {
    public static void main(String[] args) {
        Cliente ivan = new Cliente();
        ivan.setNome("Ivan");

        Conta cc = new ContaCorrente(ivan);
        Conta poupanca = new ContaPoupanca(ivan);

        cc.depositar(1000);
        cc.transferir(450, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }

}
