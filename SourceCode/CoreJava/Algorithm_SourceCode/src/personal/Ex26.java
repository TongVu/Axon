package personal;

public class Ex26 {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkReversible(int number) {
        String numberToCheckReversible = Integer.toString(number);
        int numberLength = numberToCheckReversible.length();

        for (int i = 0; i < numberLength / 2; i++) {
            if (Integer.parseInt(String.valueOf(numberToCheckReversible.charAt(i))) !=
                    Integer.parseInt(String.valueOf(numberToCheckReversible.charAt(numberLength - 1 - i))))
                return false;
        }
        return true;
    }

    public static boolean isSumPrime(int number) {
        int sum = 0;
        String strNumber = Integer.toString(number);

        for (int i = 0; i < strNumber.length(); i++)
            sum += Integer.parseInt(Character.toString(strNumber.charAt(i)));

        return checkReversible(sum);
    }


    public static void main(String[] args) {

        /*
            Check a number is a prime number
            AND if that number is reversible
            AND sum of all the numbers is a REVERSIBLE number
         */

        for (int i = 10001; i < 9999999; i += 2) {
            if (checkReversible(i) &&
                    isPrime(i) &&
                    isSumPrime(i)
            )
                System.out.println(i);
        }

    }
}
