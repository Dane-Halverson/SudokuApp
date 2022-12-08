import org.example.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GraphTest {

    @Test
    void testGraphCreation() {
        Graph g = new Graph();
        g.printGraph();
    }
    @Test
    void addVertices() {
        //add vertex
        Graph g = new Graph();
        Vertex v = new Vertex("1");
        g.addVertex(v);

        int num = g.getVerticesCount();
        assert (num == 1);
    }
    @Test
    void addEdges() {

        Graph g = new Graph();
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        g.addVertex(v1);

        g.addVertex(v2);
        Edge e = new Edge(v1, v2);
        Edge e2 = new Edge(v2, v1);
        g.addEdge(e);
        g.addEdge(e2);
        g.printGraph();
    }


    @Test
    void Traversals() {
        Graph g = new Graph();
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Edge e1 = new Edge(v0, v1);
        Edge e2 = new Edge(v1, v2);
        Edge e3 = new Edge(v0, v3);

        g.addVertex(v0);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);

        System.out.println("Depth first, should be 0, 1, 2, 3");
        DepthFirst d = new DepthFirst();
        d.TraverseGraph(g, v0);

        System.out.println("Breadth first, should be 0, 1, 3, 2");
        BreadthFirst b = new BreadthFirst();
        b.TraverseGraph(g, v0);
    }
    @Test
    void serializable() {
        Graph g = new Graph();
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Edge e = new Edge(v1, v2);

        g.addVertex(v1);
        g.addVertex(v2);
        g.addEdge(e);

        String filename = "graph.ser";

        FileOutputStream fos;
        ObjectOutputStream out;

        try {
            fos = new FileOutputStream(filename);
            out =new ObjectOutputStream(fos);
            out.writeObject(g);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        FileInputStream fis;
        ObjectInputStream in;
        Graph g2 = null;

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            g2 = (Graph) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assert (g.toString() == g2.toString());

    }






}
