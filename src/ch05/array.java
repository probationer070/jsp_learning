package ch05;

public class array {
	public static void main(String[] args) {
		
		int[][] nums = new int[2][];
		int[][] nums2 = new int[2][];
		
		System.out.println(nums.length);
		System.out.println(nums2.length);
		
		nums[0] = new int[2];
		nums[1] = new int[3];
		nums2[1] = new int[3];
		
		System.out.println("-----------------");		
		System.out.println(nums[0].length);
		System.out.println(nums[1].length);
		System.out.println("-----------------");
		System.out.println(nums2[0]==null);
		System.out.println(nums2[1].length);
		System.out.println(nums2.length);
	}
}
