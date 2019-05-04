package fxPackage;

import academyPackage.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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

            String fileName = "certificate.pdf";

            String header = "";
            for(int i=0;i<8;i++)header+="    ";
            header+="Certificate";

            String content = "I hereby certify that Mr."+student.getPersonal().getName()+", son of Mr."+student.getPersonal().getfName()+", ";
            String  text = "graduated from my institute securing cgpa "+student.getAcademic().getCgpa();

            String content1="His conduct was satisfactory.",content3 = "",content4 ="",content5 = "";

            for(int i=0;i<100;i++)content3+=" ";
            content3+="Director of IIT";
            for(int i=0;i<100;i++)content4+=" ";
            content4+="Mr.Shariful Islam";
            for(int i=0;i<100;i++)content5+=" ";
            content5+="Professor,Dhaka University";

            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();

            doc.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(doc,page);

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC,26);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50,700);

            contentStream.showText(header);
            for(int i=0;i<5;i++)contentStream.newLine();
            contentStream.setFont(PDType1Font.TIMES_ITALIC,14);
            contentStream.showText(content);
            contentStream.newLine();
            contentStream.showText(text);
            contentStream.newLine();
            contentStream.showText(content1);
            contentStream.newLine();;
            contentStream.showText(content3);
            contentStream.newLine();;
            contentStream.showText(content4);
            contentStream.newLine();;
            contentStream.showText(content5);
            contentStream.endText();

            contentStream.close();
            doc.save(fileName);
            doc.close();

            /*FileWriter fileWriter = new FileWriter(new File("certificate.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);






            bufferedWriter.write(content);
            bufferedWriter.close();
            fileWriter.close();*/

            Parent root = FXMLLoader.load(getClass().getResource("/stScene2.fxml"));
            Scene scene = new Scene(root);

            Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }

    }
}
