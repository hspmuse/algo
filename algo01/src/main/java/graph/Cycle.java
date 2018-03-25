package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Cycle {

    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Cycle(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }

    boolean isCyclicUtil(int v, boolean visted[], boolean recStack[]) {

        int i;

        if(!visted[v]) {
            visted[v] = true;
            recStack[v] = true;

            Iterator<Integer> it = adj[v].iterator();
            if(it.hasNext()) {
                i=it.next();
                if(!visted[i] && isCyclicUtil(i, visted, recStack)) return true;
                else if ( recStack[i]) return true;
            }

        }
        recStack[v] = false;
        return false;
    }

    boolean isCycle() {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        for(int i=0; i<V; i++) {
            visited[i] = false;
            recStack[i] = false;
        }
        for(int i=0; i < V; i++) {
            if(isCyclicUtil(i, visited, recStack)) return true;
        }
        return false;
    }


    public static void main(String args[])
    {
        Cycle g = new Cycle(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if(g.isCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");



        Cycle g1 = new Cycle(4);

        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
//        g1.addEdge(3, 0);

        if(g1.isCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
