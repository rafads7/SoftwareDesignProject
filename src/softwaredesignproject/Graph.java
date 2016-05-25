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
public class Graph{
    
    private SimpleWeightedGraph<Vertex, Edge> graph;
    private List<Vertex> lVertex;
    private List<Edge> lEdges;

    public Graph() {
        this.lVertex = new ArrayList<>();
        this.lEdges = new ArrayList<>();
        createNewGraph();
    }
    
    public void createNewGraph(){
        RandomGenerator rg = new RandomGenerator();
        this.lVertex = rg.getVertexs();
        this.lEdges = rg.getEdges();
    }

    public List<Vertex> getlVertex() {
        return lVertex;
    }

    public void setlVertex(List<Vertex> lVertex) {
        this.lVertex = lVertex;
    }

    public List<Edge> getlEdges() {
        return lEdges;
    }

    public void setlEdges(List<Edge> lEdges) {
        this.lEdges = lEdges;
    }
}
