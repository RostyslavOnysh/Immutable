package Immutable.HowToCreateOwnImmutableClass;

public class Address {
    private String address;
    private int housNomber;

    public Address(String address, int housNomber) {
        this.address = address;
        this.housNomber = housNomber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHousNomber() {
        return housNomber;
    }

    public void setHousNomber(int housNomber) {
        this.housNomber = housNomber;
    }
}
