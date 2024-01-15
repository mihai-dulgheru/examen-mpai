package designPatterns.prototype;

import java.util.HashMap;

public class PrototypeFactory {
    private static final HashMap<String, AContract> prototipuriContracte = new HashMap<>();

    static {
        System.out.println("Inițializare contracte prin citirea din BD...");
        ContractCorporate contractCorporate = new ContractCorporate();
        prototipuriContracte.put("corporate", contractCorporate);

        ContractParty contractParty = new ContractParty();
        prototipuriContracte.put("party", contractParty);
    }

    public static AContract getPrototipContract(String tip) throws CloneNotSupportedException {
        AContract contract = null;
        AContract prototipContract = prototipuriContracte.get(tip);
        if (prototipContract != null) contract = prototipContract.clone();
        return contract;
    }
}
