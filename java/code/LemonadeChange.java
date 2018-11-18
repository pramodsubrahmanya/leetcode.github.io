package code;

/**
 * Logic is for every change that is obtained compare with other
 * available notes of 5 and 10 at each step.
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            if (bills[i] == 10) {
                ten++;
                five = five - 1;
                if (five < 0) {
                    return false;
                }
            }
            if (bills[i] == 20) {
                twenty++;
                if(ten > 0) {
                    ten = ten -1;
                    five = five - 1;
                    if(five < 0) {
                        return false;
                    }
                } else {
                    five = five - 3;
                    if(five < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5,5,5,5,20,20,5,5,5,5};
        System.out.println(new LemonadeChange().lemonadeChange(bills));
    }
}