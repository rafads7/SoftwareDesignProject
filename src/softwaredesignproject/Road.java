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
public class Road{
    
    private Store s1;
    private Store s2;
    private boolean available = true;
    
    public Road(Store s1, Store s2) {
        this.s1 = s1;
        this.s2 = s2;
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
    
    public Edge representRoad(){
        return new Edge(this.s1.getVertexRepresentation(), this.s2.getVertexRepresentation());
    }
    
    
}
