package edu.umb.cs680.hw05;

public class SecurityContext {

    private State state;
    private boolean active = true;

    SecurityContext(User user) {
        LoggedIn.getInstance(this);
        this.state = LoggedOut.getInstance(this);
    }

    public State getState() {
        System.out.println(this.state);
        return this.state;
    }

    public void changeState(State newState) {
        this.state = newState;
    }

    public void login(EncryptedString pwd) {
        this.state.login(pwd);
    }

    public void logout() {
        this.state.logout();
    }

    protected boolean isActive() {
        boolean result = this.active;
        if (result) {
            this.active = false;
        }
        return result;
    }
}
