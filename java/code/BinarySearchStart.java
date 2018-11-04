package code;

public class BinarySearchStart {

    int search(int a[], int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (start >= end) {
            return start;
        }
        if (a[mid] == target) {
            return -1;//TODO To be changed.
        } else if (a[mid] > target) {
            return search(a, mid + 1, end, target);
        } else {
            return search(a, start, mid, target);
        }
    }


    public static void main(String[] args) {
        int[] a = {2, 3, 3, 3, 3, 4};
        int target = 3;
        System.out.println(new BinarySearchStart().search(a, 0, a.length, target));
    }

}
