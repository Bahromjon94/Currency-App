package uz.itjunior.currency.app;

public class Currency {

    private int imgFlag;
    private String name;
    private String fullName;
    private double value;

    public Currency(int imgFlag, String name, String fullName, double value) {
        this.imgFlag = imgFlag;
        this.name = name;
        this.fullName = fullName;
        this.value = value;
    }

    public int getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(int imgFlag) {
        this.imgFlag = imgFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
