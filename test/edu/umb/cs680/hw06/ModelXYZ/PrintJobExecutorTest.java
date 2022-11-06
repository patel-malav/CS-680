package edu.umb.cs680.hw06.ModelXYZ;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.AuthenticationException;
import edu.umb.cs680.hw06.PrintJob;

import static org.junit.jupiter.api.Assertions.*;

public class PrintJobExecutorTest {
    @Test
    public void printingShouldNotFailForUserWithoutAuthentication() {
        PrintJobExecutor exec = new PrintJobExecutor();
        PrintJob pj = new PrintJob();

        try {
            exec.execute(pj, null, null);            
        } catch (AuthenticationException e) {
            fail("Should Not fail, no exception should be caught");
        }
    }
}
