package code;

import java.util.HashMap;
import java.util.Map;


/**
 * Logic is to
 * Iterate the array to find the maximum degree while keeping track of the start and end of that particular element.
 * In the next iteration, find the difference between (end - start) which has the minimum.
 * The assumption is that the lenght of the element of the highest degree should have the start and the end.
 */
public class DegreeOfAnArray {

    class Element {
        int count;
        int start;
        int end;

        Element(int start) {
            this.start = start;
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Element> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            Element element;
            if ((element = map.get(key)) == null) {
                element = new Element(i);
                map.put(key, element);
            }
            element.count++;
            element.end = i;
            if (element.count > max) {
                max = element.count;
            }
        }

        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            Element element = map.get(key);
            if (element.count == max && (element.end - element.start + 1) < min) {
                start = element.start;
                end = element.end;
                min = (element.end - element.start + 1);
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        System.out.println(new DegreeOfAnArray().findShortestSubArray(nums));
    }

}