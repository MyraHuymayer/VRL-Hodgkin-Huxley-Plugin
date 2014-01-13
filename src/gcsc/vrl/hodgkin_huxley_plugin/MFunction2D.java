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
public class MFunction2D implements Function2D{
    
    private double m;

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public MFunction2D() {
    }
    
    
    /**
     * implementation of the steady state (in)activation function in the HH model
     * @param V membrane voltage (mV) 
     * @return Steady state inactivation function m_infinity
     */
    @MethodInfo(name="m infinity", noGUI=true)
    public double minf(double V){
        double alpha_m;
        double beta_m;
        if(V==-40){
            alpha_m = 1;
        }else{
            alpha_m = 0.1*(V+40)/(1-(Math.exp(-0.1*(V+40))));
        }
        
        beta_m = 4*Math.exp(-0.0556*(V+65));
        
        return alpha_m/(alpha_m + beta_m);
    }
    
    
    /**
     * Implementation of the voltage-dependent time constant in the HH model 
     * @param V membrane voltage (mV)
     * @return voltage dependent time constant tau_m
     */
    
    @MethodInfo(name="time constant Tau m", noGUI=true)
    public double taum(double V){
        double alpha_m;
        double beta_m;
        if(V==-40){
            alpha_m = 1; //fallunterscheidung ist schon noetig;morgen nochmal michael fragen, welche werte man nehmen sollte 
        }else{
            alpha_m = 0.1*(V+40)/(1-(Math.exp(-0.1*(V+40))));
        }
        
        beta_m = 4*Math.exp(-0.0556*(V+65));
        
        return 1/(alpha_m + beta_m);
    }
    
    @Override 
   public Double run(Double x, Double y){
       
       m = (minf(y)-m)/taum(y);
     
      return m;
       
   }   
   
 
    
}
