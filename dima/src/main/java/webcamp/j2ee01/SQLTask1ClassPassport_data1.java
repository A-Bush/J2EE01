package webcamp.j2ee01;

public class SQLTask1ClassPassport_data1 {

    private int id;
    private String first_two_num;
    private int last_num;
    private int inn;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirst_two_num() {
        return first_two_num;
    }
    public void setFirst_two_num(String first_two_num) {
        this.first_two_num = first_two_num;
    }
    public int getLast_num() {
        return last_num;
    }
    public void setLast_num(int last_num) {
        this.last_num = last_num;
    }
    public int getInn() {
        return inn;
    }
    public void setInn(int inn) {
        this.inn = inn;
    }

    public SQLTask1ClassPassport_data1(int id, String first_two_num, int last_num, int inn) {
        this.id = id;
        this.first_two_num = first_two_num;
        this.last_num = last_num;
        this.inn = inn;
    }

    public SQLTask1ClassPassport_data1(){};
}
