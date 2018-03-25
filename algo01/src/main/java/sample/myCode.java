package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class myCode {

    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean loop = true;
        while(loop) {
            String input = br.readLine();
            System.out.println(input);

            if(Integer.valueOf(input)> 0 && Integer.valueOf(input) <= 100) {
                for (int i = 0; i < Integer.valueOf(input); i++) {
                    System.out.println("Hello");
                }
                loop = false;
            }
        }

    }
}
