package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggedInTest {

    @Test
    public void singletonClassLoggedInIsSingleton() {
        LoggedIn inst1 = LoggedIn.getInstance(new SecurityContext(new User()));
        LoggedIn inst2 = LoggedIn.getInstance(null);

        assertSame(inst1, inst2);
    }

}


