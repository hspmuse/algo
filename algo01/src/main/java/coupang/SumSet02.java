package coupang;

import java.util.*;

/**
 * Created by hspmuse on 2018. 4. 25..
 */
public class SumSet02 {

    public static void main(String[] args) {

        int[] arr = {1,3,2,4,8,5,6,9,11};
        int targetSum = 11;
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("targetSum = " + targetSum);

        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Integer> mapForIndex = makeIndexMapFrom(arr);

        for(int i=0; i<arr.length; i++) {
            List<Integer> result = new ArrayList<>();
            int sum = 0;
//            result.add(arr[i]);
            result.add(arr[i]);
            for( int j=0; j<arr.length; j++) {
                if(sum==0) sum = arr[i];
//                else sum = sum + arr[j];

                if(sum == targetSum) {
                    result.add(sum);
                    break;
                } else if(sum < targetSum){
                    if(mapForIndex.get(targetSum-sum) == null) {
                        result.add(arr[j]);
                        sum = sum + arr[j];
                    } else {
                        result.add(targetSum-sum);
                        break;
                    }
                } else {
                    break;
                }
            }
            results.add(result);
        }

        System.out.println(results);

    }

    public static void findMap(int sum, int target, int index, int[] arr, Map<Integer,Integer> partMap)
    {
        int i = target-sum;
        if(partMap.get(i) == null) {
            sum = sum + arr[++index];
            findMap(sum, target, index, arr, partMap);
        } else {

        }
    }


    private static Map<Integer, Integer> makeIndexMapFrom(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);
        return map;
    }


}
