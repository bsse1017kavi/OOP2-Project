package academyPackage;

import java.io.*;
import java.util.ArrayList;

public class Academy
{
    private ArrayList<Admin> admins;
    private ArrayList<Student> students;

    File adminFile = new File("admins.txt");
    File studentFile = new File("students.txt");

    public Admin checkAdmin(String username,String password) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream(adminFile);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        admins = (ArrayList<Admin>)inputStream.readObject();

        for(Admin admin:admins)
        {
            if(username.equals(admin.getUsername()) && password.equals(admin.getPassword()))
            {
                return admin;
            }

        }

        return null;
    }

    public Student checkStudent(String name,String reg) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream(studentFile);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        students = (ArrayList<Student>)inputStream.readObject();

        for(Student student:students)
        {
            if(name.equals(student.getPersonal().getName()) && reg.equals(student.getAcademic().getReg()))
            {
                return student;
            }

        }

        return null;
    }

    public void updateCgpa(Student student,double cgpa) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream(studentFile);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        students = (ArrayList<Student>)inputStream.readObject();

        for(Student st:students)
        {
            if(st.getPersonal().getName().equals(student.getPersonal().getName()) && st.getAcademic().getReg().equals(student.getAcademic().getReg()))
            {
                st.getAcademic().setCgpa(cgpa);
                break;
            }

        }

        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(studentFile);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(students);

    }

    public void createAdmin(String username,String password) throws Exception
    {
        try
        {
            FileInputStream fstream = new FileInputStream(adminFile);
            ObjectInputStream inputStream = new ObjectInputStream(fstream);

            admins = (ArrayList<Admin>)inputStream.readObject();

            admins.add(new Admin(username,password));

            inputStream.close();

            fstream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(adminFile);

            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(admins);

            outputStream.close();

            fileOutputStream.close();

        }catch(FileNotFoundException e)
        {
            FileInputStream fstream = new FileInputStream(adminFile);
            ObjectInputStream inputStream = new ObjectInputStream(fstream);

            admins = new ArrayList<>();

            admins.add(new Admin(username,password));

            inputStream.close();

            fstream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(adminFile);

            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(admins);

            outputStream.close();

            fileOutputStream.close();
        }


    }

    public void createStudent(String name,String fName,String reg) throws IOException,ClassNotFoundException
    {
        try
        {
            FileInputStream fstream = new FileInputStream(studentFile);
            ObjectInputStream inputStream = new ObjectInputStream(fstream);

            students = (ArrayList<Student>)inputStream.readObject();

            students.add(new Student(name,fName,reg));

            inputStream.close();

            fstream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(studentFile);

            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(students);

            outputStream.close();

            fileOutputStream.close();

        }catch(FileNotFoundException e)
        {

            students = new ArrayList<>();

            students.add(new Student(name,fName,reg));

            FileOutputStream fileOutputStream = new FileOutputStream(studentFile);

            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(students);

            outputStream.close();

            fileOutputStream.close();
        }
    }
}
