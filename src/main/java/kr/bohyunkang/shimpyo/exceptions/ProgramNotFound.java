package kr.bohyunkang.shimpyo.exceptions;

public class ProgramNotFound extends RuntimeException {
    public ProgramNotFound(Long id) {
        super("Program not found! Program id: " + id);
    }
}
