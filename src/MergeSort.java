import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements IOrdenador<T>{
    private long comparacoes;
    private long movimentacoes;
    private double tempoOrdenacao;
    private double inicio;

    private double nanoToMilli = 1.0/1_000_000;

    @Override
    public long getComparacoes() {
        return comparacoes;
    }

    @Override
    public long getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public double getTempoOrdenacao() {
        return tempoOrdenacao;
    }

    private void iniciar(){
        this.comparacoes = 0;
        this.movimentacoes = 0;
        this.inicio = System.nanoTime();
    }

    private void terminar(){
        this.tempoOrdenacao = (System.nanoTime() - this.inicio) * nanoToMilli;
    }

    private void swap(int x, int y, T[] vetor) {
        T temp = vetor[x];
        vetor[x] = vetor[y];
        vetor[y] = temp;
        movimentacoes+=3;
    }

    @Override
    public T[] ordenar(T[] dados) {
        T[] dadosOrdenados = Arrays.copyOf(dados, dados.length);
        iniciar();
        mergeSort(dadosOrdenados, 0, dadosOrdenados.length - 1);
        terminar();
        return dadosOrdenados;
    }

    private void mergeSort(T[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(vetor, esquerda, meio);
            mergeSort(vetor, meio + 1, direita);
            merge(vetor, esquerda, meio, direita);
        }
    }

    private void merge(T[] vetor, int esquerda, int meio, int direita) {
        T[] temp = Arrays.copyOfRange(vetor, esquerda, direita + 1);
        int tamanhoEsq = meio - esquerda + 1;

        int i = 0;
        int j = tamanhoEsq;
        int k = esquerda;

        while (i < tamanhoEsq && j < temp.length) {
            comparacoes++;
            if (temp[i].compareTo(temp[j]) <= 0) {
                vetor[k] = temp[i];
                i++;
            } else {
                vetor[k] = temp[j];
                j++;
            }
            movimentacoes++;
            k++;
        }

        while (i < tamanhoEsq) {
            vetor[k] = temp[i];
            movimentacoes++;
            i++;
            k++;
        }

        while (j < temp.length) {
            vetor[k] = temp[j];
            movimentacoes++;
            j++;
            k++;
        }
    }
}
