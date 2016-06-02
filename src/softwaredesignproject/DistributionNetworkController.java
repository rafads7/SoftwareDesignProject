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
import javax.swing.JPanel;

/**
 *
 * @author rafad
 */
public class DistributionNetworkController implements ActionListener{
    
    private IView distributionNetworkView; 
    private IView ordersView, trafficView, storeView;
    private DistributionNetwork distributionNetworkModel;
    private String provider = "";
    
    //este es el metodo tal como lo teniamos por la tarde,, pero el otro es tal como dice la pagina aquella de conversor d pesetas
//    public DistributionNetworkController(){
//        distributionNetworkView = new DistributionNetworkView();
//        distributionNetworkModel = new DistributionNetwork();
//
//        //networkMap = distributionNetworkModel.getNetworkMap();
//        //distributionNetworkView.loadNetworkMap(networkMap);
//       
//        distributionNetworkView.setVisibility(true);
//        
//    }
    
    public DistributionNetworkController(DistributionNetwork model, IView disNetView, IView sView, IView tView, IView oView){
      
        this.distributionNetworkModel = model;
        this.distributionNetworkView = disNetView;
        this.ordersView = oView;
        this.storeView = sView;
        this.trafficView = tView;
        
        disNetView.setVisibility(true);
    }
    
    public Graph getNetworkMap(){
        return this.distributionNetworkModel.getNetworkMap();
    }

    public DistributionNetwork getDistributionNetworkModel() {
        return distributionNetworkModel;
    }

    public void setDistributionNetworkModel(DistributionNetwork distributionNetworkModel) {
        this.distributionNetworkModel = distributionNetworkModel;
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        
//        if(e.getActionCommand().equals(distributionNetworkView.EXECUTE)){
//            JButton b = (JButton) e.getSource();
//            if(b.getText().equals(DistributionNetworkView.PREVIEW)){
//                DistributionNetworkView.setPaintAgain("preview");
//                DistributionNetworkView.getPanel().repaint();
//                b.setText(DistributionNetworkView.TRAFFIC_JUMP);
//            }else if(b.getText().equals(DistributionNetworkView.TRAFFIC_JUMP)){
//                this.trafficView = new TrafficJumpView();
//                this.trafficView.setController(DistributionNetworkView.getController());
//                this.trafficView.start();
//                this.trafficView.setVisibility(true);
//                b.setVisible(false);
//            }      
//        }else if(e.getActionCommand().equals(trafficView.TRAFFIC)){
//            
//        }

//        JButton b = (JButton) e.getSource();
//        b.setBackground(Color.cyan);
//        this.provider = b.getText();
//        ordersView = new OrdersView();
//        ordersView.setVisibility(true);
//        ordersView.setController(this);
//        ordersView.start(); 
   
    }
    
    public String getProvider(){
        return this.provider;
    }
    
    public void setPaintAgain(String p){
        this.distributionNetworkModel.setPaintAgain(p);
    }

    public JPanel getDistributionNetworkViewPanel() {
        return this.distributionNetworkModel.getDistributionNetworkPanel();
    }
    
}
