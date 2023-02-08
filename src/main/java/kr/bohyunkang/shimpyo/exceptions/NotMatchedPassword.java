package kr.bohyunkang.shimpyo.exceptions;

public class NotMatchedPassword extends RegisterFailed {
    public NotMatchedPassword() {
        super("Password not match! Please try again!");
    }
}
