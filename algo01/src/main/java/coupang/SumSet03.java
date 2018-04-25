package coupang;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hspmuse on 2018. 4. 26..
 */
public class SumSet03 {

    public static void main(String args[]) {
        Integer[] numbers = {1,3,2,4,8,5,6,9,11};
        int target = 11;
        sum_up(new ArrayList<>(Arrays.asList(numbers)), target);
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers, target, new ArrayList<>());
    }

    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {

        int s = 0;
        for(int x : partial) s = s+x;
        if(s == target) System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
        if(s >= target) return;

        for(int i=0; i<numbers.size(); i++) {
            ArrayList<Integer> remain = new ArrayList<>();
            int n = numbers.get(i);
            for(int j=i+1; j<numbers.size(); j++) {
                remain.add(numbers.get(j));
            }
            ArrayList<Integer> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            sum_up_recursive(remain, target, partial_rec);
        }

    }
}
