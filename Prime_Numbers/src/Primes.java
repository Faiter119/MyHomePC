import java.security.SecureRandom;

public class Primes {
    /**
     * @param min inclusive
     * @param max exclusive
     */
    public static int generatePrime(int min, int max) { // TODO: 10-Oct-16 make not shit
        // Sieving; Space VS Time
        SecureRandom random = new SecureRandom();

        int diff = max - min;

        int randomInt = random.nextInt(diff) + min;

        while (!isPrime(randomInt)) {
            randomInt = random.nextInt(diff) + min;
        }
        return randomInt;

    }

    public static boolean isPrime(int nr) {

        if (nr <= 1) return false;
        if (nr <= 3) return true;
        if (nr % 2 == 0 || nr % 3 == 0) return false;

        int i = 5;

        while (i * i <= nr) {

            if (nr % i == 0 || nr % (i + 2) == 0) return false;

            i += 6;
        }
        return true;
    }

    public static void main(String[] args) {

        long start = System.nanoTime();

        for (int i = 0; i < 100; i++) {

            if (isPrime(i)) {
                System.out.println(i);
            }

        }

        long end = System.nanoTime();

        System.out.println("The calculation took " + (end - start));


        start = System.nanoTime();
        int randomInt = generatePrime(0, Integer.MAX_VALUE);
        end = System.nanoTime();
        System.out.println(end-start);
        System.out.println(randomInt);

        System.out.println(isPrime(randomInt));
    }
}
