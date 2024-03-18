package dsa.algorithm;

public class SortingAlgo {
    static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //=========================================================================================================
	static int[] bubbleSort(int[] nums)
	{
		 int n = nums.length;
		 int compareCount = 0;
	        for (int i = 0; i < n - 1; i++)
	        {
	            //for ith iteration...last i elements will already by sorted
	            //so reduced array will be of size (n - i)
	            //but we have to check the curr and next elem, so we need to stop before (n - 1 - i)
	            for (int j = 0; j < (n - i - 1); j++)
	            {
	            	compareCount++;
	                if (nums[j] > nums[j + 1])
	                {
	                    int temp = nums[j];
	                    nums[j] = nums[j + 1];
	                    nums[j + 1] = temp;
	                }
	            }
	        }
	        System.out.println("Comparisons in normal bubble sort = " + compareCount);
	        return nums;
	}
	static int[] omptimizedBubbleSort(int[] nums)
	{
		//the previous bubble sort will go O(N ^ 2) even if the array is already sorted
		//We can reduce those swaps and break the loop when there is no swap in any iteration
		
		int n = nums.length;
		int compareCount = 0;
        for (int i = 0; i < n - 1; i++)
        {
        	boolean swapped = false;
            for (int j = 0; j < (n - i - 1); j++)
            {
            	compareCount++;
                if (nums[j] > nums[j + 1])
                {
                
                	swapped = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (!swapped)
            	break;
        }
        System.out.println("Comparisons in optimized bubble sort = " + compareCount);
        return nums;
		
	}
	//======================================================================================================
    static int getPivotIdx(int[] nums, int low, int high)
    {
        int target = nums[low];
        int pivotIdx = high;
        for (int i = high; i > low; i--)
        {
            if (nums[i] > target)
            {
                swap(nums, pivotIdx, i);
                pivotIdx--;
            }
        }
        swap(nums, pivotIdx, low);
        return pivotIdx;
    }
    static void quickSort(int[] nums, int low, int high)
    {
        if (low >= high)
            return;
        
        int pivotIdx = getPivotIdx(nums, low, high);
        quickSort(nums, low, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, high);
    }
    //================================================================================================
	static void display(int[] nums)
	{
		for (int num : nums)
			System.out.print(num + ", ");
		System.out.println("\n");
	}
	//=================================================================================================
	public static void main(String[] args)
	{
		
		int[] nums = {68, 99, 05, 2, 12, 11, 90, 6, 89, 23, 45, 4, 0, 1, 78 };
		display(bubbleSort(nums));
		display(omptimizedBubbleSort(nums));
		
		int[] tempNums = nums.clone();
		quickSort(tempNums, 0, nums.length - 1);
		display(tempNums);

	}

}
