package fxPackage;

import academyPackage.Academy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AdScene2aController
{
    @FXML
    TextField tf1;
    @FXML
    PasswordField tf2;

    public void submit(ActionEvent e) throws Exception
    {
        String username = tf1.getText();
        String password = tf2.getText();

        Academy academy = new Academy();
        academy.createAdmin(username,password);

        Parent root = FXMLLoader.load(getClass().getResource("/uScene0.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
