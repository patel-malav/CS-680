package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecurityContextTest {

    @Test
    public void singletonClassLoggedOutIsSingleton() {
        LoggedOut inst1 = LoggedOut.getInstance(new SecurityContext(new User()));
        LoggedOut inst2 = LoggedOut.getInstance(null);

        assertSame(inst1, inst2);
    }

    @Test
    public void singletonClassLoggedInIsSingleton() {
        LoggedIn inst1 = LoggedIn.getInstance(new SecurityContext(new User()));
        LoggedIn inst2 = LoggedIn.getInstance(null);

        assertSame(inst1, inst2);
    }

    @Test
    public void defaultStateIsLoggedOut() {
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void stateIsLoggedOutWhen_logout_isCalledOnLoggedOutState() {
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.getState() instanceof LoggedOut);

        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void stateIsLoggedInWhen_login_isCalledOnLoggedOutState() {
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.getState() instanceof LoggedOut);

        ctx.login(new EncryptedString());
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void stateIsLoggedInWhen_login_isCalledOnLoggedInState() {
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.getState() instanceof LoggedOut);

        ctx.login(new EncryptedString());
        assertTrue(ctx.getState() instanceof LoggedIn);

        ctx.login(new EncryptedString());
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void stateIsLoggedOutWhen_logout_isCalledOnLoggedInState() {
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.getState() instanceof LoggedOut);

        ctx.login(new EncryptedString());
        assertTrue(ctx.getState() instanceof LoggedIn);

        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);
    }
}
