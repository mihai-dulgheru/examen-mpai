package sub2.mvc.client;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String nume;
    private String prenume;

    public Client(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        // return super.hashCode();
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        // return super.equals(obj);
        if (obj instanceof Client client) {
            return id == client.id;
        }
        return false;
    }
}
