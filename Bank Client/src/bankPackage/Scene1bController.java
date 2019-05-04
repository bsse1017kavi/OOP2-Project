package bankPackage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Scene1bController
{

    @FXML
    TextField tf1;
    @FXML
    PasswordField tf2;

    public void submit(ActionEvent e) throws Exception
    {
        Socket socket = new Socket("localhost",1234);
        PrintStream ps = new PrintStream(socket.getOutputStream());
        Scanner sc = new Scanner(socket.getInputStream());

        String packet = "2~";
        packet+=tf1.getText()+"`";
        packet+=tf2.getText();

        ps.println(packet);

        double balance = sc.nextDouble();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Scene2Controller controller = loader.getController();
        controller.initData(tf1.getText(),balance,socket);

        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
