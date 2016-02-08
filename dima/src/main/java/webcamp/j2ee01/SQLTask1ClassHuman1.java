package webcamp.j2ee01;

public class SQLTask1ClassHuman1 {

    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private double height;
    private double weight;
    private int passport;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public int getPassport() {
        return passport;
    }
    public void setPassport(int passport) {
        this.passport = passport;
    }

    public SQLTask1ClassHuman1(int id, String lastName, String firstName, int age, double height, double weight, int passport) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.passport = passport;
    }

    public SQLTask1ClassHuman1(){};

    @Override
    public String toString() {
        return "SQLTask1ClassHuman1{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", passport=" + passport +
                '}';
    }
}
