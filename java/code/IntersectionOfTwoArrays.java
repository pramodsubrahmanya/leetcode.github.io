package code;

import java.util.*;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer val = map.get(nums1[i]);
            if (val == null) {
                map.put(nums1[i], 0);
                val = 0;
            }
            map.put(nums1[i], val++);
        }

        Set<Integer> set = new HashSet<>();
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            Integer val = map.get(nums2[i]);
            if (val != null) {
                set.add(nums2[i]);
                val--;
                if (val != 0) {
                    map.put(nums2[i], val--);
                }
            }
        }

        int[] res = new int[set.size()];
        int y = 0;
        for (Integer s : set) {
            res[y++] = s;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(nums1, nums2)));
    }

}