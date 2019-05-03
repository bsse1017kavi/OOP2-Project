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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AdScene3Controller
{
    private double new_cgpa;

    @FXML
    Label l1;

    @FXML
    TextField tf1;

    Student student;

    public void submit(ActionEvent e) throws Exception
    {
        new_cgpa = Double.parseDouble(tf1.getText());

        Academy academy = new Academy();
        academy.updateCgpa(student,new_cgpa);

        Parent root = FXMLLoader.load(getClass().getResource("/uScene0.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void initData(Student student)
    {
        this.student = student;
        l1.setText(""+student.getAcademic().getCgpa());
    }
}
