package bankPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scene2Controller
{
    @FXML
    Label l1,l2;

    @FXML
    TextField tf1;

    Socket socket;

    double balance,ammount = 0;

    PrintStream printStream;
    Scanner sc;

    public void initData(String username,double balance,Socket socket)throws Exception
    {
        l1.setText(username);
        this.balance = balance;
        l2.setText(""+balance);
        this.socket = socket;
        printStream = new PrintStream(socket.getOutputStream());
        sc = new Scanner(socket.getInputStream());
    }

    public void withdraw(ActionEvent e)throws Exception
    {
        try{
            ammount = Double.parseDouble(tf1.getText());
        }catch (InputMismatchException ex)
        {
            ammount = 0;
        }

        if(tf1.getText()=="") ammount=0;

        String packet = "w~";
        packet+=ammount;

        printStream.println(packet);

        balance = sc.nextDouble();

        l2.setText(""+balance);

    }

    public void deposit(ActionEvent e)throws Exception
    {
        try{
            ammount = Double.parseDouble(tf1.getText());
        }catch (InputMismatchException ex)
        {
            ammount = 0;
        }

        if(tf1.getText()=="") ammount=0;

        String packet = "d~";
        packet+=ammount;

        printStream.println(packet);

        balance = sc.nextDouble();

        l2.setText(""+balance);
    }

    public void logOut(ActionEvent e)throws Exception
    {
        ammount = 0;
        String packet = "q~";
        packet+=ammount;

        printStream.println(packet);

        //balance = sc.nextDouble();

        //l2.setText(""+balance);

        Parent root = FXMLLoader.load(getClass().getResource("/scene0.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
