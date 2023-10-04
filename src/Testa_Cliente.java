import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Testa_Cliente {

    public static void main() {
        Cliente cli1 = new Cliente ("Rainold",true, "123",33);
        Cliente cli2 = new Cliente ("Daniele",true, "iop",33);
        Cliente cli3 = new Cliente ("Carlos",false, "qwe",28);
        Cliente cli4 = new Cliente ("José",true, "abc",18);
        Cliente cli5 = new Cliente ("Maria",false, "qwe",5);
        Cliente cli6 = new Cliente ("Alfredo",false, "qwe",23);
        Cliente cli7 = new Cliente ("Cecília",false, "qwe",2);
        Cliente cli8 = new Cliente ("Renato",false, "qwe",10);
        Cliente cli9 = new Cliente ("Fabiola",true, "qwe",32);
        Cliente cli10 = new Cliente ("Gustavo",true, "qwe",22);

        List<Cliente> clientes = Arrays.asList(cli1,cli2,cli3,cli4,cli5,cli6,cli7,cli8,cli9,cli10);
        //imprime todos os clientes com total de compras:
        System.out.println();
        System.out.println("LISTA DE CLIENTES COM Nº DE COMPRAS:");
        clientes.forEach(cli -> System.out.println("Cliente: " + cli.getNome() + " - total de compras: " + cli.getCompras()));
        System.out.println();

        // Criação de Stream para filtrar os clientes a partir de 10 compras:
        Stream<Cliente> stream = clientes.stream()
                .filter(cliente -> cliente.getCompras() >= 10);

        // Criação de lista para imprimir os clientes filtrados no stream acima:
        List<Cliente> selecionados = stream.collect(Collectors.toList());
        System.out.print("Filtro de clientes maior que 10 compras: ");
        // Imprimindo a lista dos objetos filtrados - somente o nº de compras:
        selecionados.forEach(c -> System.out.print(c.getCompras() + "; "));
        System.out.println();

        // TAREFA MÓDULO 9:

        // Cliente que fez maior nº de compras:

        // Código para os Maiores números de compras:
        int maiorNumeroDeCompras = clientes.stream()
                .max(Comparator.comparing(cliente -> cliente.getCompras()))
                .get().getCompras();

        // Cliente que fez mais compras:
        System.out.println();
        System.out.println(" - Cliente(s) com maior nº de compras: ");
        List<Cliente> listaClientesMaisCompras = clientes.stream()
                .filter(cliente -> cliente.getCompras() == maiorNumeroDeCompras).collect(Collectors.toList());
        listaClientesMaisCompras.forEach(cliente ->
                System.out.println("     - " + cliente.getNome() +
                        ", que comprou " + cliente.getCompras() + " vezes."));

        // Cliente que fez menos compras:
        System.out.println();
        Stream<Cliente> streamMenosCompras = clientes.stream()
                .min(Comparator.comparing(Cliente :: getCompras))
                .stream();
        System.out.print(" - Cliente(s) com menor nº de compras: ");
        Cliente clienteMenosCompras = streamMenosCompras.findFirst().get();
        System.out.println(clienteMenosCompras.getNome() + ", que comprou " + clienteMenosCompras.getCompras() + " vezes.");

        // Média de compras dos clientes da lista:
        System.out.println();
        double mediaCompras = clientes.stream()
                .mapToDouble(Cliente :: getCompras)
                .average()
                .getAsDouble();
        System.out.println("-------------------------------------------------------------------");
        System.out.println(" >>> Média de " + mediaCompras + " compras por cliente!!!");
        System.out.println("-------------------------------------------------------------------");
    }
}
