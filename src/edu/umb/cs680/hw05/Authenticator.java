package edu.umb.cs680.hw05;

public class Authenticator {
    public static boolean authenticate(SecurityContext ctx, EncryptedString pwd) {
        if (pwd.password == "FAIL_AUTH") return false;
        return true;
    }
}
