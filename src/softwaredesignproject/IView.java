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
public interface IView {

    
    public void start();
    public void setController(DistributionNetworkController c);
    public void setVisibility(boolean v);

    static final String EXECUTE = "Execute", TRAFFIC = "Finish";
}
