package designPatterns.prototype;

import java.util.ArrayList;

public class ContractCorporate extends AContract {
    public ContractCorporate() {
        System.out.println("Incarcare contract corporate");
        // preluare date din baza de date (proces consumator)
        listaClauze = new ArrayList<>();
        listaClauze.add("clauza 1");
        listaClauze.add("clauza 2");
        this.tip = "corporate";
    }

    @Override
    void printare() {
        System.out.println("Contract de tip " + this.tip);
    }
}
