package kr.bohyunkang.shimpyo.exceptions;

public class LoginFailed extends RuntimeException {
    public LoginFailed() {
        super("Login failed! ");
    }
}
