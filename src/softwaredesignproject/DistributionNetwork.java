/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import org.jgrapht.EdgeFactory;
import org.jgrapht.alg.DijkstraShortestPath;

/**
 *
 * @author rafad
 */
public class DistributionNetwork{

    final int MAXIMUM_STORES = 8, MINIMUM_STORES = 5;
    final int WIDTH = 50, HEIGHT = 50;

    private Graph graph;
    private List<Store> stores;
    private List<Road> roads;  
    private JPanel panel;
    private String paintAgain;
    
    public DistributionNetwork() {

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
        int ret = random.nextInt(MAXIMUM_STORES - MINIMUM_STORES) + MINIMUM_STORES;
        if(ret == 1 || ret == 0){
            ret = 2;
        }
        return ret;
    }
    private int getRandomRoadsNumber(int storesNumber){
        Random random = new Random();   
        int ret = random.nextInt(this.getMaximumRoads(storesNumber));
        if(ret == 0){
            ret = 1;
        }
        return ret;
    }    
    
    private void createDistributionNetworkMap(int sNumber, int rNumber){
        createStores(sNumber);
        createRoads(rNumber);
    }
    private void createStores(int sNumber) {
        Random random = new Random();
        int currentStores = 0, position = 0;
        boolean[][] map = new boolean[MAXIMUM_STORES][MAXIMUM_STORES];
        String name = "";
        
        for(int i=0; i<MAXIMUM_STORES; i++){
            if(currentStores < sNumber && random.nextBoolean()){
                position = random.nextInt(MAXIMUM_STORES);
                if(!map[i][position]){
                    map[i][position] = true;
                    currentStores++;
                    name = "S"+String.valueOf(currentStores);
                    this.stores.add(new Store(name, new Vertex(i*100, position*100, name),currentStores));
                }
            }
        } 
    }
    private void createRoads(int rNumber) {
        Random random = new Random();
        int sIndex1 = 0, sIndex2 = 0, currentRoads = 0, i=0;
        Road r1, r2, aux;
        boolean found = false;
        
        while(currentRoads < rNumber){
            found = false;
            sIndex1 = random.nextInt(this.stores.size());
            sIndex2 = random.nextInt(this.stores.size());
            r1 = new Road(this.stores.get(sIndex1), this.stores.get(sIndex2));
            r2 = new Road(this.stores.get(sIndex2), this.stores.get(sIndex1));            
            if(sIndex1 != sIndex2){
                i=0;
                while(i<this.roads.size() && !found){
                    aux = this.roads.get(i);
                    if(aux.isEqual(r1) || aux.isEqual(r2)){
                        found = true;
                    }
                    i++;
                }            
                if(!found){
                    this.roads.add(r1);
                    currentRoads++;
                }
            }
        }
    }
    
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
        return this.roads;
    }
    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }
    
    public void drawStores(JPanel panel, String paintAgain){
        this.panel = panel;
        this.paintAgain = paintAgain;
        Random random = new Random();
        int provider = random.nextInt(this.getStores().size()) + 1;
        for(Store s : this.getStores()){
            if(s.getId() == provider){
                s.setProvider();
            }
            s.drawStore(panel);
        }
    }
    
    public void drawRoads(Graphics g){
        for(Road r: this.getRoads()){  
            if(r.isAvailable()){
                r.drawRoad(g, Color.black);
            }else{
                r.drawRoad(g, Color.red);
            }
        }
    }

    public List<Store> getStoresWithOrders() {
        List<Store> st = new ArrayList<>();
        for(Store s : this.getStores()){
            if(s.isProvider()){
                st.add(0, s);
            }
            else if(s.hasOrders()){
                st.add(s);
            }
        }       
        return st;
    }
    
    private void manageGraph(){
        for(Road r : this.getRoads()){
            if(!r.isAvailable()){
                this.graph.removeEdge(r.getEdge());
            }
        }
    }
    
    public List<Edge> defineDistributionNetwork(List<Store> stores)
    {
        List<Edge> finalRoute = new ArrayList<>();
        manageGraph();
        finalRoute = DijkstraShortestPath.findPathBetween(this.graph, stores.get(0).getV(),stores.get(1).getV());

        for(int i=2;i<stores.size();i++)
        {
            if(!this.findStore(stores.get(i), finalRoute))
            {
                List<Edge> subPath = DijkstraShortestPath.findPathBetween(this.graph, stores.get(0).getV(),stores.get(i).getV());
                if(subPath!=null && !subPath.isEmpty()){
                    for(int j=0;j<subPath.size();j++)
                    {
                        if(finalRoute==null){
                            finalRoute = new ArrayList<>();
                        }
                        finalRoute.add(subPath.get(j));
                    }
                }
            }
        }      
        return finalRoute;        
    }

    private boolean findStore(Store searchedStore, List<Edge> finalRoute)
    {
        boolean found=false;
        int i=0;

        if(finalRoute!=null && !finalRoute.isEmpty()){
            while (i< finalRoute.size() && !found)
            {
                if(finalRoute.get(i).getV1().equals(searchedStore) ||
                    finalRoute.get(i).getV2().equals(searchedStore))
                {
                    found=true;
                }
                i++;
            }
        }
        return found;
    }

    public JPanel getDistributionNetworkPanel() {
        return this.panel;
    }

    public void setPaintAgain(String p) {
        this.paintAgain = p;
    }
    
    
}
