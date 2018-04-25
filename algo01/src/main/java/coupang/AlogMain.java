package coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlogMain {

    public static void main(String[] args) {
        //find sum 11
        int[] numArr = {1,3,2,4,8,5,6,9,11};

//        numArr = BubbleSortAsc(numArr);

        Arrays.sort(numArr);
        printIntArr(numArr);



        for(int i=0; i<numArr.length; i++) {
            int sum = 0;
            List<Integer> aList = new ArrayList<Integer>();
            for(int j=0; j<numArr.length; j++) {
                sum = sum + numArr[i];
                if(sum==11) aList.add(numArr[i]);
                else if (sum > 11) break;
            }
            System.out.println(aList);
        }
    }

    public static void printIntArr(int[] numArr) {
        for(int i=0; i<numArr.length; i++) {
            if(i < numArr.length-1) System.out.print(numArr[i] + ",");
            else System.out.println(numArr[i]);
        }
    }

    public static int[] BubbleSortAsc(int [] items) {
//        printIntArr(items);
        for(int i=0;i<items.length-1;i++) {
            for(int j=0; j<items.length-1; j++) {
                if (items[j] > items[j+1]) { //원소를 비교하여 앞 원소가 크다면..
                    int temp = items[j]; //앞 원소를 임시 저
                    items[j] = items[j+1]; //앞 원소의 자리에 다음 원소 값 저장
                    items[j+1] = temp; //다음 원소의 자리에 임시로 저장했던 원소값 저
                }
            }
        }
//        printIntArr(items);
        return items;
    }

}
