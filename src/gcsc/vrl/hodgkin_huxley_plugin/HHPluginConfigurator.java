/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcsc.vrl.hodgkin_huxley_plugin;

import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;


 /*
 * @author myra
 */
public class HHPluginConfigurator extends VPluginConfigurator{
    
    public HHPluginConfigurator(){
        //specification of plugin name and version
        setIdentifier(new PluginIdentifier("HodkinHuxley-Plugin01","0.1"));
        
        //description of the plugin
        setDescription("Plugin, that implements the differential equations of the Hodgkin Huxley model and returns dem in an array with the following form: [V,n,m,h]. The parameters for the model can be changed by the user");
        
        //copyright info
        setCopyrightInfo("Hodgkin Huxley Plugin",
                "(c) Myra Huymayer", "www.gcsc.uni-frankfurt.com", "License name?", "License text?");
    }
    
    @Override
    public void register(PluginAPI api){
        
        //register plugin with canvas
        if(api instanceof VPluginAPI){
            VPluginAPI vapi = (VPluginAPI) api;
            vapi.addComponent(ODECreator.class);
            vapi.addComponent(ODESolver.class);
        }
    }
    
    @Override
    public void unregister(PluginAPI api){
        //nothing to unregister
    }
    
    @Override
    public void init(InitPluginAPI iApi){
        //nothing to init
    }
            
            
            
}
