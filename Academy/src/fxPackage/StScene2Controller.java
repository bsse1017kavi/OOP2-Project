package fxPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StScene2Controller
{
    public void submit(ActionEvent e)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/uScene0.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
