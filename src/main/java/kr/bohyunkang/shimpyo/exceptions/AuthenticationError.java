package kr.bohyunkang.shimpyo.exceptions;

public class AuthenticationError extends RuntimeException {
    public AuthenticationError() {
        super("Authentication error!");
    }
}
