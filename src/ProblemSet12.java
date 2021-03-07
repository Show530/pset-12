import java.util.ArrayList;

public class ProblemSet12 {

    public long factorial(int n) {
        if (n <= 0) {
            return -1;
        }
        else {
            if (n <= 1) {
                return 1;
            }
            return n * factorial(n - 1);
        }
    }

    public long fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        else if (n == 0) {
            return 0;
        }
        else {
            if (n == 1 || n == 2) {
                return 1;
            }
            else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }

    }

    public long triangle(int rows) {
        if (rows < 0) {
            return -1;
        }
        else {
            if (rows == 0) {
                return 0;
            }
            else {
                return rows + triangle(rows - 1);
            }
        }
    }

    public long sumDigits(int n) {
        if (n < 0) {
            return -1;
        }
        else {
            if (n == 0) {
                return 0;
            }
            int x = n % 10;
            return x + sumDigits(n / 10);
        }
    }

    public long powerN(int base, int exponent) {
        if(base < 1 || exponent < 1) {
            return -1;
        }
        else {
            if (exponent == 1) {
                return base;
            }
            return base * powerN(base, exponent - 1);
        }
    }

    public String changeXY(String text) {
        if(text == null) {
            return null;
        }
        else {
            if (text.length() == 1) {
                if (text.equals("x")) {
                    text = "y";
                }
                return text;
            }
            String current = text.substring(0,1);
            if (current.equals("x")) {
                current = "y";
            }
            return current + changeXY(text.substring(1));
        }
    }

    public int array11(int[] data, int index) {
        if (data == null || index < 0 || index > data.length - 1) {
            return -1;
        }
        else {
            if (index == data.length -1) {
                if (data[index] == 11) {
                    return 1;
                }
                return 0;
            }
            if (data[index] == 11) {
                return 1 + array11(data, index + 1);
            }
            return array11(data, index + 1);
        }
    }

    public int strCount(String text, String sub) {
        if (text == null || sub == null || sub.length() <= 0) {
            return -1;
        }
        else {
            if (text.length() - 1 == 0) {
                return 0;
            }
            if (text.startsWith(sub)) {
                return 1 + strCount(text.substring(sub.length()-1), sub);
            }
            return strCount(text.substring(1), sub);
        }
    }

    public boolean strCopies(String text, String sub, int n) {
        if (text == null || sub == null || sub.length() == 0 || n < 0) {
            return false;
        }
        else {

            if (n == 0) {
                return true;
            }
            else if (text.length() - 1 == 0) {
                return false;
            }

            if (text.startsWith(sub)) {
                return strCopies(text.substring(sub.length()-1), sub, n-1);
            }
            return strCopies(text.substring(1), sub, n);
        }
    }

    public int strDist(String text, String sub) {
        if (text == null || sub == null || sub.length() == 0) {
            return -1;
        }
        else {
            if (text.length() < sub.length()) {
                return 0;
            }

            if (text.startsWith(sub) && text.length() == sub.length()) {
                return text.length();
            }
            else if (text.startsWith(sub) && text.endsWith(sub)) {
                return text.length();
            }
            else if (text.startsWith(sub) && !text.endsWith(sub)) {
                return strDist(text.substring(0, text.length() - 1), sub);
            }
            else if (!text.startsWith(sub)  && text.endsWith(sub)) {
                return strDist(text.substring(1), sub);
            }
            else {
                return strDist(text.substring(1, text.length() - 1), sub);
            }
        }
    }


    public static void main(String[] args) {
        ProblemSet12 test = new ProblemSet12();

        System.out.println(test.strDist("catcowcat", "cat"));
        System.out.println(test.strDist("catcowcat", "cow"));
        System.out.println(test.strDist("cccatcowcatxx", "cat"));
        System.out.println(test.strDist("catcowcowcat", "cat"));
        System.out.println(test.strDist("ffcctcatccgg", "cat"));
        System.out.println(test.strDist("ccfcatfcc", "cat"));
    }
}
