import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaEncadeada {

    private No inicio;

    public void inserir(String destino, double distancia) {

        No novo = new No(destino, distancia);

        if (inicio == null) {
            inicio = novo;
            return;
        }

        No atual = inicio;

        while (atual.prox != null) {
            atual = atual.prox;
        }

        atual.prox = novo;
    }

    public int tamanho() {

        int cont = 0;
        No atual = inicio;

        while (atual != null) {
            cont++;
            atual = atual.prox;
        }

        return cont;
    }

    public Double buscarDistancia(String destino) {

        No atual = inicio;

        while (atual != null) {

            if (atual.destino.equals(destino)) {
                return atual.distancia;
            }

            atual = atual.prox;
        }

        return null;
    }

    public void listarOrdenado() {

        ArrayList<No> lista = new ArrayList<>();

        No atual = inicio;

        while (atual != null) {
            lista.add(atual);
            atual = atual.prox;
        }

        Collections.sort(lista, Comparator.comparingDouble(n -> n.distancia));

        for (No n : lista) {
            System.out.println(
                    n.destino + " - " + n.distancia + " km");
        }
    }
}