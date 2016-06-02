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
public class SoftwareDesignProject {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IView storeView = null, trafficView = null, ordersView = null;
        
        DistributionNetwork distributionNetworkModel = new DistributionNetwork();
        IView distributionNetworkView = new DistributionNetworkView();
        
        DistributionNetworkController controller = new DistributionNetworkController(distributionNetworkModel, distributionNetworkView, storeView, trafficView, ordersView);
        
        distributionNetworkView.setController(controller);
        distributionNetworkView.start();

    }
    
    //asi lo habiamos hecho esta tarde,, peor el d arriba es tal como lo hace el conversor de pesetas
//    public static void main(String[] args) {
//        DistributionNetworkController controller = new DistributionNetworkController();
//    }
    
}
