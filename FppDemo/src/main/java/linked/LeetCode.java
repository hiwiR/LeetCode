package linked;

import linked.ListNode;

import java.math.BigInteger;
import java.util.*;

public class LeetCode {


    public int[] runningSum(int[] input) {
        if (input == null || input.length == 1)
            return input;

        int[] result = new int[input.length];
        result[0] = input[0];
        for (int i = 1; i < input.length; i++) {
            result[i] = input[i - 1] + input[i];
        }
        return result;
    }


    public int pivotIndex(int[] nums) {
        if (nums == null)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            int leftsum = 0;
            int rightsum = 0;
            for (int j = 0; j < i; j++)
                leftsum += nums[j];
            for (int k = i + 1; k < nums.length; k++)
                rightsum += nums[k];
            if (leftsum == rightsum)
                return i;
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        if (nums == null)
            return -1;
        int sum = 0;
        for (int x : nums)
            sum += x;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if ((sum - leftSum == (leftSum - nums[i])))
                return 1;
        }
        return -1;
    }

    public String removeDuplicates(int[] nums) {

//        if(nums == null )
//            return 0;
//        int insPosition = 1;
//        for(int i=1;i<nums.length;i++){
//            if(nums[i-1] != nums[i]){
//                nums[insPosition] = nums[i];
//                insPosition++;
//            }
        TreeSet<Integer> num = new TreeSet<>();
        for (int i : nums) {
            num.add(i);
        }

        return num.toString();
        //return insPosition;
    }

    public int maximumProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length && prices[j] > prices[i]; j++) {
                if (profit < prices[j] - prices[i])
                    profit = prices[j] - prices[i];
            }
        }
        return profit;
    }

    public int[] rotateArray(int[] arr, int k) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i + k >= arr.length) {
                result[(i + k) % arr.length] = arr[i];
            } else {
                result[i + k] = arr[i];
            }
        }
        return result;
    }

    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        HashMap<Integer, Integer> testMap = new HashMap<>();
        for (int x : nums) {
            if (!testMap.containsKey(x)) {
                testMap.put(x, x);
            } else {
                flag = true;
            }
        }
        return flag;
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> testMap = new HashMap<>();
        for (int x : nums) {
            if (!testMap.containsKey(x)) {
                testMap.put(x, 1);
            } else {
                int count = testMap.get(x) + 1;
                testMap.put(x, count);
            }
        }
        return testMap.entrySet().stream().filter(t -> t.getValue() == 1).findAny().get().getKey();
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        List<Integer> fin = new ArrayList<>();
        for (int x : nums1) {
            if (map.containsKey(x)) {
                int count = map.get(x) + 1;
                map.put(x, count);
            }
            map.put(x, 1);
        }
        for (int y : nums2) {
            if (map.containsKey(y) && !result.containsKey(y))
                result.put(y, 1);
            else if (map.containsKey(y) && result.containsKey(y)) {
                if (map.get(y) > result.get(y))
                    result.put(y, result.get(y) + 1);
            }

        }
        for (int x : result.keySet()) {
            if (result.get(x) > 1) {
                for (int j = 0; j < result.get(x); j++) {
                    fin.add(x);
                }
            } else {
                fin.add(x);
            }
        }


        return fin.stream().mapToInt(x -> (int) x).toArray();
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int rightPointer = nums.length - 1;
        int leftPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[leftPointer] = nums[i];
                leftPointer++;
            } else {
                result[rightPointer] = 0;
                rightPointer--;
            }
        }
        return result;
    }

    public int[] moveZeros2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int leftPointer = i;
            int rightPointer = i + 1;
            if (nums[i] != 0) {
                continue;
            } else {
                while (rightPointer < nums.length && nums[rightPointer] ==0) {
                    rightPointer++;
                }
                if(rightPointer< nums.length)
                    swap(i,rightPointer,nums);
            }
        }
        return nums;

    }



    public static void swap(int initial, int fina,int[] nums) {
        int temp = nums[initial];
        nums[initial] = nums[fina];
        nums[fina]= temp;
    }

    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i] )&& map.get(target-nums[i]) != i){
                result = new int[] {i,map.get(target-nums[i])};
                return result;
            }
        }
        return null;
    }
    public int[][] rotate(int[][] matrix) {
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<=i;j++){
                swap2D(i,j,matrix);
            }
        }
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<= matrix[0].length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][Math.abs(j-matrix[0].length)-1];
                matrix[i][Math.abs(j-matrix[0].length)-1] = temp;
                System.out.println(matrix[i][j]);
            }
        }
        return matrix;
    }
    public static void swap2D(int i, int j,int[][] nums) {
        int temp = nums[i][j];
        nums[i][j] = nums[j][i];
        nums[j][i] = temp;
    }
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,List<Integer>> row =  new HashMap<>();
        HashMap<Integer,List<Integer>> coloumn = new HashMap<>();
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')
                    continue;
                else if(row.containsKey(i) &&  board[i][j] != '.'&& row.get(i).contains(Character.getNumericValue(board[i][j]))){
                    System.out.println(row.get(i).toString());
                    System.out.println("here in row"+ i + j);


                    return false;
                }else if(coloumn.containsKey(j) && board[i][j] != '.'&& coloumn.get(j).contains(Character.getNumericValue(board[i][j]))){
                    System.out.println(coloumn.get(j).toString());
                    System.out.println(board[i][j]);
                    return false;
                }
                if(row.containsKey(i)){
                    List<Integer> temp = row.get(i);
                    temp.add(Character.getNumericValue(board[i][j]));
                    row.put(i,temp);
                }
                if(coloumn.containsKey(j)&& board[i][j] != '.'&& !coloumn.get(j).contains((Character.getNumericValue(board[i][j])))){
                    List<Integer> temp = coloumn.get(j);
                    temp.add(Character.getNumericValue(board[i][j]));
                    row.put(j,temp);
                }
                if (!row.containsKey(i) && board[i][j] != '.') {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(Character.getNumericValue(board[i][j]));
                    row.put(i,temp);
                }
                if (!coloumn.containsKey(j) && board[i][j] != '.') {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(Character.getNumericValue(board[i][j]));
                    coloumn.put(j,temp);
                }

            }
        }
        return true;
    }
    public void reverseString(char[] s) {
        int backPointer = s.length-1;
        for(int i =0;i<s.length/2;i++){
            char temp = s[i];
            s[i]=s[backPointer];
            s[backPointer] = temp;
            backPointer -- ;
        }
    }
    public int reverse(int x) {
        long temp = 0;
        int y = x;
        int pow = 0;
        while(y!=0){
            temp = temp*10+(y%10);
            y /= 10;
            pow++;
        }
        if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE)
            return 0;
        return Integer.valueOf((int) temp);
    }
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            if(map.containsKey(x)){
                int temp = map.get(x) +1 ;
                map.put(x,temp);
            }else{
                map.put(x,1);
            }
        }
        for(int i =0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> store = new HashMap<>();
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //store.put(s.charAt(i), store.getOrDefault(s.charAt(i), 0) + 1);
            map[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
//            if (!store.containsKey(t.charAt(i)))
//                return false;
//            store.put(t.charAt(i), store.getOrDefault(t.charAt(i), 0) - 1);
            map[s.charAt(i)-'a'] -= 1;
        }
        for(int x : map)
            if(x != 0)
                return false;
        return true;
    }
    public boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        char leftChar;
        char rightChar;
        while (left <= right) {

            leftChar = input.charAt(left);
            rightChar = input.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
    public int myAtoi(String s) {
        long temp = 0;
        boolean flag = false;

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                temp =  temp * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                if (temp > Integer.MAX_VALUE)
                    break;
                if(i+1 < s.length() && !Character.isDigit(s.charAt(i+1)))
                    break;
            } else if (Character.isSpaceChar(s.charAt(i)) ){
                continue;
            }
            else if(s.charAt(i)== '+' || s.charAt(i) == '-') {
                if(s.charAt(i) == '-') flag=true;
                if(i+1 < s.length() && !Character.isDigit(s.charAt(i+1)))
                    break;

            }else if (!Character.isDigit(s.charAt(i))) {
                break;
            }
        }
        if(flag){
            if(temp*-1 < Integer.MIN_VALUE)
                return -2147483648;
        }
        else if (temp > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE ;
        }
        if(flag)
            temp *= -1;

        return (int) temp;
    }
    public int strStr(String haystack, String needle) {
        int flag = -1;
        if(haystack.length() < needle.length())
            return -1;
        int haystackPointer =0;
        int needlePointer = 0;
        while (haystackPointer < haystack.length() && needle.length()> needlePointer){
            if(needle.charAt(needlePointer)!= haystack.charAt(haystackPointer))
                if(true)
                haystackPointer++;
             else if(needle.charAt(needlePointer) == haystack.charAt(haystackPointer)){
                if(flag ==-1)
                    flag = haystackPointer;
                if(needlePointer == needle.length()-1){
                    return flag;
                }
                needlePointer++;
                haystackPointer++;
            }

        }
        return -1;
    }
    public int strStr2(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(0) && needle.length()<=haystack.length()-(i+1)){
                for(int j=0;j<needle.length();j++){
                    if(haystack.charAt(i+j) != needle.charAt(j))
                        break;
                    if(j == needle.length()-1)
                        return i;
                }
            }
        }
        return -1;
    }
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for(int j=0;j<strs.length;j++){
            if(strs[j].length() < min)
                min = strs[j].length();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<min;i++){
            if(strs[0].isEmpty())
                return "";
            char temp= strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i) !=  temp)
                    return sb.toString();
            }
            sb.append(temp);
        }
        return sb.toString();
    }


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count = 0;
        while (current.next != null){
            count ++;
          current = current.next;
        }
        current = head;
        for(int i=1;i<=count;i++){
            if((count-n-1)==i){
                current.next = current.next.next;
            }
            current=current.next;
        }
//        int i=2;
//        ListNode current = head;
//        while(current.next !=null){
//            if(i == n-1){
//                current.next = current.next.next;
//                return head;
//            }
//            i++;
//            current=current.next;
//        }
        return head;
    }
    public  void plusMinus(List<Integer> arr) {
        float neg = 0;
        float pos = 0;
        float zero = 0;
        for(int x : arr){
            if(x<0)
                neg +=1;
            else if(x>0)
                pos+=1;
            else
                zero+=1;
        }
        float p = neg/arr.size();
        System.out.println(p);
    }
    public  void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        long min = 0;
        long max = 0;
        long temp = arr.stream().mapToLong(x->x).sum();
        min = temp-arr.get(arr.size()-1);
        max = temp-arr.get(0);
        System.out.println(max);
    }


}