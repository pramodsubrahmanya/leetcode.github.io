package code;

public class CountPrimes {

    public int countPrimes(int n) {
        double log = Math.log(n);
        return n / ((int) Math.log(n) + 1) + 1;
    }

}