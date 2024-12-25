package split_wise.entities;

public class User {
    private String id;
    private final String name;
    private final String phoneNumber;
    private final String password;

    public User(String name, String phoneNumber, String password) {
        this.id = null;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(String id, User other) {
        this.id = id;
        this.name = other.name;
        this.phoneNumber = other.phoneNumber;
        this.password = other.password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
