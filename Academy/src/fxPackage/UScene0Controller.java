package fxPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class UScene0Controller
{
    private boolean isAdmin = false;

    @FXML private RadioButton r1;
    @FXML private  RadioButton r2;

    public void submit(ActionEvent e)throws Exception
    {
        if(r1.isSelected())
        {
            isAdmin = true;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/uScene1.fxml"));
        Parent root = loader.load();

        UScene1Controller controller = loader.getController();
        controller.initData(isAdmin);

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
