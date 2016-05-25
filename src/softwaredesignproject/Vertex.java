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
public class Vertex {
    
    private int coordX, coordY, width, height;

    public Vertex(int coordX, int coordY, int width, int height) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.width = width;
        this.height = height;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public double getCenterX(){
        return this.coordX + (this.width/2);
    }
    
    public double getCenterY(){
        return this.coordY + (this.height/2);
    }
}
