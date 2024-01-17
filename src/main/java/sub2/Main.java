package sub2;

import sub2.dataMapper.DataMapperException;
import sub2.dataMapper.client.ClientDataMapper;
import sub2.dataMapper.client.ClientDataMapperImplementation;
import sub2.mvc.client.Client;
import sub2.mvc.client.ClientController;
import sub2.mvc.client.ClientView;
import sub2.mvc.comanda.Comanda;
import sub2.mvc.comanda.ComandaController;
import sub2.mvc.comanda.ComandaView;
import sub2.mvc.comanda.state.StarePlasata;
import sub2.mvc.comanda.state.StarePlatita;
import sub2.mvc.magazin.Magazin;
import sub2.mvc.magazin.MagazinController;
import sub2.mvc.magazin.MagazinView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DataMapperException {
        Client client = new Client(1, "Nicu", "Marian");
        ClientView clientView = new ClientView();
        ClientController clientController = new ClientController(client, clientView);

        Comanda comanda = new Comanda(1, "detalii", 1);
        ComandaView comandaView = new ComandaView();
        ComandaController comandaController = new ComandaController(comanda, comandaView);

        List<Integer> listaComenzi = new ArrayList<>();
        listaComenzi.add(comanda.getId());

        Magazin magazin = new Magazin("Fish fish store", listaComenzi);
        MagazinView magazinView = new MagazinView();
        MagazinController magazinController = new MagazinController(magazin, magazinView);

        clientController.updateView();
        comandaController.updateView();
        magazinController.updateView();

        comanda.setStareComanda(new StarePlatita(comanda));
        comanda.getStareComanda().platesteComanda();

        comanda.setStareComanda(new StarePlasata(comanda));
        comanda.getStareComanda().platesteComanda();

        ClientDataMapper clientDataMapper = new ClientDataMapperImplementation();
        clientDataMapper.insert(client);
        clientDataMapper.update(new Client(1, "Actuatorul", "Meu"));

        Client clientFound = clientDataMapper.find(1);
        System.out.println(clientFound);
        clientDataMapper.delete(clientFound);
    }
}