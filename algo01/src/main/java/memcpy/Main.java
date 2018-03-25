package memcpy;


import java.util.Arrays;

public class Main {

    public static void  main(String[] args) {

        byte[] src = {1, 2, 3, 4};
        byte[] dst = {5, 6, 7, 8, 9, 10};

        System.arraycopy(src, 1, dst, 3, 2);

        print(Arrays.toString(dst));

        char[] src1 = {'1', '2', '3', '4'};
        char[] dst1 = {'5', '6', '7', '8', '9', '1'};

        System.arraycopy(src1, 1, dst1, 3, 2);

        print(Arrays.toString(dst1));
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}
