package sub1.main;

import sub1.main.mvp.client.Client;
import sub1.main.mvp.client.ClientPresenter;
import sub1.main.mvp.client.ClientView;
import sub1.main.mvp.client.ClientViewImpl;
import sub1.main.mvp.service.Service;
import sub1.main.mvp.service.ServicePresenter;
import sub1.main.mvp.service.ServiceView;
import sub1.main.mvp.service.ServiceViewImpl;
import sub1.main.mvp.solicitare.Solicitare;
import sub1.main.mvp.solicitare.SolicitarePresenter;
import sub1.main.mvp.solicitare.SolicitareView;
import sub1.main.mvp.solicitare.SolicitareViewImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Nume", "Prenume");
        ClientView clientView = new ClientViewImpl();
        ClientPresenter clientPresenter = new ClientPresenter(client, clientView);
        clientPresenter.updateView();

        Service service = new Service("Service", "Adresa", new String[]{"Angajat1", "Angajat2"});
        ServiceView serviceView = new ServiceViewImpl();
        ServicePresenter servicePresenter = new ServicePresenter(service, serviceView);
        servicePresenter.updateView();

        Solicitare solicitare = new Solicitare("Problema", "Loc", clientPresenter.getClient());
        SolicitareView solicitareView = new SolicitareViewImpl();
        SolicitarePresenter solicitarePresenter = new SolicitarePresenter(solicitare, solicitareView);
        solicitarePresenter.updateView();

        client.insert();

        try {
            Client client1 = Client.citire().getFirst();
            System.out.println(client1);
            client1.update(new Client("Faianța", "Mea"));
            Client client2 = Client.citire().getFirst();
            System.out.println(client2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        service.addObserver(client);
        service.notifyAll("Solicitare transmisă");
    }
}
