import java.lang.reflect.Array;
import java.util.*;


public class GeneralFunctions {

    //ÜPA 1
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

    public static long factorial(long n) {
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

    //ÜPA 2
    public static int[] mergeSort(int[] array) {

        int length = array.length/2;
        int[] leftArray = new int[array.length-length];
        int[] rightArray = new int[length];

        if(array.length<2){
            return array;
        }

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i]=array[i];

        }

        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i]=array[i+leftArray.length];
        }

        leftArray=mergeSort(leftArray);
        rightArray=mergeSort(rightArray);




        return mergeTwoArraysSorted(leftArray,rightArray);
    }

    public static int[] mergeTwoArraysSorted(int[] arr1, int[] arr2) {
        int i = 0, j=0, k=0;
        int[] mergedArray = new int[arr1.length+ arr2.length];

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                mergedArray[k++] = arr1[i++];
            }else{
                mergedArray[k++] = arr2[j++];
            }
        }

        while(i<arr1.length){
            mergedArray[k++]=arr1[i++];
        }

        while(j<arr2.length){
            mergedArray[k++]=arr2[j++];
        }

        return mergedArray;
    }

    protected static int[] merge2DArray(int[][] arrays, int from, int to) {
        if(to-from< 1){
            return new int[0];
        }
        if(to-from==1){
            return arrays[from];
        }
        return mergeTwoArraysSorted(arrays[from],merge2DArray(arrays,from+1,to));
    }

    public static long binomCoeffIterative(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }
        if (k > n) {
            return 0;
        }


        long result = 1;
        for (int i = 1; i <= k; i++) {
            result *= n + 1 - i;
            result /= i;
        }
        return result;
    }

    public static long binomCoeffRecursive(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }
        if (k > n) {
            return 0;
        }

        return binomCoeffRecursive(n-1,k-1)+binomCoeffRecursive(n-1,k);
    }

    public static long fibonacciIterative(int n) {
        if (n <= 0) {
            return 0;
        }
        long last = 1;
        long current = 0;
        long tmp;
        for (int i = 0; i < n; i++) {
            tmp = last + current;
            last = current;
            current = tmp;
        }
        return current;
    }

    public static long fibonacciRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);

    }

    public static void gnomeSort(int[] a) {
        // TODO: implement gnome sort
        int pos = 0;
        while( pos < a.length){
            if(pos==0||a[pos]>=a[pos-1]){
                pos++;
            }else{
                int temp = a[pos];
                a[pos] = a[pos-1];
                a[pos-1]=temp;
                pos--;
                gnomeSort(a);
            }
        }
    }

    public static void stoogeSort(int[] array) {
        stoogeSort(array, 0, array.length);
    }

    public static void stoogeSort(int[] array, int from, int to) {
        int length = to -from;
        if(length==2){
            if(array[from]>array[from+1]){
                int temp = array[from];
                array[from] = array[from+1];
                array[from+1]=temp;

            }else{
                return;
            }
        }

        if(length<2){
            return;
        }

        stoogeSort(array,from, to-(length/3));
        stoogeSort(array,from+(length/3),to);
        stoogeSort(array,from, to-(length/3));

    }

    public static void selectionSortRec(int[] a) {
        selectionSortRec(a, a.length - 1);
    }

    public static void selectionSortRec(int[] a, int toIncl) {
        if(toIncl<=0){
            return;
        }
        //swap max index with last index
        int maxIndex = findIndexOfLargest(a,toIncl);
        swap(a,maxIndex,toIncl);
        selectionSortRec(a,toIncl-1);

    }

    public static int findIndexOfLargest(int[] a, int toIncl) {
        if(toIncl == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex=0;
        for (int i = 0; i <=toIncl; i++) {
            if(a[i]>max){
                max=a[i];
                maxIndex=i;
            }
        }
        //System.out.println(max);
        return maxIndex;
    }

    public static void swap(int[] array, int firstPos, int secondPos) {
        int temp = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos]=temp;
    }

    //finds common items within arrays of collections using HashSet
    public static <T> Collection<T> intersection(Collection<T>[] collections) {
        Set<T> set = new HashSet<>();
        for(final Collection<T> c:collections){
            set.addAll(c);
            break;
        }
        for (final Collection<T> c : collections) {
            if (set.isEmpty()) {
                break;
            }
            set.retainAll(c);
        }
        return set;
    }

    //returns a string representaion of a collection
    public static String toString(Collection<?> collection) {

        if(collection.isEmpty()){
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> itr = collection.iterator();
        while(itr.hasNext()){
            sb.append(itr.next()+", ");
        }
        sb.setLength(sb.length()-2); //remove the last ", "
        return "{"+sb.toString()+"}";
    }

    //generates an array of generic type
    @SuppressWarnings("unchecked")
    public static <T> T[] generateGenericArray(Class<T> clazz, int length) {
        final T[] arr = (T[]) Array.newInstance(clazz, length);
        return arr;
    }

    //returns a collection in a sorted array
    public static <T> T[] specialSort(Class<T> clazz, Collection<T> collection, Comparator<T> comparator) {

        T[] arr= generateGenericArray(clazz,collection.size());
        arr=collection.toArray(arr);
        Arrays.sort(arr,comparator);
        return arr;
    }

    //stores values of a map in a HashSet
    public static <K, V> Set<V> storeValues(Map<K, V> map) {
        final Set<V> set = new HashSet<>();
        for(final Map.Entry<K,V> e: map.entrySet()){
            set.add(e.getValue());
        }
        return set;
    }


}