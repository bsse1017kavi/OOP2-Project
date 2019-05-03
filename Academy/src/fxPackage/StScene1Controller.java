package fxPackage;

import academyPackage.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class StScene1Controller
{
    @FXML
    TextField tf1;
    @FXML
    PasswordField tf2;

    private Student student;

    boolean confirmation;

    public void initData(Student student)
    {
        this.student = student;
    }

    public void submit(ActionEvent e) throws Exception
    {
        String username = tf1.getText();
        String password = tf2.getText();

        String packet = "3~";
        packet+=username+"`"+password;

        Socket socket = new Socket("localhost",1234);
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println(packet);

        Scanner sc = new Scanner(socket.getInputStream());
        confirmation = sc.nextBoolean();

        if(confirmation)
        {
            //System.out.println("Ok");
            FileWriter fileWriter = new FileWriter(new File("certificate.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String content = "I herby certify that Mr."+student.getPersonal().getName()+", son of Mr."+student.getPersonal().getfName()+
            "\ngraduated from my institute securing cgpa "+student.getAcademic().getCgpa()+". His conduct was satisfactory.\n\n";

            for(int i=0;i<12;i++)content+="\t";
            content+="Director of IIT\n";
            for(int i=0;i<12;i++)content+="\t";
            content+="Mr.Shariful Islam\n";
            for(int i=0;i<12;i++)content+="\t";
            content+="Professor,Dhaka University\n";


            bufferedWriter.write(content);
            bufferedWriter.close();
            fileWriter.close();

        }

    }
}
