package Immutable.HowToCreateOwnImmutableClass;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class User {
    private String name;
    private String lastname;
    private int age;
    private Address address;
    private List<Language> languages;

    public User(String name, String lastname, int age, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
    }

    public User(String name, String lastname, int age, Address address, List<Language> languages) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
        this.languages = languages;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name)
                && Objects.equals(lastname, user.lastname)
                && Objects.equals(address, user.address)
                && Objects.equals(languages, user.languages);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, age, address, languages);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }


    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }


    public Address getAddress() {
        return address;
    }


    public List<Language> getLanguages() {
        return new ArrayList<>(languages);
    }
}



