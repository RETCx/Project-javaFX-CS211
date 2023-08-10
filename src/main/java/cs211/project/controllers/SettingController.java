package cs211.project.controllers;

import cs211.project.services.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class SettingController {
    @FXML private AnchorPane menuPane ;
    @FXML private Button menuButton ;
    @FXML private Button menuButton1 ;
    @FXML private Button settingButton;
    @FXML private Button updateButton;

    public void initialize(){
        menuPane.setVisible(false);
        menuButton1.setVisible(false);
    }

    public void onMenuClickVisible(){
        menuPane.setVisible(true);
        menuButton.setVisible(false);
        menuButton1.setVisible(true);
    }

    public void onMenuClickInvisible(){
        menuPane.setVisible(false);
        menuButton.setVisible(true);
        menuButton1.setVisible(false);
    }

    public void goToHomeFromSetting(){
        try {
            FXRouter.goTo("home");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToLogInFromSetting(){
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
