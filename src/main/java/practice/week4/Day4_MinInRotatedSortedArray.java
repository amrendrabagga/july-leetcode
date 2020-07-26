package practice.week4;

public class Day4_MinInRotatedSortedArray {

    public int findMinWithoutDuplicate(int[] nums) {
        if (nums == null || nums.length==0) return -1;
        if (nums.length ==1) return nums[0];
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high])
            return nums[0];
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (mid < high && nums[mid] > nums[mid+1])
                return nums[mid+1];
            if (mid > low && nums[mid] < nums[mid-1])
                return nums[mid];
            else if(nums[mid] > nums[low]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public int findMin2(int[] nums) { // incorrect but way i thought
        if (nums == null || nums.length==0) return -1;
        if (nums.length ==1) return nums[0];
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high])
            return nums[0];
        while (low <= high) {
            int mid = low + (high - low)/2;
            while (mid > low && nums[low] == nums[mid]) {++low;}
            while(high > mid && nums[high] == nums[mid]) {--high;}

            mid = low + (high - low)/2;

            if (mid < high && nums[mid] > nums[mid+1])
                return nums[mid+1];
            if (mid > low && nums[mid] < nums[mid-1])
                return nums[mid];
            else if(nums[mid] < nums[high]) high = mid - 1;
            else low = mid + 1;

        }
        return nums[low];
    }

    public int findMin1(int[] nums) { // incorrect but way i thought
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == nums[high]) high--;

            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return nums[high];
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){

            //handle cases like [3, 1, 3]
            while(nums[low]==nums[high] && low!=high){
                low++;
            }

            if(nums[low]<=nums[high]){
                return nums[low];
            }

            int mid=(low+high)/2;
            if(nums[mid]>=nums[low]){
                low=mid+1;
            }else{
                high=mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Day4_MinInRotatedSortedArray().findMin(new int[]{2,2,2,0,2,2}));
    }
}
