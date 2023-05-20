package Immutable.muttableAndHashMap;

public class Address {
private String adress;
private int houseNumber;

    public Address(String adress, int houseNumber) {
        this.adress = adress;
        this.houseNumber = houseNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
