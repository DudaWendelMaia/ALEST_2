import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = "";

        while (true) {
            System.out.println("\n-----------------------------------------------------------------------");
            System.out.println("Menu:");
            System.out.println("1 - Realizar a mutação e calcular o tamanho da menor cadeia possível");
            System.out.println("2 - Exibir sequência de DNA original: ");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            System.out.println("\n-----------------------------------------------------------------------");


            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do arquivo a ser lido: ");
                    nomeArquivo = scanner.nextLine();
                    realizarMutacaoETamanhoMenorCadeia(nomeArquivo);
                    break;
                case 2:
                    if (!nomeArquivo.isEmpty()) {
                        exibirSequenciaDNA(nomeArquivo);
                    } else {
                        System.out.println("Você deve primeiro realizar a mutação para exibir a sequência mutada.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void realizarMutacaoETamanhoMenorCadeia(String nomeArquivo) {
        LinkedList novaLista = new LinkedList<Character>();
        try {
            LinkedList lista = new LinkedList<Character>();
            char c;
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String line = null;

            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    c = line.charAt(i);
                    lista.add(c);
                }
            }

            MutacaoDNA dnaMutado = new MutacaoDNA();
            long tempoInicial = System.currentTimeMillis();
            novaLista = dnaMutado.realizarMutacao(lista);
            System.out.println("O método executou em " + (System.currentTimeMillis() - tempoInicial));
            System.out.println("DNA mutado:" + novaLista.toString());
        } catch (IOException e) {
            System.err.println("Erro ao ler/escrever o arquivo: " + e.getMessage());
        }
    }

    private static void exibirSequenciaDNA(String nomeArquivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String dna = br.readLine();
            br.close();
            System.out.println("DNA original: " + dna);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
