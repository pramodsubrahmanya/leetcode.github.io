package code;

public class FirstBadVersion {

    boolean isBadVersion(int mid) {
        //This is given in the question.
        return false;
    }

    public int search(int n, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start >= end) {
            return start;
        }
        if (isBadVersion(mid)) {
            return search(n, start, mid);
        } else {
            return search(n, mid + 1, end);
        }
    }


    public int firstBadVersion(int n) {
        return search(n, 1, n);
    }

}