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
public class DistributionNetworkController {
    
    private IView view;
    private IDistributionNetwork distributionNetworkModel;
    
    public DistributionNetworkController(){
        view = (IView) new View();
        distributionNetworkModel = new DistributionNetwork();
        
        distributionNetworkModel.createDistributionNewtork();
        
        //view.provideData();
        //DistributionNetworkModel.provideData();
    }
}
