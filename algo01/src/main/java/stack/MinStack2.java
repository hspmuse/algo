package stack;

import java.util.Stack;

public class MinStack2 {

    static class StackkWithMin2 extends Stack<Integer> {
        Stack<Integer> s2;
        public StackkWithMin2() {
            s2 = new Stack<Integer>();
        }

        public void push(int value) {
            if(value <= min()) {
                s2.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if(value == min()) s2.pop();
            return value;
        }

        public int min() {
            if(s2.isEmpty()) return Integer.MAX_VALUE;
            else return s2.peek();
        }
    }

    public static void main(String[] args) {
        StackkWithMin2 stack = new StackkWithMin2();
        System.out.println(stack.min());
        stack.push(10);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
    }
}
