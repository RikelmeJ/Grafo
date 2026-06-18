import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Grafo {

    private final int MAX = 20;

    private int[][] matrizAdj;

    private String[] creches;

    private int qtdCreches;

    private ListaEncadeada[] listas;

    private HashMap<String, Integer> mapa;

    public Grafo() {

        matrizAdj = new int[MAX][MAX];
        creches = new String[MAX];
        listas = new ListaEncadeada[MAX];

        mapa = new HashMap<>();

        qtdCreches = 0;
    }

    private int adicionarCreche(String nome) {

        if (mapa.containsKey(nome))
            return mapa.get(nome);

        creches[qtdCreches] = nome;
        listas[qtdCreches] = new ListaEncadeada();

        mapa.put(nome, qtdCreches);

        qtdCreches++;

        return qtdCreches - 1;
    }

    public void carregarArquivo(String caminho) throws IOException {

        BufferedReader br =
                new BufferedReader(new FileReader(caminho));

        String linha;

        while ((linha = br.readLine()) != null) {

            String[] dados = linha.split(";");

            String origem = dados[0];
            String destino = dados[1];
            double distancia =
                    Double.parseDouble(dados[2]);

            adicionarConexao(
                    origem,
                    destino,
                    distancia
            );
        }

        br.close();
    }

    public void adicionarConexao(
            String origem,
            String destino,
            double distancia) {

        int i = adicionarCreche(origem);
        int j = adicionarCreche(destino);

        matrizAdj[i][j] = 1;
        matrizAdj[j][i] = 1;

        listas[i].inserir(destino, distancia);
        listas[j].inserir(origem, distancia);
    }

    public void mostrarQuantidadeConexoes() {

        System.out.println("\nQuantidade de conexões:");

        for (int i = 0; i < qtdCreches; i++) {

            System.out.println(
                    creches[i]
                            + ": "
                            + listas[i].tamanho()
            );
        }
    }

    public void listarConexoes(String creche) {

        Integer indice = mapa.get(creche);

        if (indice == null) {
            System.out.println("Creche não encontrada.");
            return;
        }

        System.out.println(
                "\nConexões de " + creche);

        listas[indice].listarOrdenado();
    }

    public void consultarDistancia(
            String origem,
            String destino) {

        Integer i = mapa.get(origem);

        if (i == null) {
            System.out.println("Creche inexistente.");
            return;
        }

        Double d =
                listas[i].buscarDistancia(destino);

        if (d == null) {

            System.out.println(
                    "Não existe conexão direta.");
        }
        else {

            System.out.println(
                    "Distância: "
                            + d
                            + " km");
        }
    }
}