/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import org.jgrapht.EdgeFactory;

/**
 *
 * @author rafad
 */
public class DistributionNetwork implements IDistributionNetwork{

    Graph graph;
    
    @Override
    public void createDistributionNewtork() {
        this.graph = new Graph();
    }

    @Override
    public void registerOrder() {}

    
    
}
