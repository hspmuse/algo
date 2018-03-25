package test.test05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {

        Queue queue = new Queue();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean loop = true;
        while (loop) {
            String input = br.readLine();
            String cmd = input.split(" ")[0];
            if(cmd.equals("add")) {
                int value = Integer.valueOf(input.split(" ")[1]);
                queue.add(value);
            } else if(cmd.equals("min")) {
                System.out.println(queue.min());
            } else if(cmd.equals("remove")) {
                System.out.println(queue.remove());
            } else if(cmd.equals("exit")) {
                loop = false;
            }
        }
//        queue.add(5);
//        queue.add(2);
//        queue.add(6);
//        System.out.println(queue.min());

    }


    static class Queue extends LinkedList<Integer> {
        Stack<Integer> s2;
        public Queue() {
            s2 = new Stack<Integer>();
        }

        public void add(int value) {
            if(value <= min()) {
                s2.push(value);
            }
            super.add(value);
        }

        public Integer remove() {
            int value = super.poll();
            if(value == min()) s2.pop();
            return value;
        }

        public int min() {
            if(s2.isEmpty()) return Integer.MAX_VALUE;
            else return s2.peek();
        }
    }
}
