package test.test03;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(4);
        boolean[][] adj = {
                {false,true,true,true},
                {true,false,false,false},
                {true,false,false,false},
                {false,false,true,false}
        };
        graph.setAdj(adj);



    }

    public static class Graph {
        private boolean adj[][];
        private int vert;

        public Graph(int vert) {
            this.vert = vert;
            adj = new boolean[vert][vert];
        }

        public void setAdj(boolean[][] adj) {
            this.adj = adj;
        }

        public boolean isCycle(boolean adj[][], boolean visted) {


            return true;
        }
    }
}
