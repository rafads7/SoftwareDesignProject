/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rafad
 */
public class RandomGenerator {
   
    final int MAXIMUM_VERTEXS = 8, MINIMUM_VERTEXS = 5;
    final int MAXIMUM_EDGES = getMaximumLines();
    final int STAGE = 800, WIDTH = 50, HEIGHT = 50;
    List<Vertex> vertexs = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    
    void RandomGenerator(){
        setRandomVertexs();
        setRandomEdges();
    }
    
    private void setRandomVertexs(){
        Random random = new Random();
        int totalVertexs = random.nextInt(MAXIMUM_VERTEXS - MINIMUM_VERTEXS) + MINIMUM_VERTEXS, currentVertexs = 0, position = 0;
        boolean[][] map = new boolean[MAXIMUM_VERTEXS][MAXIMUM_VERTEXS];
        
        for(int i=0; i<MAXIMUM_VERTEXS; i++){
            if(currentVertexs<totalVertexs && random.nextBoolean()){
                position = random.nextInt(MAXIMUM_VERTEXS);
                if(!map[i][position]){
                    map[i][position] = true;
                    createVertex(i, position);
                    currentVertexs++;
                }
            }
        }
    }
    private void createVertex(int i, int position){
        this.vertexs.add(new Vertex(i, position, WIDTH, HEIGHT));
    } 

    private void setRandomEdges(){
        Random random = new Random();
        int totalEdges = random.nextInt(MAXIMUM_EDGES), vIndex1 = 0, vIndex2 = 0, currentLines = 0;
        Edge e1, e2;
        
        while(currentLines < totalEdges){
            vIndex1 = random.nextInt(vertexs.size());
            vIndex2 = random.nextInt(vertexs.size());
            e1 = new Edge(vertexs.get(vIndex1), vertexs.get(vIndex2));
            e2 = new Edge(vertexs.get(vIndex2), vertexs.get(vIndex1));
            
            if(vIndex1 != vIndex2 && !edges.contains(e1) && !edges.contains(e2)){
                edges.add(e1);
                currentLines++;
            }
        }
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
    
    public List<Vertex> getVertexs(){
        return this.vertexs;
    } 
    public List<Edge> getEdges(){
        return this.edges;
    }
}


//    void setRandomLines() {
//
//        
//        for(origin=0; origin<totalVertexs; origin++){
//            for(destination=0; destination<(totalVertexs-origin);destination++){
//                if(currentLines<totalLines && random.nextBoolean()){
//                    //we need to add edges.notContains(line)
//                    //edges.add(line from origin to destination)
//                }
//            }
//        }
//        //EITHER THE WAY ABOVE OR THE ONE BELOW
//        while(currentLines<totalLines){
//            origin = random.nextInt(stores.size());
//            destination = random.nextInt(stores.size());
//            if(origin!=destination){//we need to add edges.notContains(line)
//                edges.add(edge);
//                currentLines++;
//            }
//
//        }
//        
//        
//    }