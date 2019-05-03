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

    public void submit(ActionEvent e) throws IOException
    {
        Socket socket = new Socket("localhost",1234);
        PrintStream ps = new PrintStream(socket.getOutputStream());

        String packet = "2~";
        packet+=tf1.getText()+"`";
        packet+=tf2.getText();

        ps.println(packet);

        Parent root = FXMLLoader.load(getClass().getResource("/scene0.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
