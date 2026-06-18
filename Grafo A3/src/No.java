public class No {
    String destino;
    double distancia;
    No prox;

    public No(String destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
        this.prox = null;
    }
}