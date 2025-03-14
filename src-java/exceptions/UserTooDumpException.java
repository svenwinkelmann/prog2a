package exceptions;

public class UserTooDumpException extends RuntimeException {

    public UserTooDumpException(String msg) {
        super(msg);
    }

    public String bePoliteAndExplainToUser() {
        return "Dear user, I have an exception for you: " + this.getMessage()
                + ". Kind regards, your UserTooDumpException";
    }
}
