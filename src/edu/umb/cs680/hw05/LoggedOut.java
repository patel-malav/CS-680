package edu.umb.cs680.hw05;

public class LoggedOut implements State {

    private static LoggedOut instance = null;

    private static void setSecurityContext(SecurityContext ctx) {
        instance.ctx = ctx;
    }

    public static LoggedOut getInstance(SecurityContext ctx) {
        if (instance == null) {
            instance = new LoggedOut(ctx);
        }

        setSecurityContext(ctx);
        return instance;
    }

    private SecurityContext ctx;

    private LoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void login(EncryptedString pwd) {
        if (Authenticator.authenticate(this.ctx, pwd)) {
            this.ctx.changeState(LoggedIn.getInstance(this.ctx));
        }
    }

    @Override
    public void logout() {
        // Remains empty, do nothing for LoggedOut state logout method
    }
}
