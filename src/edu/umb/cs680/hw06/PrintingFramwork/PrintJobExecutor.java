package edu.umb.cs680.hw06.PrintingFramwork;

import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw05.EncryptedString;

import edu.umb.cs680.hw06.PrintJob;
import edu.umb.cs680.hw06.AuthenticationException;

public class PrintJobExecutor {

    public void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx) throws AuthenticationException {
        doAuthentication(pwd, ctx);
        doAccessControl();
        doPrint();
    }

    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws AuthenticationException {

    }

    protected void doAccessControl() {

    }

    protected void doPrint() {
        System.out.println("!!!!- Printing -!!!!");
        System.out.println("!!!!- Finished -!!!!");
    }

    protected void doErrorHandling() {

    }

}
