package edu.umb.cs680.hw05;

public class LoggedIn implements State {

    private SecurityContext ctx;

    LoggedIn(SecurityContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void login(EncryptedString pwd) {
        if (!this.ctx.isActive()) {
            this.ctx.changeState(new LoggedOut(this.ctx));
            this.ctx.login(pwd);
        }
    }

    @Override
    public void logout() {
        this.ctx.changeState(new LoggedOut(this.ctx));
    }
}