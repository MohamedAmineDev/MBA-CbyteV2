package Modele;

public class Compte {
    private String userName;
    private String password;

    public Compte() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "username=" + userName + ",password=" + password + "";
    }
}
