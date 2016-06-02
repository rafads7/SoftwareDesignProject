/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author rafad
 */
public class Store{
    
    private String name = "";
    private String products = "";
    private Vertex v;
    private int id = 0;
    private boolean provider = false;
    private boolean orders = false;
    
    public Store(Vertex v, int id) {
        this.v = v;
        this.id = id;
    }
    
    public Store(String name, Vertex v, int id) {
        this.v = v;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vertex getV() {
        return this.v;
    }

    public void setV(Vertex v) {
        this.v = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean hasOrders() {
        return orders;
    }

    public void setOrders(boolean orders) {
        this.orders = orders;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
    
    public Vertex representStore(){
        return this.v;
    }    
    
    public boolean isProvider(){
        return this.provider;
    }
    
    public void setProvider(){
        this.provider = true;
    }

    public void drawStore(JPanel panel) {
        JButton store;
        //vertex = new RoundButton("iep", new ImageIcon("C:\\Users\\rafad\\Desktop\\Rafa\\European Master Software Engineering\\2nd\\Software Design\\SoftwareDesignProject\\color.png"));
        store = new JButton();
        store.setText(this.getName());
        store.setName(String.valueOf(this.id));
        store.setSize(50, 50);
        store.setLocation(this.v.getCoordX(), this.v.getCoordY());
        store.setVisible(true);
        panel.add(store);
        //vertex.addActionListener(controller);
        if(!isProvider()){
            setStoreBehaviour(store);
        }else{
            store.setBackground(Color.cyan);
        }
    }
    
    private void setStoreBehaviour(JButton store){
        Store s = this;
        store.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {              
                StoreView storeView = new StoreView(s);
                storeView.setVisible(true);
            }
        });
    }  
}
