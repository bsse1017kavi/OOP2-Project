package fxPackage;

import academyPackage.Academy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdScene2bController
{
    @FXML
    TextField tf1,tf2,tf3;

    public void submit(ActionEvent e)throws Exception
    {
        String name = tf1.getText();
        String fName = tf2.getText();
        String reg = tf3.getText();

        Academy academy = new Academy();
        academy.createStudent(name,fName,reg);

        Parent root = FXMLLoader.load(getClass().getResource("/uScene0.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
