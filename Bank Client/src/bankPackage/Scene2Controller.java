package bankPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Scene2Controller
{
    @FXML
    Label l1,l2;

    @FXML
    TextField tf1;

    double balance;

    public void initData(String username,double balance)
    {
        l1.setText(username);
        this.balance = balance;
        l2.setText(""+balance);
    }

    public void withdraw(ActionEvent e)throws Exception
    {

    }

    public void deposit(ActionEvent e)throws Exception
    {

    }
}
