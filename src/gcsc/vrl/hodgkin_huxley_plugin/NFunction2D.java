/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gcsc.vrl.hodgkin_huxley_plugin;

//TODO: needs to implement differentialequations from apache
import eu.mihosoft.vrl.annotation.*;
import eu.mihosoft.vrl.math.Function2D;

/**
 *
 * @author myra
 */
public class NFunction2D implements Function2D{
   
    private double n;

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public NFunction2D() {
        
    }
    
    
     /**
     * implementation of the steady state (in)activation function in the HH model
     * @param V membrane voltage (mV)
     * @return Steady state inactivation function n_infinity
     */
    @MethodInfo(name="n infinity", noGUI=true)
    public double ninf(double V){
        double alpha_n;
        double beta_n; 
        
        if(V==-55){
            alpha_n = 1/10;        
        }else{
            alpha_n = 0.01*(V + 55)/(1-(Math.exp(-0.1*(V+55))));
        }
        beta_n = 0.125 * Math.exp(-0.0125*(V+65));
        
        return alpha_n/(alpha_n + beta_n);
    }
    
    /**
     * Implementation of the voltage-dependent time constant in the HH model 
     * @param V membrane voltage (mV)
     * @return voltage dependent time constant tau_n
     */
    @MethodInfo(name="time constant Tau n", noGUI=true)
    public double taun(double V){
        double alpha_n;
        double beta_n; 
        
        if(V==-55){
            alpha_n = 1/10;        
        }else{
            alpha_n = 0.01*(V + 55)/(1-(Math.exp(-0.1*(V+55))));
        }
        beta_n = 0.125 * Math.exp(-0.0125*(V+65));
        
        return 1/(alpha_n + beta_n);
    }
    
   @Override 
   public Double run(Double x, Double y){
     
      n = (ninf(y)-n)/taun(y);
      return n;
       
   }  
   
   
}
