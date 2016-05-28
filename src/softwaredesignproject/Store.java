/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

/**
 *
 * @author rafad
 */
public class Store{
    
    private String name = "";
    private Vertex v;
    private int id = 0;
    private int coordX = 0, coordY = 0;
    
    public Store(int coordX, int coordY, int id) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.id = id;
    }
    
    public Store(String name, int coordX, int coordY, int id) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Vertex representStore(){
        this.v = new Vertex(this.coordX, this.coordY, this.getName());
        return this.v;
    }
    
    public Vertex getVertexRepresentation(){
        return this.v;
    }
    
}
