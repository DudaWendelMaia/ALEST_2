import java.math.BigInteger;
import java.util.*;

public class Grafo {
    private Map<String, List<Edge>> graph = new HashMap<>();
    private Map<String, BigInteger> usageCount = new HashMap<>();

    public void addEdge(String sourceElement, String targetElement, BigInteger quantityNeeded, BigInteger hydrogenCost) {
        Edge edge = new Edge(sourceElement, targetElement, quantityNeeded, hydrogenCost);
        graph.computeIfAbsent(sourceElement, k -> new ArrayList<>()).add(edge);

        usageCount.put(targetElement, usageCount.getOrDefault(targetElement, BigInteger.ZERO).add(quantityNeeded));
    }

    public List<String> topologicalSort() {
        Set<String> visited = new HashSet<>();
        Set<String> recursionStack = new HashSet<>();
        List<String> result = new ArrayList<>();
    
        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                if (isCyclicUtil(node, visited, recursionStack, result)) {
                    throw new RuntimeException("Cyclic dependency detected");
                }
            }
        }
    
        Collections.reverse(result);
        return result;
    }
    
    private boolean isCyclicUtil(String node, Set<String> visited, Set<String> recursionStack, List<String> result) {
        visited.add(node);
        recursionStack.add(node);
    
        for (Edge edge : graph.getOrDefault(node, Collections.emptyList())) {
            String neighbor = edge.getTargetElement();
            if (!visited.contains(neighbor) && isCyclicUtil(neighbor, visited, recursionStack, result)) {
                return true;
            } else if (recursionStack.contains(neighbor)) {
                return true;
            }
        }
    
        recursionStack.remove(node);
        result.add(node);
        return false;
    }

    public BigInteger getUsageCount(String element) {
    BigInteger count = BigInteger.ZERO;
    for (List<Edge> edges : graph.values()) {
        for (Edge edge : edges) {
            if (edge.getTargetElement().equals(element)) {
                count = count.add(edge.getQuantityNeeded());
            }
        }
    }
    return count;
}
    public Map<String, List<Edge>> getGraph() {
        return graph;
    }

    public void clearUsageCount() {
        usageCount.clear();
    }
}
