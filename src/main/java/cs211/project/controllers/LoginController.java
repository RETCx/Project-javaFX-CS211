package cs211.project.controllers;

import cs211.project.services.FXRouter;

import java.io.IOException;

public class LoginController {



    public void gotoHomeFromLogin() throws IOException {
        FXRouter.goTo("home");
    }

    public void gotoRegisterFromLogin() throws IOException {
        FXRouter.goTo("register");
    }
}
