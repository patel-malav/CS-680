package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticatorTest {
    
    @Test
    public void authenticateAlwaysReturnsTrue() {
        assertTrue(Authenticator.authenticate(null, null));
    }
}
