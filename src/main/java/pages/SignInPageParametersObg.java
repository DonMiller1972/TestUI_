package pages;

public class SignInPageParametersObg {
    private static String userLogin;

    private  static  String userPassword;

    public  String getUserLogin() {
        return userLogin;
    }

    public  SignInPageParametersObg setUserLogin(String userLogin) {
        SignInPageParametersObg.userLogin = userLogin;
        return this;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public  SignInPageParametersObg setUserPassword(String userPassword) {
        SignInPageParametersObg.userPassword = userPassword;
        return this;
    }
}
