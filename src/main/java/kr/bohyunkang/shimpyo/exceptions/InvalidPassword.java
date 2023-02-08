package kr.bohyunkang.shimpyo.exceptions;

public class InvalidPassword extends RegisterFailed {
    public InvalidPassword() {
        super("Invalid password! Please try again!");
    }
}
