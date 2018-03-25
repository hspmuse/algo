package test.test01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean loop = true;
        while(loop) {
            String input = br.readLine();
            String[] in = input.split(" ");

            //입력값 검증, 두개의 인자가 입력되었는지, 입력값의 범위가 0~1024 인지.
            if( in.length == 2
                    && Integer.valueOf(in[0])>= 0 && Integer.valueOf(in[0]) <= 1024
                    && Integer.valueOf(in[1])>= 0 && Integer.valueOf(in[1]) <= 1024
                    ) {

                System.out.println(Integer.valueOf(in[0]) * Integer.valueOf(in[1]));
                loop = false;
            }
        }

    }

}
