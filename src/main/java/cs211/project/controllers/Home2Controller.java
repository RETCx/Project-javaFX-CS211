package cs211.project.controllers;

import cs211.project.services.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class Home2Controller {
    @FXML
    private AnchorPane menuPane ;
    @FXML private Button menuOpenButton ;
    @FXML private Button menuCloseButton ;
    @FXML private GridPane eventPane ;


    public void initialize(){
        menuPane.setVisible(false);
        menuCloseButton.setVisible(false);
    }
    public void onMenuClickVisible(){
        menuPane.setVisible(true);
        menuOpenButton.setVisible(false);
        menuCloseButton.setVisible(true);
    }

    public void onMenuClickInvisible(){
        menuPane.setVisible(false);
        menuOpenButton.setVisible(true);
        menuCloseButton.setVisible(false);
    }

    public void onSettingClick(){
        try {
            FXRouter.goTo("setting");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToLogIn(){
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
