/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.jgrapht.EdgeFactory;

/**
 *
 * @author rafad
 */
public class DistributionNetwork implements IDistributionNetwork{

    final int MAXIMUM_STORES = 8, MINIMUM_STORES = 5;
    final int WIDTH = 50, HEIGHT = 50;

    Graph graph;
    List<Store> stores;
    List<Road> roads;
    
    @Override
    public void createDistributionNewtork() {

        initialize();
        int storesNumber = getRandomStoresNumber();
        int roadsNumber = getRandomRoadsNumber(storesNumber);
        
        createDistributionNetworkMap(storesNumber, roadsNumber);
        createGraph();
    }
    
    private void createGraph(){
        this.graph.createGraph(prepareVertexs(), prepareEdges());
    }
    
    private List<Vertex> prepareVertexs(){
        List<Vertex> vertexs = new ArrayList<>();
        for(Store s : this.stores){
            vertexs.add(s.representStore());
        }
        return vertexs;
    }
    private List<Edge> prepareEdges(){
        List<Edge> edges = new ArrayList<>();
        for(Road r : this.roads){
            edges.add(r.representRoad());
        }
        return edges;
    }
    
    private void initialize(){
        EdgeFactory<Vertex, Edge> ef = (Vertex v, Vertex v1) -> new Edge(v,v1);
        this.graph = new Graph(ef);
        this.stores = new ArrayList<>();
        this.roads = new ArrayList<>();
    }

    private int getRandomStoresNumber(){
        Random random = new Random();
        return random.nextInt(MAXIMUM_STORES - MINIMUM_STORES) + MINIMUM_STORES;
    }
    private int getRandomRoadsNumber(int storesNumber){
        Random random = new Random();   
        return random.nextInt(this.getMaximumRoads(storesNumber));
    }    
    
    private void createDistributionNetworkMap(int sNumber, int rNumber){
        createStores(sNumber);
        createRoads(rNumber);
    }
    private void createStores(int sNumber) {
        Random random = new Random();
        int currentStores = 0, position = 0;
        boolean[][] map = new boolean[MAXIMUM_STORES][MAXIMUM_STORES];
        
        for(int i=0; i<MAXIMUM_STORES; i++){
            if(currentStores < sNumber && random.nextBoolean()){
                position = random.nextInt(MAXIMUM_STORES);
                if(!map[i][position]){
                    map[i][position] = true;
                    currentStores++;
                    this.stores.add(new Store("S"+String.valueOf(currentStores),i*100, position*100,currentStores));
                }
            }
        } 
    }
    private void createRoads(int rNumber) {
        Random random = new Random();
        int sIndex1 = 0, sIndex2 = 0, currentRoads = 0;
        Road r1, r2;
        
        while(currentRoads < rNumber){
            sIndex1 = random.nextInt(this.stores.size());
            sIndex2 = random.nextInt(this.stores.size());
            r1 = new Road(this.stores.get(sIndex1), this.stores.get(sIndex2));
            r2 = new Road(this.stores.get(sIndex2), this.stores.get(sIndex1));
            
            if(sIndex1 != sIndex2 && !this.roads.contains(r1) && !this.roads.contains(r2)){
                this.roads.add(r1);
                currentRoads++;
            }
        }
    }
    
    @Override
    public Graph getNetworkMap(){
        return this.graph;
    }
    
    private int getMaximumRoads(int storesNumber){
        int ret = 0;
        int totalStores = storesNumber-1;
        while(totalStores>0){
            ret = ret + totalStores;
            totalStores--;
        }      
        return ret;
    }
    public Graph getGraph() {
        return graph;
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    public List<Store> getStores() {
        return stores;
    }
    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
    public List<Road> getRoads() {
        return roads;
    }
    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }
    
}
