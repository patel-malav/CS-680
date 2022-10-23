package edu.umb.cs680.hw05;

public class LoggedOut implements State {

    private SecurityContext ctx;

    LoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void login(EncryptedString pwd) {
        if (Authenticator.authenticate(this.ctx, pwd)) {
            ctx.changeState(new LoggedIn(ctx));
        }
    }

    @Override
    public void logout() {
        // Remains empty, do nothing for LoggedOut state logout method
    }
}
