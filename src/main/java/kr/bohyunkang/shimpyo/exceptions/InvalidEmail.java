package kr.bohyunkang.shimpyo.exceptions;

public class InvalidEmail extends RegisterFailed {
    public InvalidEmail() {
        super("Invalid email! Please check the email!");
    }
}
