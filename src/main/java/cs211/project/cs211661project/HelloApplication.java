package cs211.project.cs211661project;

import javafx.application.Application;
import javafx.stage.Stage;
import cs211.project.services.FXRouter;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        configRoute();
        FXRouter.bind(this, stage, "TravelBuddy");
        FXRouter.goTo("setting");
        stage.setHeight(720);
        stage.setWidth(1280);
    }

    private static void configRoute() {
        String resourcesPath = "cs211/project/views/";
        FXRouter.when("login", resourcesPath + "login.fxml");
        FXRouter.when("register",resourcesPath + "register.fxml");
        FXRouter.when("home",resourcesPath + "home.fxml");
        FXRouter.when("setting",resourcesPath + "setting.fxml");
    }


    public static void main(String[] args) {
        launch();
    }
}