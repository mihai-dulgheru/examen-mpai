package designPatterns.prototype;

import java.util.ArrayList;

public class ContractParty extends AContract {
    public ContractParty() {
        System.out.println("Incarcare contract party");
        // proces consumator(preluare din BD)
        listaClauze = new ArrayList<>();
        listaClauze.add("clauza 1");
        listaClauze.add("clauza 2");
        this.tip = "party";
    }

    @Override
    void printare() {
        System.out.println("Contract de tip " + this.tip);
    }

    @Override
    public AContract clone() {
        AContract clone = super.clone();
        clone.listaClauze = new ArrayList<>();
        for (int i = 0; i < this.listaClauze.size(); i++) {
            clone.listaClauze.add(this.listaClauze.get(i));
        }

        return clone;
    }
}
