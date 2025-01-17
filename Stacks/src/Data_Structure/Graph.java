package Data_Structure;

import java.util.Iterator;

import Interface.GraphADT;

public class Graph<T> implements GraphADT<T> { 
    
    protected final int DEFAULT_CAPACITY = 10; 
    protected int numVertices;   // number of vertices in the graph 
    protected boolean[][] adjMatrix;   // adjacency matrix 
    protected T[] vertices;   // values of vertices 
    
    /** 
     * Creates an empty graph. 
     */ 
    public Graph() { 
        numVertices = 0; 
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY]; 
        this.vertices = (T[])(new Object[DEFAULT_CAPACITY]); 
    }

    /** 
     * Inserts an edge between two vertices of the graph. 
     * 
     * @param vertex1  the first vertex 
     * @param vertex2  the second vertex 
     */ 
    public void addEdge (T vertex1, T vertex2) { 
        addEdge (getIndex(vertex1), getIndex(vertex2)); 
    } 
    
    /** 
     * Inserts an edge between two vertices of the graph. ~
     * 
     * @param index1  the first index 
     * @param index2  the second index 
     */ 
    public void addEdge (int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) { 
            adjMatrix[index1][index2] = true; 
            adjMatrix[index2][index1] = true; 
        } 
    }

    /** 
     * Adds a vertex to the graph, expanding the capacity of the graph 
     * if necessary.  It also associates an object with the vertex. 
     * 
     * @param vertex  the vertex to add to the graph 
     */ 
    public void addVertex (T vertex) { 
        if (numVertices == vertices.length) 
            expandCapacity(); 
            
        vertices[numVertices] = vertex; 
        for (int i = 0; i <= numVertices; i++) { 
            adjMatrix[numVertices][i] = false; 
            adjMatrix[i][numVertices] = false;
         }      
         numVertices++; 
    }

    @Override
    public void removeVertex(T vertex) {
        if (indexIsValid(index))
      {
         numVertices--;

         for (int i = index; i < numVertices; i++)
            vertices[i] = vertices[i+1];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j <= numVertices; j++)
               adjMatrix[i][j] = adjMatrix[i+1][j];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
               adjMatrix[j][i] = adjMatrix[j][i+1];
      }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeEdge'");
    }

    @Override
    public Iterator iteratorBFS(T startVertex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iteratorBFS'");
    }

    @Override
    public Iterator iteratorDFS(T startVertex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iteratorDFS'");
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iteratorShortestPath'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean isConnected() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isConnected'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
}
