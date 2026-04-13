import java.util.Arrays;
import java.util.Random;

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;        
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }


    public static void main(String[] args) {
        int tam = 20;
        Integer[] vetor = gerarVetorObjetos(tam);

        BubbleSort<Integer> bolha = new BubbleSort<>();
        InsertionSort<Integer> insertion = new InsertionSort<>();
        SelectionSort<Integer> selection = new SelectionSort<>();

        Integer[] vetorOrdenadoBolha = bolha.ordenar(vetor);
        Integer[] vetorOrdenadoInsertion = insertion.ordenar(vetor);
        Integer[] vetorOrdenadoSelection = selection.ordenar(vetor);

        System.out.println("\nVetor ordenado método Bolha:");
        System.out.println("Comparações: " + bolha.getComparacoes());
        System.out.println("Movimentações: " + bolha.getMovimentacoes());
        System.out.println("Tempo de ordenação (ms): " + bolha.getTempoOrdenacao());
        System.out.println("Vetor ordenado: " + Arrays.toString(vetorOrdenadoBolha));
        System.out.println("-------------------------------------------------");

        System.out.println("\nVetor ordenado método Inserção:");
        System.out.println("Comparações: " + insertion.getComparacoes());
        System.out.println("Movimentações: " + insertion.getMovimentacoes());
        System.out.println("Tempo de ordenação (ms): " + insertion.getTempoOrdenacao());
        System.out.println("Vetor ordenado: " + Arrays.toString(vetorOrdenadoInsertion));
        System.out.println("-------------------------------------------------");

        System.out.println("\nVetor ordenado método Seleção:");
        System.out.println("Comparações: " + selection.getComparacoes());
        System.out.println("Movimentações: " + selection.getMovimentacoes());
        System.out.println("Tempo de ordenação (ms): " + selection.getTempoOrdenacao());
        System.out.println("Vetor ordenado: " + Arrays.toString(vetorOrdenadoSelection));
        System.out.println("-------------------------------------------------");

    }
}
