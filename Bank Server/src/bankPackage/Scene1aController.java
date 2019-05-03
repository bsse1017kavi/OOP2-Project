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
import java.io.InvalidObjectException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scene1aController
{

    @FXML
    TextField tf1;
    @FXML
    PasswordField tf2;
    @FXML TextField tf3;

    public void submit(ActionEvent e) throws IOException
    {
        Socket socket = new Socket("localhost",1234);
        PrintStream ps = new PrintStream(socket.getOutputStream());

        String packet = "1~";
        packet+=tf1.getText()+"`";

        Pattern pattern=Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
        Matcher m = pattern.matcher(tf2.getText());

        if(m.find())packet+=tf2.getText()+"`";
        else
        {
            System.out.println("Invalid Password");
            throw new InvalidObjectException("Invalid password");
        }
        packet+=tf3.getText();

        ps.println(packet);

        Parent root = FXMLLoader.load(getClass().getResource("/scene0.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
