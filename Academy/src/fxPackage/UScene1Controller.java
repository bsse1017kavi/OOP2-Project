package fxPackage;

import academyPackage.Academy;
import academyPackage.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UScene1Controller
{
    @FXML private TextField tf1;
    @FXML private PasswordField tf2;

    @FXML private Label l1,l2;

    private boolean isAdmin = false;

    public void initData(boolean isAdmin)
    {
        this.isAdmin = isAdmin;
        if(isAdmin)
        {
            l1.setText("username");
            l2.setText("password");
        }

        else
        {
            l1.setText("Name");
            l2.setText("Reg. No.");
        }
    }

    public void submit(ActionEvent e)throws Exception
    {
        Academy checker = new Academy();

        if(isAdmin)
        {
            String username = tf1.getText();
            String password = tf2.getText();

            if(checker.checkAdmin(username,password)!=null)
            {
                Parent root = FXMLLoader.load(getClass().getResource("/adScene1.fxml"));
                Scene scene = new Scene(root);

                Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
        }

        else
        {
            String name = tf1.getText();
            String reg = tf2.getText();

            Student student = checker.checkStudent(name,reg);

            if(student!=null)
            {
                FXMLLoader loader = new FXMLLoader((getClass().getResource("/stScene1.fxml")));
                Parent root = loader.load();

                StScene1Controller controller = loader.getController();
                controller.initData(student);

                Scene scene = new Scene(root);

                Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }

        }
    }
}
