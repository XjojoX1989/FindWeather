package project.chris.findweather;

/**
 * Created by chris on 2019/2/18.
 */

public class test {

    public int[] twoSum(int[] nums, int target) {
        int a = 0, b = 0;
        int[] array = {a, b};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i];
                int next = nums[j];
                if (first + next == target) {
                    a = first;
                    b = next;
                }
            }
        }
        return array;
    }
}
