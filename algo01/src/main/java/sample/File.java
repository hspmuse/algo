package sample;

import java.util.Scanner;

public class File {
    public static void main(String[] args) {

        String message;
        Scanner scan = new Scanner(System.in);

        System.out.println("메시지를 입력하세요:");

        message = scan.nextLine();

        System.out.println("입력 메시지: \""+ message + "\"");

        for(int i=0; i<Integer.valueOf(message); i++) {
            System.out.println("Hello");
        }
    }
}
