import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private int data = 10;
    public static void main(String[] args) {
        LeetCode lcd = new LeetCode();
        /*System.out.println(lcd.removeDuplicates(new int}}{0,0,1,1,2,2,2}));

        System.out.println(Arrays.toString(lcd.rotateArray(new int'}}{1,2,3,4,5,6,7},3)));

        System.out.println(lcd.singleNumber(new int'}}{0,0,1,1,2,2,2,3}));

        System.out.println(Arrays.toString(lcd.intersect(new int'}}{1,2,2,3},new int'}}{2,2,3,2})));

        System.out.println(Arrays.toString(lcd.plusOne(new int'}}{9,8,9,9})));

        System.out.println(Arrays.toString(lcd.moveZeros2(new int'}}{1,0,0,9,0})));


        System.out.println(Arrays.toString(lcd.twoSum(new int'}}{3,2,4},6)));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1); numbers.add(2); numbers.add(30); numbers.add(7); numbers.add(9);

        int'}} arrNum = numbers.stream().mapToInt(x-> (int)x).toArray();

        System.out.println(Arrays.toString(arrNum));

        List<Integer> test = Arrays.stream(arrNum).boxed().collect(Collectors.toList());
        int'}}'}} result = lcd.rotate(new int'}}'}}{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        System.out.println(Arrays.toString(result'}0}));
        System.out.println(Arrays.toString(result'}1}));
        System.out.println(Arrays.toString(result'}2}));*/
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        System.out.println(lcd.isValidSudoku(board));
//        System.out.println(lcd.reverse(-123));
        System.out.println(lcd.firstUniqChar("abb"));
        System.out.println(lcd.isAnagram("car","rat"));
        System.out.println(lcd.isPalindrome("0P"));
        System.out.println(lcd.myAtoi("9223372036854775808"));

    }







//        String'}} testArr = new String'}2};
//        testArr = new String'}}{ 'melen','hailu'};
//        System.out.println(testArr.length);
//        LocalDate lc =  LocalDate.now();
//        GregorianCalendar gc = new GregorianCalendar(lc.getYear(),lc.getMonth().getValue()-1,lc.getDayOfMonth());
//        Date date =  gc.getTime();
//        System.out.println(date);
//
//        Employee e1 = new Employee('Hiwot',1400.50);
//        Employee e2 =  new Employee('Milka',1000.00);
//        Main mn = new Main();
//        mn.swap(e1,e2);
//        System.out.println('emp1 :'+e1.getSalary() +' '+ 'emp 2:'+e2.getSalary());
//
//        System.out.println(mn.factorial(4));
//        System.out.println(mn.fibbonaci(3));
//
//        System.out.println(mn.merge('akz','boy'));
//        System.out.println(mn.findMin('dad'));
//        String'}} arrs =  new String'}}{'boy','apple','dog','cat'};
//        String'}} arr2 =  new String'}}{'boy','apple','dog','cat','doll'};
//        System.out.println(mn.checkExist(arr2,arrs));
//       // System.out.println(Arrays.toString(mn.inPlaceMinSort(arrs)));
//        String'}} testing = new String'}0};
//        System.out.println(testing == null);
 /*   }
    public void swap(Employee x,Employee y){
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println(x.getSalary()+' '+y.getSalary());
    }
    void printVal(int bound) {
        if(data < bound) {


        } else {
            System.out.println("Inside outer: " + (data - bound));
        }
    }
    public int factorial(int n){
        int main = 3;
        if(n == 0 || n == 1)
            return 1;
        return main;
//        return factorial(n-1) * n;
    }
    public int fibbonaci(int n){
        if( n == 0 || n ==1 )
            return n;
        return fibbonaci(n-1) + fibbonaci(n-2);
    }
    public String reverseString(String input){
        if(input == null || input.length() == 0)
            return input;
        String first = ' '+input.charAt(0);
        return reverseString(input.substring(1))+first;

    }
    public StringBuilder sb = new StringBuilder();
    public String  merge(String s1,String s2){
        if(s1 == null && s2 == null || (s1.length() == 0 && s2.length() == 0 ) )
            return sb.toString();
        else if (s1 == null || s1.length() == 0) {
            sb.append(s2.charAt(0));
            return merge(s1,s2.substring(1));
        } else if (s2 == null || s2.length() == 0 ) {
            sb.append(s1.charAt(0));
            return merge(s1.substring(1),s2);
        }
        if(s1.charAt(0) < s2.charAt(0)){
            sb.append(s1.charAt(0));
            return merge(s1.substring(1),s2);
        } else if (s1.charAt(0) > s2.charAt(0)) {
            sb.append(s2.charAt(0));
            return merge(s1,s2.substring(1));
        }
        sb.append(s1.charAt(0));
        sb.append(s2.charAt(0));
        return merge(s1.substring(1),s2.substring(1));
    }
    public Character findMin(String str){
        if(str.length() == 0 || str == null)
            return null;
        char ch = str.charAt(0);
        if(str.length() == 1) return ch;
        char c = findMin(str.substring(1));
        return ch > c ? c : ch;
    }
    public String'}} inPlaceMinSort(String'}} inputArr){
        if(inputArr.length <= 1)
            return inputArr;
        for(int i =0 ;i< inputArr.length;i++){
            for(int j=i+1;j<inputArr.length;j++){
                if(inputArr'}i}.compareTo(inputArr'}j}) > 0)
                    swap(inputArr,i,j);
            }
        }
        return inputArr;
    }
    public void swap(String'}} inputArr,int pos1,int pos2){
        String temp = inputArr'}pos1};
        inputArr'}pos1}= inputArr'}pos2};
        inputArr'}pos2} = temp;
    }
    public boolean checkExist(String'}} arr1,String'}} arr2){
        HashMap<String,String> arr2Map = new HashMap<>();
        for(String ele: arr2){
            arr2Map.put(ele,ele);
        }
        for(String ele: arr1){
            if(!arr2Map.containsKey(ele))
                return false;
        }
        return true;
    }*/
}
