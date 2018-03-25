package stack;

import java.util.Stack;

public class MinStack {


    static class StatckWithMin extends Stack<NodeWithMin> {
        public void push(int value) {
            int newMin = Math.min(value, min());
            super.push(new NodeWithMin(value, newMin));
        }

        public int min() {
            if(this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }
    }


    static class NodeWithMin {
        public int value;
        public int min;
        public NodeWithMin(int v, int min) {
            value = v;
            this.min = min;
        }
    }

    public static void  main(String[] args) {
        StatckWithMin stack = new StatckWithMin();
        System.out.println(stack.min());
        stack.push(10);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
    }
}
