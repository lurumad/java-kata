package org.kata;

public class YahtzeeException extends RuntimeException {
    public final static String playerCannotAssignToAlreadyAssignedCategory = "Player cannot assign to already assigned category";

    public YahtzeeException(String message) {
        super(message);
    }

    public static YahtzeeException playerCannotAssignToAlreadyAssignedCategory() {
        return new YahtzeeException(playerCannotAssignToAlreadyAssignedCategory);
    }
}
