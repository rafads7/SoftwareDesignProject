/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.util.List;
import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author rafad
 */
public class Graph extends SimpleWeightedGraph<Vertex, Edge>{
    

    public Graph(EdgeFactory<Vertex, Edge> ef){
        super(ef);
    }
    
    public Graph(Class<? extends Edge> edgeClass){
        this(new ClassBasedEdgeFactory<>(edgeClass));
    }


    public void createGraph(List<Vertex> vertexs, List<Edge> edges) {
        addVertexsToGraph(vertexs);
        addEdgesToGraph(edges);
    }
    
    private void addVertexsToGraph(List<Vertex> vertexs){
        for(Vertex v : vertexs){
            this.addVertex(v);
        }
    }

    private void addEdgesToGraph(List<Edge> edges) {
        for(Edge e : edges){
            this.addEdge(e.getV1(), e.getV2(), e);
        }
        
//        for(Edge e : edges){
//            this.addEdge(e.getV1(), e.getV2());
//            this.getEdge(e.getV1(), e.getV2()).setV1(e.getV1());
//            this.getEdge(e.getV1(), e.getV2()).setV2(e.getV2());
//        }
    }
}
