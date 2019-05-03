package fxPackage;

import academyPackage.Academy;
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

public class AdScene2cController
{
    @FXML
    TextField tf1;
    @FXML
    PasswordField tf2;

    public void submit(ActionEvent e) throws Exception
    {
        String name = tf1.getText();
        String reg = tf2.getText();

        Academy academy = new Academy();
        Student student = academy.checkStudent(name,reg);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/adScene3.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        AdScene3Controller controller = loader.getController();
        controller.initData(student);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
