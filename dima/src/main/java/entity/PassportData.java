package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PassportData {

    @Id
    @GeneratedValue
    private Long id;
    private String passportFirstTwoNumber;
    private Integer passportLastNumber;
    private Integer innCode;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportFirstTwoNumber() {
        return passportFirstTwoNumber;
    }

    public void setPassportFirstTwoNumber(String passportFirstTwoNumber) {
        this.passportFirstTwoNumber = passportFirstTwoNumber;
    }

    public int getPassportLastNumber() {
        return passportLastNumber;
    }

    public void setPassportLastNumber(int passportLastNumber) {
        this.passportLastNumber = passportLastNumber;
    }

    public int getInnCode() {
        return innCode;
    }

    public void setInnCode(int innCode) {
        this.innCode = innCode;
    }

    public PassportData(String firstTwoNum, Integer lastNum, Integer inn) {
        this.passportFirstTwoNumber = firstTwoNum;
        this.passportLastNumber = lastNum;
        this.innCode = inn;
    }

    public PassportData() {
    }

    @Override
    public String toString() {
        return "PassportData{" +
                "id=" + id +
                ", passportFirstTwoNumber='" + passportFirstTwoNumber + '\'' +
                ", passportLastNumber=" + passportLastNumber +
                ", innCode=" + innCode +
                '}';
    }
}
