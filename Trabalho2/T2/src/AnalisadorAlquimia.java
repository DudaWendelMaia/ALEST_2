import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class AnalisadorAlquimia {
    private Grafo grafo;
    private Map<String, BigInteger> hydrogenNeeded;

    public AnalisadorAlquimia() {
        grafo = new Grafo();
        hydrogenNeeded = new HashMap<>();
    }

    public void leitura() {
        Scanner input = new Scanner(System.in);
        String nomeArquivo = "";
        while (true) {
            System.out.println("\n-----------------------------------------------------------------------");
            System.out.println("Menu:");
            System.out.println("1 - Calcular Hidrogênio");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            System.out.println("\n-----------------------------------------------------------------------");

            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Por favor, digite o caminho do arquivo a ser lido (use 'src/nomeArquivo'):");
                    nomeArquivo = input.nextLine();
                    try {
                        readAndProcessTestCases(nomeArquivo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private void readAndProcessTestCases(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        }
        calculateHydrogen();
    }

    private void processLine(String line) {
        String[] parts = line.split("->");
        String[] ingredients = parts[0].trim().split(" ");
        String product = parts[1].trim().split(" ")[1];
    
        BigInteger totalHydrogenCost = BigInteger.ZERO;
        for (int i = 0; i < ingredients.length; i += 2) {
            BigInteger quantityNeeded = new BigInteger(ingredients[i]);
            String element = ingredients[i + 1];
    
            BigInteger hydrogenCost = element.equals("hidrogenio") ? BigInteger.ONE : hydrogenNeeded.getOrDefault(element, BigInteger.ZERO);
    
            totalHydrogenCost = totalHydrogenCost.add(hydrogenCost.multiply(quantityNeeded));
            grafo.addEdge(product, element, quantityNeeded, hydrogenCost);
        }
    
        hydrogenNeeded.put(product, totalHydrogenCost);
    }

    private void calculateHydrogen() {
        hydrogenNeeded.clear(); 
        List<String> sortedElements = grafo.topologicalSort();
        Collections.reverse(sortedElements);
    
        for (String element : grafo.getGraph().keySet()) {
            hydrogenNeeded.putIfAbsent(element, BigInteger.ZERO);
        }
    
        hydrogenNeeded.put("hidrogenio", BigInteger.ONE);
    
        for (String element : sortedElements) {
            if (!element.equals("hidrogenio")) {
                BigInteger totalHydrogen = BigInteger.ZERO;
                for (Edge edge : grafo.getGraph().getOrDefault(element, Collections.emptyList())) {
                    BigInteger hydrogenForThisEdge = hydrogenNeeded.getOrDefault(edge.getTargetElement(), BigInteger.ZERO);
                    BigInteger quantityNeeded = edge.getQuantityNeeded();
                    totalHydrogen = totalHydrogen.add(hydrogenForThisEdge.multiply(quantityNeeded));
                }
                hydrogenNeeded.put(element, totalHydrogen);
            }
        }
        BigInteger totalHydrogenForGold = hydrogenNeeded.get("ouro");
        System.out.println("Total de hidrogênio necessário para formar 1 ouro: " + totalHydrogenForGold);
    }
}
