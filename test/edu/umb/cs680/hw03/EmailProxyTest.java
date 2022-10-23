package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmailProxyTest {

    @Test
    public void getInstanceReturnsNotNullInstance() {
        EmailProxy cut = EmailProxy.getInstance("animal.com", new String[] { "cat.com", "dog.com" });
        assertNotNull(cut);
    }

    @Test
    public void getInstanceReturnsTheSameInstance() {
        EmailProxy inst1 = EmailProxy.getInstance("animal.com", new String[] { "cat.com", "dog.com" });
        EmailProxy inst2 = EmailProxy.getInstance(null, null);

        assertSame(inst1, inst2);
    }

    @Test
    public void setEmail_ByIdAndRetriveTheEmailBackWith_getEmail() {
        EmailProxy ep = EmailProxy.getInstance("animal.com", new String[] { "cat.com", "dog.com" });

        String expected = "example@hello.com";
        ep.setEmail(10, expected);
        String result = ep.getEmail(10);

        assertEquals(expected, result);
    }

    @Test
    public void properProxiedEmailIsReturned() {
        EmailProxy ep = EmailProxy.getInstance("animal.com", new String[] { "cat.com", "dog.com" });

        ep.setEmail(10, "tom@cat.com");
        ep.setEmail(11, "doge@dog.com");

        String result1 = ep.getEmail(10);
        String expected1 = "tom@animal.com";
        assertEquals(expected1, result1);

        String result2 = ep.getEmail(11);
        String expected2 = "doge@animal.com";
        assertEquals(result2, expected2);
    }

    @Test
    public void setEmail_Returns_true_OnProxyiedEmail() {
        EmailProxy ep = EmailProxy.getInstance("animal.com", new String[] { "cat.com", "dog.com" });

        var result1 = ep.setEmail(10, "tom@cat.com");
        var result2 = ep.setEmail(11, "doge@dog.com");

        var expected1 = true;
        assertEquals(expected1, result1);

        var expected2 = true;
        assertEquals(result2, expected2);
    }
}
