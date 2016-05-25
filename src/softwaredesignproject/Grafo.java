/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author rafad
 */
public class Grafo implements IGrafo {

    public final int MAXIMUM_VERTEXS = 8, MINIMUM_VERTEXS = 5, MAXIMUM_EDGES = getMaximumLines();
    public final int WIDTH = 50, HEIGHT = 50;
    
    public SimpleWeightedGraph<Vertex, Edge> graph;
    public List<Vertex> lVertexs;
    public List<Edge> lEdges;
    
    @Override
    public void createGraph() {
        this.lVertexs = new ArrayList<>();
        this.lEdges = new ArrayList<>();
        this.graph = new SimpleWeightedGraph<>(Edge.class); 
    }

    public SimpleWeightedGraph<Vertex, Edge> getGraph() {
        return graph;
    }

    public void setGraph(SimpleWeightedGraph<Vertex, Edge> graph) {
        this.graph = graph;
    }

    public List<Vertex> getlVertexs() {
        return lVertexs;
    }

    public void setlVertexs(List<Vertex> lVertexs) {
        this.lVertexs = lVertexs;
    }

    public List<Edge> getlEdges() {
        return lEdges;
    }

    public void setlEdges(List<Edge> lEdges) {
        this.lEdges = lEdges;
    }
    
    private int getMaximumLines(){
        int ret = 0;
        int maxStores = MAXIMUM_VERTEXS-1;
        while(maxStores>0){
            ret = ret + maxStores;
            maxStores--;
        }      
        return ret;
    }
    
    
    
}
