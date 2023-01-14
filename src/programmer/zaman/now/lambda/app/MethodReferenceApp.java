package programmer.zaman.now.lambda.app;

import programmer.zaman.now.lambda.util.StringUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceApp {
    // Untuk Method Reference Static
    public static void main(String[] args) {

        // Predicate<String> predicateIsLowerCase = value -> StringUtil.isLowerCase(value);
        Predicate<String> predicateIsLowerCase = StringUtil::isLowerCase;

        System.out.println(predicateIsLowerCase.test("kahfi"));
        System.out.println(predicateIsLowerCase.test("Kahfi"));

        // Method Reference di Parameter

        // Function<String, String> functionUpper = value -> value.toUpperCase();
        Function<String, String> functionUpper = String::toUpperCase;

        System.out.println(functionUpper.apply("Kahfi"));

    }

    // Untuk Method Reference Non Static
    public void run() {
        Predicate<String> predicateIsLowerCase = this::isLowerCase;

        System.out.println(predicateIsLowerCase.test("kahfi"));
        System.out.println(predicateIsLowerCase.test("Kahfi"));
    }

    // Untuk Method Reference Object
    public void run2() {
        MethodReferenceApp app = new MethodReferenceApp();

        Predicate<String> predicateIsLowerCase = app::isLowerCase;

        System.out.println(predicateIsLowerCase.test("kahfi"));
        System.out.println(predicateIsLowerCase.test("Kahfi"));
    }

    public boolean isLowerCase(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
