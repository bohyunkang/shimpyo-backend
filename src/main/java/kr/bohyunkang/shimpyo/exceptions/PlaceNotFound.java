package kr.bohyunkang.shimpyo.exceptions;

public class PlaceNotFound extends RuntimeException {
    public PlaceNotFound(Long id) {
        super("Place not found! Place id: " + id);
    }
}
