import java.util.List;

public interface Graph<V> {
    int getSize();
    List<V> getVertices();
    List<V> getVertices(int index);
    int getIndex(V vertex);
    List<Integer> getNeighbors(int index);
    int getDegree(int index);
    void printEdges();
    void clear();
    boolean addVertex(V vertex);
    boolean addEdge(int u, int v);

    GraphTree dfs(int v);
    GraphTree bfs(int v);

    interface GraphTree<V> {
        int getRoot();
        int getParent(int vertex);
        List<Integer> getSearchOrder();
        int getNumberOfVerticesFound();
    }

}

class Vertex<V> {
    V vertex;
    Vertex(V vertex) {
        this.vertex = vertex;
    }
}

class Edge<V> {
    Vertex<V> vertex1;
    Vertex<V> vertex2;


    public Edge(Vertex<V> vertex1, Vertex<V> vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
}


