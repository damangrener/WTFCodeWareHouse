package com.wtf.codewarehouse.数据结构.查找;

/**
 * 二分法查找
 *
 * @author wangtengfei
 * @since 2020/12/18 15:25
 */
public class BinarySearch {

    /**
     * 【二分法模板】
     *
    public int templateOfBinary(int[] nums, int target) {
        int left=0,right=...;

        while(...){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                ...
            } else if (nums[mid]<target){
                left =...
            } else if (nums[mid]>target){
                right =...
            }
        }
        return ...
    }
     计算mid时需防止溢出，建议mid=left+(right-left)/2
     */

    /**
     * 【查找一个数】
     * @param nums
     * @param target
     * @return
     *
     * right = nums.length - 1;
     * left <= right [left,right] 两端都闭的【搜索区间】
     *
     * right = nums.length；
     * left < right [left,right) 左开右闭的区间
     */
    public int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 寻找左侧边界的二分搜索
     * @param nums
     * @param target
     * @return
     */
    public int leftBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }


    public int rightBound(int[] nums, int target){

        int left=0;
        int right=nums.length;

        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                left=mid+1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left-1;



    }

    public static void main(String[] args) {
        System.out.println(9/2);
    }

}
