import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Grafo grafo = new Grafo();

        try {

            grafo.carregarArquivo("creches.txt");

        } catch (Exception e) {

            System.out.println(
                    "Erro ao carregar arquivo."
            );

            return;
        }

        int opcao;

        do {

            System.out.println("\n===== MENU =====");

            System.out.println(
                    "1 - Número de conexões");
            System.out.println(
                    "2 - Listar conexões");
            System.out.println(
                    "3 - Consultar distância");
            System.out.println(
                    "4 - Nova conexão");
            System.out.println(
                    "0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    grafo.mostrarQuantidadeConexoes();
                    break;

                case 2:

                    System.out.print(
                            "Nome da creche: ");

                    String creche =
                            sc.nextLine();

                    grafo.listarConexoes(creche);
                    break;

                case 3:

                    System.out.print(
                            "Origem: ");

                    String origem =
                            sc.nextLine();

                    System.out.print(
                            "Destino: ");

                    String destino =
                            sc.nextLine();

                    grafo.consultarDistancia(
                            origem,
                            destino
                    );

                    break;

                case 4:

                    System.out.print(
                            "Origem: ");

                    origem = sc.nextLine();

                    System.out.print(
                            "Destino: ");

                    destino = sc.nextLine();

                    System.out.print(
                            "Distância: ");

                    double distancia =
                            sc.nextDouble();

                    grafo.adicionarConexao(
                            origem,
                            destino,
                            distancia
                    );

                    System.out.println(
                            "Conexão adicionada!"
                    );

                    break;

                case 0:

                    System.out.println(
                            "Encerrando..."
                    );

                    break;

                default:

                    System.out.println(
                            "Opção inválida."
                    );
            }

        } while (opcao != 0);

        sc.close();
    }
}