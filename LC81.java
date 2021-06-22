public class LC81 {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[l] == target)
                return true;
            if (nums[r] == target)
                return true;

            if ((target > nums[l] && target > nums[mid] && target > nums[r])
                    || (target < nums[l] && target < nums[mid] && target < nums[r])) {
                l++;
                r--;
            } else if (target < nums[mid]) {
                if (target < nums[l] && nums[l] < nums[mid])
                    l = mid + 1;
                else
                    r = mid - 1;
            } else {
                if (target < nums[r] && nums[r] < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return false;
    }
}
