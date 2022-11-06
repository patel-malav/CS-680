package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.LoggedIn;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw06.AuthenticationException;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramwork.PrintJobExecutor {

    private boolean isLoggedIn = false;

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws AuthenticationException {
        ctx.login(pwd);
        if ((ctx.getState() instanceof LoggedIn)) {
            this.isLoggedIn = true;
        } else {
            throw new AuthenticationException();
        }
    }

    @Override
    protected void doPrint() {
        if (this.isLoggedIn) {
            super.doPrint();
            System.out.println("!!!!- ModelXYZ -!!!!");
        }
    }
}
