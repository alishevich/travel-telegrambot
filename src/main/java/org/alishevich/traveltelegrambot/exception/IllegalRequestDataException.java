package org.alishevich.traveltelegrambot.exception;

public class IllegalRequestDataException extends RuntimeException{
    public IllegalRequestDataException(String msg) {
        super(msg);
    }
}
