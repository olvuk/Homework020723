import java.util.regex.Pattern;

public class Main {

    public static void checkLoginAndPassword(String login, String password, String confirmedPassword) {

        try {
            checkLogin(login);
            checkPassword(password, confirmedPassword);
        }
        catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Проверка пройдена");
        }

    }

    public static void checkLogin(String login) throws WrongLoginException {
        Pattern pattern = Pattern.compile("^[a-z0-9_]{1,20}$");
        if (!pattern.matcher(login).matches()) {
            throw new WrongLoginException("Логин " + login + " не соответствует условиям ввода");
        }
    }

    public static void checkPassword(String password, String confirmedPassword) throws WrongPasswordException {
        Pattern pattern = Pattern.compile("^[a-z0-9_]{1,20}$");
        if (!pattern.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль " + password + " не соответствует условиям ввода");
        }
        if (!password.equals(confirmedPassword)) {
            throw new WrongPasswordException("Введенные пароли не совпадают");
        }
    }
    public static void main(String[] args) {
        checkLoginAndPassword("login-777", "passВord", "passВord");
        checkLoginAndPassword("lacknord","passВord", "pass");
        checkLoginAndPassword("lacknord","password333", "pass");
        checkLoginAndPassword("lacknord", "password333", "password333");

    }
}