package lab5;

public class CheckPassword {
    public static void main(String[] args) {
        String[] testCases = {"qwerty123", "Qwe123", "QWEwertydasd", "qwerty123", "Qwerty123", "Qwerty123!", "dsassDSAd3123123131231231", null};
        for (String password : testCases) {
            try {
                System.out.println(checkPassword(password));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static boolean checkPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Null pointer exception");
        }
        return password.matches("^((?=.*[A-Z])(?=.*\\d)[a-z(A-Z)\\d]{8,16})$");
    }
}
