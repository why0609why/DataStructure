/**
 * @author yuyuko@xun.moe
 * @version v1.0
 * @date 2020/10/26 Monday 下午8:17
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 6, 2};
        int len = nums.length;
        int k = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                //记录当前失序的值
                int t = nums[i];
                //从后往前把大于目标值的数都往后放
                for (k = i - 1; k >= 0 && t < nums[k]; k--) {
                    nums[k + 1] = nums[k];
                }
                //把t放到应该放到的位置
                nums[k + 1] = t;
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
