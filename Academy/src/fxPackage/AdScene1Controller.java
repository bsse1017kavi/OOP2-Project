package fxPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdScene1Controller
{
    public void createAccount(ActionEvent e) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/adScene2a.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void createStudentAccount(ActionEvent e) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/adScene2b.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void updateResult(ActionEvent e) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/adScene2c.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
