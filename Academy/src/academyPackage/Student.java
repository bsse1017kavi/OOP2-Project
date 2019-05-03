package academyPackage;

import java.io.Serializable;

public class Student implements Serializable
{
    private Personal personal;
    private Academic academic;

    public Student(String name,String fName,String reg)
    {
        this.personal = new Personal(name,fName);
        this.academic = new Academic(reg,0.0);
    }

    public Personal getPersonal() {
        return personal;
    }

    public Academic getAcademic() {
        return academic;
    }
}
