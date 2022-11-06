package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw06.AuthenticationException;

/**
 * This printer model does not do authentication and anyone can do print job
 */

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramwork.PrintJobExecutor {

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws AuthenticationException {

    }
    
    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint() {
        super.doPrint();
        System.out.println("!!!!- ModelXYZ -!!!!");
    }
}
