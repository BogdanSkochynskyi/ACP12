package ua.artcode.week8.ioc.validator;

/**
 * Created by serhii on 02.04.16.
 */
public class GeneralValidator {
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@");// use regexp
    }

    public boolean isValidPass(String pass) {
        return pass != null && pass.length() >= 8;
    }
}
