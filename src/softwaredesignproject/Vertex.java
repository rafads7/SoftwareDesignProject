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
public class Vertex{
    
    private int coordX = 0, coordY = 0;
    private final int WIDTH = 50, HEIGHT = 50;
    private String label = "";

    public Vertex(int coordX, int coordY, String label) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.label = label;
    }
    
    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    
    public int getCenterX(){
        return this.coordX + (WIDTH/2);
    }
    
    public int getCenterY(){
        return this.coordY + (HEIGHT/2);
    }

    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label){
        this.label = label;
    }
}
