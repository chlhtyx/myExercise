package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Exerciese20200713 {
    private static int MAGIC =5;

    public static void main(String[] args) {
//        int[] nums1 = {1,9999,9999,1,10,10,2,3,4,5,6,7,8};
//        int[] nums2 = {9999,9999};
//
//        int[] reslut = intersect2(nums1,nums2);


//       int[] nums = {2, 7, 11, 15}; int  target = 9;
//        int[] reslut = twoSum(nums,target);
//
//        for(int a :reslut){
//            System.out.println(a);
//        }


        List<List<Integer>> triangle =  new ArrayList<>();

    }


        public static int[] intersect(int[] nums1, int[] nums2) {
            HashMap<String,Integer> countMap1 = new HashMap();
            ArrayList<Integer> arrayList  = new ArrayList();


            for(int a : nums1){
                String num =  String.valueOf(a);
                if(countMap1.containsKey(num)){
                  Integer tmp =   countMap1.get(num);
                    countMap1.put(num,tmp+1);
                }else{
                    countMap1.put(num,1);
                }
            }

            for(int b : nums2){
                String num =  String.valueOf(b);
                if(countMap1.containsKey(num)&&(countMap1.get(num)>0)) {
                    arrayList.add(Integer.valueOf(num));
                    countMap1.put(num,countMap1.get(num)-1);
                }

            }

            return arrayList.stream().mapToInt(Integer::valueOf).toArray();
        }


    public static int[] intersect2(int[] nums1, int[] nums2) {
        int j = 0;
        int freq[] = new int[MAGIC];
        for (int i = 0; i < nums1.length; i++) {
            freq[Math.abs(nums1[i] % MAGIC)]++;
        }

        int res[] = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            if (freq[Math.abs(nums2[i] % MAGIC)]-- > 0) {
                res[j++] = nums2[i];
            }
        }
        return Arrays.copyOf(res, j);
    }


    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0 ;i<nums.length;i++){
           int tmp = target - nums[i];
           for(int j = 0 ; j<nums.length; j++){
               if(j!=i && nums[j]==tmp){
                   return new int[]{i, j};
               }
           }
        }
        return  null;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int  lengthOfLongestSubstring(String s) {

        return 0;
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     *
     *
     *
     * 例如，给定三角形：
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * @param triangle
     * @return
     */

    public static  int minimumTotal(List<List<Integer>> triangle) {
        int sum =0 ;
        for(int i = 0 ;i<triangle.size();i++){
           int  index = 0;
           List<Integer> row =   triangle.get(i);
           if(i==0){
               sum += row.get(i);
           }else{
            if(row.get(index)>row.get(index+1)){
                sum += row.get(index+1);
                index = index+1;
            }   else{
                sum += row.get(index);
            }
           }
        }

    return  sum;
    }

}

