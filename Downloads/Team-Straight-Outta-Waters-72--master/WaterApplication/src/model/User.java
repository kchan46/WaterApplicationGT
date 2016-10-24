package model;

/**
 * A basic User
 */
public class User implements Account {
    private String name;
    private String username;
    private String password;
    private String email;
    private String homeAddress;
    private String title;

    public User(String name, String username, String password) {
        this(name, username, password, null, null, null);
    }

    public User(String name, String username, String password, String email) {
        this(name, username, password, email, null, null);
    }

    public User(String name, String username, String password, String email, String homeAddress) {
        this(name, username, password, email, homeAddress, null);
    }

    public User(String name, String username, String password, String email, String homeAddress, String title) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.title = title;
        this.homeAddress = homeAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public void setPass(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }
    public String getUser() {
        return username;
    }
    public String getPass() {
        return password;
    }
    public String getEmail() { return email; }
    public String getAddress() { return homeAddress; }
    public String getTitle() { return title; }
    public String getType() { return "User"; }

    public String toString() {
        return "Account Owner: " + name;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Account) && ((Account) o).getUser().equals(username) && ((Account) o).getPass().equals(password);
    }
}
