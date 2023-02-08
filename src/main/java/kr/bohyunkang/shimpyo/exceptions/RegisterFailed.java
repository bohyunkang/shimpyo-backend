package kr.bohyunkang.shimpyo.exceptions;

public class RegisterFailed extends RuntimeException {
    public RegisterFailed() {
        super("Register failed!");
    }

    public RegisterFailed(String value) {
        super(value);
    }
}
