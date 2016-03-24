package examples.entity;


public class UserDTO {
    private String name;
    private String lastName;
    private String password;


    public UserDTO(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public UserDTO() {
    }

    public UserDTO(String name, String lastName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
