package cs211.project.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
public class User {
    private  String username ;
    private String password ;
    private String name ;


    public User(String username,String name) {
        this.username = username;
        this.name = name;
        password = null;
    }

    public User(String username, String password,String name) {
        this(username,name);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        // more info: https://github.com/patrickfav/bcrypt
        this.password = BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public boolean validatePassword(String password) {
        // more info: https://github.com/patrickfav/bcrypt
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), this.password);
        return result.verified;
    }

    public void setName(String name) {
        this.name = name;
    }


    // check username
    public boolean isUsername(String username) {
        return this.username.equals(username);
    }
}
