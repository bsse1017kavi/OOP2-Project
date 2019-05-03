package academyPackage;

import java.io.Serializable;

public class Personal implements Serializable
{
    private String name;
    private String fName;

    public Personal(String name, String fName)
    {
        this.name = name;
        this.fName = fName;
    }

    public String getName() {
        return name;
    }

    public String getfName() {
        return fName;
    }
}
