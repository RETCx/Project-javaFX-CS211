package cs211.project.controllers;

import cs211.project.models.User;
import cs211.project.models.UserList;
import cs211.project.services.Datasource;
import cs211.project.services.FXRouter;
import cs211.project.services.UserListFileDatasource;
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

    private Datasource<UserList> datasource;
    private UserList userList;
    private User user;

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

        String enteredUsername = userNameLabel.getText();
        String enteredPassword = passwordLabel.getText();
        //isEmpty is true if length is 0
        if(enteredUsername.isEmpty() || enteredPassword.isEmpty() ){
            setVisibleWarringMessage(true);
            warringMessage.setText("Please enter username and password!!");
            return;
        }
        userList = datasource.readData();
        // find user that matches the enteredUsername and null if no matching user is found.
        user = userList.findUserByUsername(enteredUsername);
        //

        if(user != null && user.validatePassword(enteredPassword)){
            FXRouter.goTo("home");
        }
        else{
            setVisibleWarringMessage(true);
            warringMessage.setText("Invalid username or password");

        }
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
        // make datasource not null
        datasource = new UserListFileDatasource("Data", "users.csv");
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
