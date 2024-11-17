package lab5;

public class CheckPassword {
    public static void main(String[] args) {
        String[] testCases = {"123" , "qwerty123", "Qwe123", "QWEwertydasd", "qwerty123", "Qwerty123", "Qwerty123!", "dsassDSAd3123123131231231"};
        for (String password : testCases) {
            System.out.println(checkPassword(password));
        }
    }

    public static boolean checkPassword(String password) {
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasValidLength = password.length() >= 8 && password.length() <= 16;
        boolean hasOnlyValidCharacters = password.matches("[a-zA-Z\\d]+");
        boolean errFlag = false;

        if (!hasUpperCase) {
            System.out.println("- Пароль должен содержать хотя бы одну заглавную букву.");
            errFlag = true;
        }
        if (!hasDigit) {
            System.out.println("-  Пароль должен содержать хотя бы одну цифру.");
            errFlag = true;
        }
        if (!hasValidLength) {
            System.out.println("-  Длина пароля должна быть от 8 до 16 символов.");
            errFlag = true;
        }
        if (!hasOnlyValidCharacters) {
            System.out.println("-  Пароль должен содержать только латинские буквы и цифры.");
            errFlag = true;
        }

        if (errFlag) {
            return false;
        }
        return true;
    }
}
