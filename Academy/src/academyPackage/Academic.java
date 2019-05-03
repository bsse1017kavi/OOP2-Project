package academyPackage;

import java.io.Serializable;

public class Academic implements Serializable
{
    private String reg;
    private double cgpa;

    public Academic(String reg, double cgpa) {
        this.reg = reg;
        this.cgpa = cgpa;
    }

    public String getReg() {
        return reg;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
