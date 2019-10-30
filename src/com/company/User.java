package com.company;

public class User {
    protected String name, login, password;
    User(){}
    User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
    public boolean enter(String login, String password){
        return this.login.equals(login) && this.password.equals(password);
    }
    public String getName(){
        return this.name;
    }
    public String getLogin() { return this.login; }
    public String getPassword() { return this.password; }
}
