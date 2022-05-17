package personal;

public class Ex25 {
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

    public static boolean isEveryNumPrime(int n) {
        String numberToCheckPrime = Integer.toString(n);
        for (int i = 0; i <= numberToCheckPrime.length() / 2; i++) {
            if(!isPrime(Integer.parseInt(String.valueOf(numberToCheckPrime.charAt(i)))))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
            List the primes number in range 10001 - 9999999
            check if they are reversible number
            check if every number in that prime-reversible number is prime number
         */

        for (int i = 10001; i < 9999999; i += 2) {
            if (checkReversible(i) && isPrime(i) && isEveryNumPrime(i))
                System.out.println(i);
        }

    }

}
