package edu.umb.cs680.hw05;

public class LoggedIn implements State {

    private static LoggedIn instance = null;

    private static void setSecurityContext(SecurityContext ctx) {
        instance.ctx = ctx;
    }

    public static LoggedIn getInstance(SecurityContext ctx) {
        if (instance == null) {
            instance = new LoggedIn(ctx);
        }
        setSecurityContext(ctx);
        return instance;
    }

    private SecurityContext ctx;

    private LoggedIn(SecurityContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void login(EncryptedString pwd) {
        if (!this.ctx.isActive()) {
            this.ctx.changeState(LoggedOut.getInstance(ctx));
            this.ctx.login(pwd);
        }
    }

    @Override
    public void logout() {
        this.ctx.changeState(LoggedOut.getInstance(ctx));
    }
}