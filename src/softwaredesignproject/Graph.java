/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author rafad
 */
public class Graph{
    
    final int MAXIMUM_VERTEXS = 8, MINIMUM_VERTEXS = 5, MAXIMUM_EDGES = getMaximumLines();
    final int WIDTH = 50, HEIGHT = 50;
    
    private SimpleWeightedGraph<Vertex, Edge> graph;
    private List<Vertex> lVertexs;
    private List<Edge> lEdges;

    public Graph() {

        initialize();
        int vertexsNumber = getRandomVertexsNumber();
        int edgesNumber = getRandomEdgesNumber();
        createGraph(vertexsNumber, edgesNumber);
        addVertexsAndEdgesToGraph();
    }
    
    private void initialize(){
        this.lVertexs = new ArrayList<>();
        this.lEdges = new ArrayList<>();
        this.graph = new SimpleWeightedGraph<>(Edge.class);
    }
    private int getRandomVertexsNumber(){
        Random random = new Random();
        return random.nextInt(MAXIMUM_VERTEXS - MINIMUM_VERTEXS) + MINIMUM_VERTEXS;
    }
    private int getRandomEdgesNumber(){
        Random random = new Random();
        return random.nextInt(MAXIMUM_EDGES);
    }    
    
    private void createGraph(int vNumber, int eNumber){
        createVertexs(vNumber);
        createEdges(eNumber);
    }
    private void createVertexs(int vNumber) {
        Random random = new Random();
        int currentVertexs = 0, position = 0;
        boolean[][] map = new boolean[MAXIMUM_VERTEXS][MAXIMUM_VERTEXS];
        
        for(int i=0; i<MAXIMUM_VERTEXS; i++){
            if(currentVertexs < vNumber && random.nextBoolean()){
                position = random.nextInt(MAXIMUM_VERTEXS);
                if(!map[i][position]){
                    map[i][position] = true;
                    this.lVertexs.add(new Vertex(i*100, position*100, WIDTH, HEIGHT));
                    currentVertexs++;
                }
            }
        } 
    }
    private void createEdges(int eNumber) {
        Random random = new Random();
        int vIndex1 = 0, vIndex2 = 0, currentLines = 0;
        Edge e1, e2;
        
        while(currentLines < eNumber){
            vIndex1 = random.nextInt(lVertexs.size());
            vIndex2 = random.nextInt(lVertexs.size());
            e1 = new Edge(lVertexs.get(vIndex1), lVertexs.get(vIndex2));
            e2 = new Edge(lVertexs.get(vIndex2), lVertexs.get(vIndex1));
            
            if(vIndex1 != vIndex2 && !lEdges.contains(e1) && !lEdges.contains(e2)){
                lEdges.add(e1);
                currentLines++;
            }
        }
    }
    private void addVertexsAndEdgesToGraph(){
        
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

}
