import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    static final int[] tamanhosTesteGrande  = { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio   = {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,         12,          24,          48 };
    static Random aleatorio = new Random();
    static double nanoToMilli = 1.0 / 1_000_000;

    static int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++)
            vetor[i] = aleatorio.nextInt(1, tamanho / 2);
        return vetor;
    }

    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++)
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        return vetor;
    }

    static void exibirResultado(String metodo, IOrdenador<Integer> ordenador, Integer[] vetorOrdenado) {
        System.out.println("\nVetor ordenado método " + metodo + ":");
        System.out.println("Comparações:             " + ordenador.getComparacoes());
        System.out.println("Movimentações:           " + ordenador.getMovimentacoes());
        System.out.println("Tempo de ordenação (ms): " + ordenador.getTempoOrdenacao());
        System.out.println("Vetor ordenado:          " + Arrays.toString(vetorOrdenado));
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========= MENU DE ORDENAÇÃO =========");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Merge Sort");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 0) break;

            int tam = 20;
            Integer[] vetor = gerarVetorObjetos(tam);

            System.out.println("\nVetor original: " + Arrays.toString(vetor));

            switch (opcao) {
                case 1 -> {
                    BubbleSort<Integer> bolha = new BubbleSort<>();
                    exibirResultado("Bolha", bolha, bolha.ordenar(vetor));
                }
                case 2 -> {
                    InsertionSort<Integer> insertion = new InsertionSort<>();
                    exibirResultado("Inserção", insertion, insertion.ordenar(vetor));
                }
                case 3 -> {
                    SelectionSort<Integer> selection = new SelectionSort<>();
                    exibirResultado("Seleção", selection, selection.ordenar(vetor));
                }
                case 4 -> {
                    MergeSort<Integer> merge = new MergeSort<>();
                    exibirResultado("Merge", merge, merge.ordenar(vetor));
                }
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}