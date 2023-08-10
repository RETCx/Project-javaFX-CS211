package cs211.project.controllers;

import cs211.project.services.FXRouter;

import java.io.IOException;

public class RegisterController {

    public  void gotoHomeFromRegister() throws IOException {
        FXRouter.goTo("home");
    }

    public  void gotoLoginFromRegister() throws IOException {
        FXRouter.goTo("login");
    }

}
