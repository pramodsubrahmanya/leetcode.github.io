package code;

public class MaximumSumCircularSubarray {

    int kadane(int arr[]) {
        int maxSoFar = arr[0];
        int maxHere = arr[0];
        int i = 1;
        while (i < arr.length) {
            maxHere = Math.max(maxHere + arr[i], arr[i]);
            maxSoFar = Math.max(maxHere, maxSoFar);
            i++;
        }
        return maxSoFar;
    }

    int maxSubarraySumCircular(int arr[]) {
        int maxSoFar = kadane(arr);
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i];
            arr[i] = -arr[i];
            i++;
        }
        sum = sum + kadane(arr);
        if (sum != 0) {
            maxSoFar = Math.max(maxSoFar, sum);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int a[] = {-2,-3,-1};
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(a));
    }

}