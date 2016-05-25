/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.util.ArrayList;
import java.util.Random;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author rafad
 */
public class NetworkDistribution extends Grafo{

    public NetworkDistribution() {
        initialize();
        int vertexsNumber = getRandomVertexsNumber();
        int edgesNumber = getRandomEdgesNumber();
        createGraph(vertexsNumber, edgesNumber);
        addVertexsAndEdgesToGraph();
    }
    
    private void initialize(){
        this.lVertexs = new ArrayList<>();
        this.lEdges = new ArrayList<>();
        this.graph = new SimpleWeightedGraph<>(Road.class);
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
        int currentStores = 0, position = 0;
        boolean[][] map = new boolean[MAXIMUM_VERTEXS][MAXIMUM_VERTEXS];
        
        for(int i=0; i<MAXIMUM_VERTEXS; i++){
            if(currentStores < vNumber && random.nextBoolean()){
                position = random.nextInt(MAXIMUM_VERTEXS);
                if(!map[i][position]){
                    map[i][position] = true;
                    this.lVertexs.add(new Store(i*100, position*100, WIDTH, HEIGHT));
                    currentStores++;
                }
            }
        } 
    }
    private void createEdges(int eNumber) {
        Random random = new Random();
        int vIndex1 = 0, vIndex2 = 0, currentLines = 0;
        Road r1, r2;
        
        while(currentLines < eNumber){
            vIndex1 = random.nextInt(lVertexs.size());
            vIndex2 = random.nextInt(lVertexs.size());
            r1 = new Road(lVertexs.get(vIndex1), lVertexs.get(vIndex2));
            r2 = new Road(lVertexs.get(vIndex2), lVertexs.get(vIndex1));
            
            if(vIndex1 != vIndex2 && !lEdges.contains(r1) && !lEdges.contains(r2)){
                lEdges.add(r1);
                currentLines++;
            }
        }
    }
    private void addVertexsAndEdgesToGraph(){
        
    }
    

}
