package kr.bohyunkang.shimpyo.exceptions;

public class InvalidNickname extends RegisterFailed {
    public InvalidNickname() {
        super("Invalid nickname! Please check the nickname!");
    }
}
