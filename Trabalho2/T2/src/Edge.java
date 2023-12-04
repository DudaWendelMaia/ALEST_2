import java.math.BigInteger;

public class Edge {
    private String sourceElement;
        private String targetElement;
        private BigInteger quantityNeeded;
        private BigInteger hydrogenCost;

        public Edge(String sourceElement, String targetElement, BigInteger quantityNeeded, BigInteger hydrogenCost) {
            this.sourceElement = sourceElement;
            this.targetElement = targetElement;
            this.quantityNeeded = quantityNeeded;
            this.hydrogenCost = hydrogenCost;
        }

    public String getSourceElement() {
        return sourceElement;
    }

    public String getTargetElement() {
        return targetElement;
    }

    public BigInteger getHydrogenCost() {
        return hydrogenCost;
    }

    public BigInteger getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setTargetElement(String targetElement) {
        this.targetElement = targetElement;
    }

    public void setHydrogenCost(BigInteger hydrogenCost) {
        this.hydrogenCost = hydrogenCost;
    }

    public void setQuantityNeeded(BigInteger quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public void setSourceElement(String sourceElement) {
        this.sourceElement = sourceElement;
    }
}
