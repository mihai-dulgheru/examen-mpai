package designPatterns.memento;

public class VersiuneContract {
    private String clauzeContractuale;

    public VersiuneContract(String clauzeContractuale) {
        super();
        this.clauzeContractuale = clauzeContractuale;
    }

    public String getClauzeContractuale() {
        return clauzeContractuale;
    }
}
