package linked;

import java.util.*;

public class HackerRank {
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
    public static String timeConversion(String s) {
        StringBuilder sb=new StringBuilder();
        String[] parts = s.split(":");
        String amPm = parts[2].substring(2);
        int hours = Integer.parseInt(parts[0]);
        String min = parts[1];
        String sec= parts[2].substring(0,2);
        if(amPm.equals("AM") && hours == 12)
            sb.append("00:");
        else if (amPm.equals("AM")){
            sb.append(parts[0]+":");
        } else if(amPm.equals("PM") && hours == 12)
            sb.append("12:");
         else if(amPm.equals("PM")  ){
            int temp = hours+12;
            sb.append(String.valueOf(temp)+":");
        }
        sb.append(min);sb.append(":");sb.append(sec);
        return sb.toString();
    }
    public static int lonelyinteger(List<Integer> a) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x:a){
            if(map.containsKey(x))
                map.put(x, 2);
            else
                map.put(x, 1);
        }
        return map.entrySet().stream().filter(x->x.getValue().compareTo(1)==0).findAny().get().getKey();
    }
    public static int diagonalDifference(List<List<Integer>> arr) {
        int diagonal1 = 0;
        int rightDiagonal = 0;
        int rightstart = arr.size()-1;
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.get(i).size();j++){
                if(i==j)
                    diagonal1 += arr.get(i).get(j);
                if(j== rightstart)
                    rightDiagonal += arr.get(i).get(j);

            }
            rightDiagonal--;
        }
        return Math.abs(diagonal1-rightDiagonal);
    }
    public static List<Integer> countingSort(List<Integer> arr) {
       //int max = arr.stream().mapToInt(x->x).max().getAsInt();
       int[] result = new int[100];
       List<Integer> result2 = new ArrayList<>();
        for(int x:arr){
            result[x] +=1;
        }

        for(int x:result)
            result2.add(x);
        return result2;
    }
    public static String caesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String test = "he";

        for(int i =0;i<s.length();i++){
            if(!Character.isLetter(s.charAt(i)))
                sb.append(s.charAt(i));
            else if (Character.isUpperCase(s.charAt(i))) {

                    sb.append((char) ((char) (((int)s.charAt(i)+k)-65)%26+65));

            }else{
                sb.append((char) ((char) (((int)s.charAt(i)+k)-97)%26+97));
        }}
        return sb.toString();
    }
    public static int anagram(String s) {
        if(s.length()%2 ==1)
            return -1;
        HashMap<Character,Integer> store = new HashMap<>();
        String left  = s.substring(0,s.length()/2);
        String right = s.substring(s.length()/2);
        int changeCount = 0;
        for(char x:right.toCharArray()){
            store.put(x, store.getOrDefault(x, 0)+1);
        }
        for(int i=0;i<left.length();i++){
            if(store.get(left.charAt(i)) != null && store.get(left.charAt(i)) !=0){
                store.put(left.charAt(i), store.get(left.charAt(i))-1);
            }else if(store.get(left.charAt(i))== null || store.get(left.charAt(i)) ==0 ){
                changeCount++;
            }

        }
        return changeCount;

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> store = new HashMap<>();
        for(String x: strs){
            boolean flag = false;
            for(String key : store.keySet()){
                char[] temp1 = x.toCharArray();
                char[] temp2 = key.toCharArray();
                Arrays.sort(temp1);
                Arrays.sort(temp2);
                if(Arrays.equals(temp1,temp2) ){
                    List<String> test = new ArrayList<>(store.get(key));

                    test.add(x);
                    store.put(key,test);
                    flag = true;
                    break;
                 }
                }
                if(!flag){
                    store.put(x,Arrays.asList(x));
                }
            }
        return store.values().stream().toList();
        }
    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,List<String>> store = new HashMap<>();
        for(String x: strs){
            char[] temp = x.toCharArray();
            Arrays.sort(temp);
            if(store.get(String.valueOf(temp))!= null){
                List<String> test = new ArrayList<>(store.get(String.valueOf(temp)));
                test.add(x);
                store.put(String.valueOf(temp),test);
            }else {
                store.put(String.valueOf(temp),Arrays.asList(x));
            }
        }
        return store.values().stream().toList();
     }
     public static List<List<String>> queryAnagram(String[] arr,String[] query){

        HashMap<String,List<String>> store = new HashMap<>();
                for (String x: arr){
                char[] temp = x.toCharArray();
                Arrays.sort(temp);
                if(store.get(String.valueOf(temp))!=null){
                    List<String> values = new ArrayList<>(store.get(String.valueOf(temp)));
                    values.add(x);
                    store.put(String.valueOf(temp),values);
                }else{
                    store.put(String.valueOf(temp),Arrays.asList(x));
                    }
                }
                List<List<String>> result =  new ArrayList<>();
                for(String q:query){
                    char[] temp = q.toCharArray();
                    Arrays.sort(temp);
                    if(store.get(String.valueOf(temp)) != null)
                        result.add(new ArrayList<>(store.get(String.valueOf(temp))));
                }
                return result;

            }
     }




