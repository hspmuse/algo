package test.test02;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, Exception {


        byte[] arr = {0, 127, 123, 12, 2, 4, 12, 4, 55, 2};
        int desc =5, src=0, size=3;
        memcpy(arr, desc, src, size);

        for(int j=0; j < arr.length ; j++){
            System.out.print(arr[j] + " ");
        }

        System.out.println("");

        byte[] arr1 = {0, 127, 123, 12, 2, 4, 12, 4, 55, 2};
        int desc1 =5, src1=0, size1=-1;
        memcpy(arr1, desc1, src1, size1);

        for(int j=0; j < arr1.length ; j++){
            System.out.print(arr1[j] + " ");
        }

    }

    public byte[] byteToStringArr(String[] strArr) {
        byte[] r = new byte[strArr.length];
        for(int i=0; i<strArr.length; i++) {
            int k = Integer.valueOf(strArr[i]);
            r[i] = (byte) k;
        }
        return r;
    }


    public static void memcpy(byte[] v, int desc, int src, int size) {
        if(size < 1) return;
        System.arraycopy(v, src , v, desc, size);
    }
}
