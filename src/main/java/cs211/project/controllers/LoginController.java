package cs211.project.controllers;

import cs211.project.services.FXRouter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML private Label  warringMessage ;
    @FXML private TextField userNameLabel ;
    @FXML private TextField passwordLabel ;

    public void setVisibleWarringMessage(boolean status){
        warringMessage.setVisible(status);
    }


    public void textFieldAction(){}


    public void lengthUserAndPasswordGraterThatZero(int lengthUser,int lengthPassword){
        if(lengthUser > 0 && lengthPassword > 0){
            setVisibleWarringMessage(false);
        }
    }
    public void gotoHomeFromLogin() throws IOException {
        //isEmpty is true if length is 0
        if(userNameLabel.getText().isEmpty() || passwordLabel.getText().isEmpty() ){
            setVisibleWarringMessage(true);
            warringMessage.setText("Please enter username and password!!");
            return;
        }
        FXRouter.goTo("home");
    }

    /*public void checkAdmin(String admin,String password){
        if(admin.equals("admin") && password.equals("admin12345")){
            FXRouter.goTo("adminInterface");
        }
    }*/

    public void gotoRegisterFromLogin() throws IOException {
        FXRouter.goTo("register");
    }


    public void initialize(){
        setVisibleWarringMessage(false);

        // Add a listener to the text property of the TextField
        userNameLabel.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Calculate and display the length of the current text
                int length = newValue.length();
                lengthUserAndPasswordGraterThatZero(length, passwordLabel.getLength());
                System.out.println("Text length: " + length);
            }
        });
        passwordLabel.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Calculate and display the length of the current text
                int length = newValue.length();
                lengthUserAndPasswordGraterThatZero(userNameLabel.getLength(), length);
                System.out.println("Text length: " + length);
            }
        });
        //checkAdmin(userNameLabel.getText(),passwordLabel.getText());






    }


}
