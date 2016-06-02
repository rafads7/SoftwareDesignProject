/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rafad
 */
public class Road{
    
    private Store s1;
    private Store s2;
    private boolean available = true;
    private Edge edge;
    private String name = "";
    
    public Road(Store s1, Store s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.edge = new Edge(s1.getV(), s2.getV());
        this.name = this.toString();
    }

    public Store getS1() {
        return s1;
    }

    public void setS1(Store s1) {
        this.s1 = s1;
    }

    public Store getS2() {
        return s2;
    }

    public void setS2(Store s2) {
        this.s2 = s2;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public Edge getEdge(){
        return this.edge;
    }
    
    public void setEdge(Edge edge){
        this.edge = edge;
    }
    
    public Edge representRoad(){
        return this.edge;
    }

    public void drawRoad(Graphics g, Color c) {
        
        g.setColor(c);
        g.drawLine(this.edge.getV1().getCenterX(), this.edge.getV1().getCenterY(), this.edge.getV2().getCenterX(), this.edge.getV2().getCenterY());
    }
    
    @Override
    public String toString(){
       return this.s1.getName() + " - " + this.s2.getName();
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isEqual(Road r){
        return this.getName().equals(r.getName());
    }
    
}
