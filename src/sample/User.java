package sample;

public class User {
    private String firsName;
    private String lastName;
    private String userName;
    private String password;
    private String location;
    private String gander;

    public User(String firsName, String lastName, String userName, String password, String location, String gander) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gander = gander;
    }

    public User() {

    }


    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }
}
