/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesignproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author rafad
 */
public class DistributionNetworkController implements ActionListener{
    
    private IView distributionNetworkView, ordersView;
    private IDistributionNetwork distributionNetworkModel;
    private Graph networkMap;
    private String provider = "";
    
    //este es el metodo tal como lo teniamos por la tarde,, pero el otro es tal como dice la pagina aquella de conversor d pesetas
    public DistributionNetworkController(){
        distributionNetworkView = new DistributionNetworkView();
        distributionNetworkModel = new DistributionNetwork();
        
        distributionNetworkModel.createDistributionNewtork();
        networkMap = distributionNetworkModel.getNetworkMap();
        //distributionNetworkView.loadNetworkMap(networkMap);
       
        distributionNetworkView.setVisibility(true);
        
    }
    
    public DistributionNetworkController(IDistributionNetwork model, IView view){
      
        this.distributionNetworkModel = model;
        this.distributionNetworkView = view;
        
        model.createDistributionNewtork();
        networkMap = model.getNetworkMap();
        
        view.setVisibility(true);
    }
    
    public Graph getNetworkMap(){
        return this.networkMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        b.setBackground(Color.cyan);
        this.provider = b.getText();
        ordersView = new OrdersView();
        ordersView.setVisibility(true);
        ordersView.setController(this);
        ordersView.start();        
    }
    
    public String getProvider(){
        return this.provider;
    }
}
