package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggedOutTest {

    @Test
    public void singletonClassLoggedOutIsSingleton() {
        LoggedOut inst1 = LoggedOut.getInstance(new SecurityContext(new User()));
        LoggedOut inst2 = LoggedOut.getInstance(null);

        assertSame(inst1, inst2);
    }
}
