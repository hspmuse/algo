package graph;

import java.util.Stack;

public class Dfs {

    public static void main(String[] args) {
        Vertex vertex = new Vertex('a');
        Graph graph = new Graph();

        graph.addVertex('b');
        graph.addVertex('c');

        graph.dfs();
    }


    public static class Vertex {
        public char label;
        public boolean visited;
        public Vertex(char lab) {
            label = lab;
            visited = false;
        }
    }

    public static class Graph {
        private final int maxVertices = 20;
        private Vertex vertexList[];
        private int adjMatrix[][];
        private int vertexCount;
        private Stack<Integer> theStatck;

        public Graph() {
            vertexList = new Vertex[maxVertices];
            adjMatrix = new int[maxVertices][maxVertices];
            vertexCount = 0;
            for(int y=0; y<maxVertices; y++)
                for(int x=0; x<maxVertices; x++)
                    adjMatrix[x][y] = 0;
            theStatck = new Stack();
        }


        public void addVertex(char lab) {
            vertexList[vertexCount++] = new Vertex(lab);
        }

        public void addEdge(int start, int end) {
            adjMatrix[start][end] = 1;
            adjMatrix[end][start] = 1;
        }

        public void displayVertex(int v) {
            System.out.println(vertexList[v].label);
        }

        public void dfs() {
            vertexList[0].visited = true;
            displayVertex(0);
            theStatck.push(0);
            while(!theStatck.isEmpty()) {
                int v = getAdjUnvisitedVertex(theStatck.peek());
                if( v== -1) {
                    theStatck.pop();
                } else {
                    vertexList[v].visited = true;
                    displayVertex(v);
                    theStatck.push(v);
                }
            }
        }

        public int getAdjUnvisitedVertex(int v) {
            for(int j=0; j<vertexCount; j++) {
                if(adjMatrix[v][j] == 1 && vertexList[j].visited == false) return j;
            }
            return -1;
        }

    }

}
