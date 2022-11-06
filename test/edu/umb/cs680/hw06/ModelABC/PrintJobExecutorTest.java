package edu.umb.cs680.hw06.ModelABC;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw05.User;
import edu.umb.cs680.hw06.AuthenticationException;
import edu.umb.cs680.hw06.PrintJob;

import static org.junit.jupiter.api.Assertions.*;

public class PrintJobExecutorTest {
    @Test
    public void printingFailsForUserWithoutAuthentication() {
        PrintJobExecutor exec = new PrintJobExecutor();
        SecurityContext ctx = new SecurityContext(new User());
        EncryptedString pwd = new EncryptedString("FAIL_AUTH");
        PrintJob pj = new PrintJob();

        try {
            exec.execute(pj, pwd, ctx);
        } catch (AuthenticationException e) {
            String message = e.getMessage();
            assertEquals(message, "Authentication Failed");
            return;
        }
        fail("Unreachable");
    }

    @Test
    public void printingShouldNotFailIfUserIsAuthenticated() {
        PrintJobExecutor exec = new PrintJobExecutor();
        SecurityContext ctx = new SecurityContext(new User());
        EncryptedString pwd = new EncryptedString();
        PrintJob pj = new PrintJob();

        try {
            exec.execute(pj, pwd, ctx);
        } catch (AuthenticationException e) {
            fail("Unreachable");
        }
    }
}
