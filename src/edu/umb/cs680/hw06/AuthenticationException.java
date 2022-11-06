package edu.umb.cs680.hw06;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        super("Authentication Failed");
    }
}