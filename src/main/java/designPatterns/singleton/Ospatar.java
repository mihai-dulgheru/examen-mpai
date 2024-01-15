package designPatterns.singleton;

public class Ospatar {
    private String nume;
    private Restaurant restaurant;

    public Ospatar(String nume) throws Exception {
        super();
        this.nume = nume;
        restaurant = Restaurant.getInstance();
    }

    public void preiaClient(int nrMasa) {
        restaurant.setOcupareMasa(nrMasa);
    }

    public void inchidereComanda(int nrMasa) {
        restaurant.setEliberareMasa(nrMasa);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
