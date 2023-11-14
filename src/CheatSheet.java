import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class CheatSheet {

    public static void print(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static void print(int[][] a){
        for(int i=0;i<a.length;i++){
            print(a[i]);
        }
    }
    //takes in an integer and prints out 0es and 1es
    public static void printBits(int number) {
        // Java integers are 32 bits
        for (int i = 31; i >= 0; i--) {
            // Using bitwise AND operation with a shifted 1
            int bit = (number >> i) & 1;
            System.out.print(bit);
            if (i % 4 == 0) System.out.print(" ");
        }
        System.out.println(); // Print a newline at the end
    }
    //takes in a float and prints out 0es and 1es
    public static void printFloatBits(float number) {
        // Convert the float to its bit representation
        int bitRepresentation = Float.floatToIntBits(number);

        for (int i = 31; i >= 0; i--) {
            int bit = (bitRepresentation >> i) & 1;
            System.out.print(bit);
            if (i % 4 == 0) { // Adding a space every 8 bits for readability
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    //check if there is an overflow
    public static boolean isOverflow(int a, int b, int result) {
        // Check if both arguments are positive and result is negative
        if (a > 0 && b > 0 && result < 0) {
            return true;
        }
        // Check if both arguments are negative and result is positive
        if (a < 0 && b < 0 && result > 0) {
            return true;
        }
        return false;
    }

    public static void sizeOfArrayWithUniqueElementsOnly(int[] array){
     int size=0;
        for (int i = 0; i <array.length; i++) {
            boolean equals = true;
            for (int k = 0; k <i; k++) {
                if(array[i]==array[k]){
                    equals = false;
                }
            }
            if(equals){
                size++;
            }
        }
    }

    public static int IntToArray(int integer) {
        // https://stackoverflow.com/questions/8033550/convert-an-integer-to-an-array-of-digits
        int sum=0;
        int remainder=0;
        List<Integer> integerList = new ArrayList<>();
        while(integer>0){
            remainder = integer%10;
            integer/=10;
            integerList.add(remainder);
        }
        int[] numArray = integerList.stream().mapToInt(x->x).toArray();
        for (int i = 0; i < numArray.length; i++) {
            sum+=numArray[i];
        }
        return sum;
    }

    private static boolean isPowerOfTwo(int n){
        //https://stackoverflow.com/questions/600293/how-to-check-if-a-number-is-a-power-of-2

        if (n == 0)
            return false;

        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    public static long factorial(long n, long k) {
        // TODO
        //permutation=(factorial(n)/factorial(k));
        double factorial =1;
        for (int i = 2; i <=n ; i++) {
            factorial=factorial*i;
        }

        return (long)(factorial);
    }

    public static long PowerWithoutMultiplicationOrDivisionSymbol(int x, int i) {
        //https://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/
        if (i == 0)
            return 1;

        long answer = x;
        long increment = x;
        int p, q;

        for (p = 1; p < i; p++) {
            for (q = 1; q < x; q++) {
                answer += increment;
            }
            increment = answer;
        }

        return answer;

    }

    public static int SizeOfArrayAfterRemovingANumberInAnArray(int[] array, int number){
        int newSize =0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]!=number){
                array[newSize]=array[i];
                newSize++;
            }
        }

        return newSize;
    }

    public static void ShiftingElementsInAnArrayLeftAndRight(int[] array, int amount) {
        if(array.length==0){
            return;
        }

        if(amount>=array.length){
            //careful for multiples
            amount-=array.length;
        }

        //shift right
        if(amount>0){
            for (int i = 0; i < amount; i++) {
                int last  = array[array.length-1];
                for (int j = array.length-1; j > 0; j--) {
                    array[j] = array[j-1];
                }
                array[0]=last;
            }
        //shift left
        }else if(amount<0){
            for (int i = 0; i < amount*-1; i++) {
                int last  = array[0];
                for (int j = 0; j < array.length-1; j++) {
                    array[j] = array[j+1];
                }
                array[array.length-1]=last;
            }

        }

    }

    public static int[] LinearizingAnArray(int[][] a) {
        int size=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                size++;
            }
        }

        int[] linearized = new int[size];
        int counter=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                linearized[counter]=a[i][j];
                counter++;
            }
        }

        System.out.println(Arrays.toString(linearized));
        return linearized;
    }

    public static int findIndexOfLargest(int[] a){
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[max]<a[i]){
                max=i;
            }
        }
        return max;
    }






}