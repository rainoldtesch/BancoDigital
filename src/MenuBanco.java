
import java.util.Scanner;
public class MenuBanco {

    public static void main (String[] args){
        MenuOpcoes menuOpcoes = new MenuOpcoes();
        Gerente gerente = new Gerente();

        int opcao = 0;
        do {
            System.out.println("--------------------------------------");
            System.out.println("    *** Banco Digital Alfa ***        ");
            System.out.println("--------------------------------------");
            System.out.println("   | 1 |  Criar Conta                 |");
            System.out.println("   | 2 |  Sacar                       |");
            System.out.println("   | 3 |  Depositar                   |");
            System.out.println("   | 4 |  Transferir valores          |");
            System.out.println("   | 5 |  Mostrar total das contas    |");
            System.out.println("   | 6 |  Contas Cadastradas          |");
            System.out.println("   | 7 |  Compras de Clientes         |");
            System.out.println("   | 8 |  Sair                        |");
            System.out.println("--------------------------------------");

            Scanner menu = new Scanner(System.in);
            System.out.print("Digite uma Opção: ");
            opcao= menu.nextInt();

            switch(opcao){
                case 1:
                    menuOpcoes.CriarConta(gerente);
                    break;
                case 2:
                    menuOpcoes.Sacar(gerente);
                    break;
                case 3:
                    menuOpcoes.Depositar(gerente);
                    break;
                case 4:
                    menuOpcoes.transferencia(gerente);
                    break;
                case 5:
                    gerente.Saldo();
                    break;
                case 6:
                    gerente.ContasCadastradas();
                    break;
                case 7:
                    Testa_Cliente.main();
                    break;
                case 8:
                    System.out.println("Você saiu do sistema!!!");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opcao<7);
    }
}
