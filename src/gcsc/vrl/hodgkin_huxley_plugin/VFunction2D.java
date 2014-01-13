/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcsc.vrl.hodgkin_huxley_plugin;


import eu.mihosoft.vrl.annotation.*;
import eu.mihosoft.vrl.math.Function2D;

/**
 *
 * @author myra
 */
public class VFunction2D implements Function2D{
      
    public double gBarK;
    public double eK;
    public double gBarNa;
    public double eNa;
    public double gBarL;
    public double eL;
    public double i;
    public double cm;
    
    private double n;
    private double m;
    private double h;

    public VFunction2D(
            @ParamInfo(name="gBar_K in mS/mm^2", options="value=0.36D") double gBarK, 
            @ParamInfo(name="E_K in mV", options="value=-77.00D")double eK, 
            @ParamInfo(name="gBar_Na in mS/mm^2", options="value=1.2D") double gBarNa, 
            @ParamInfo(name="E_Na in mV", options="value=50.00D") double eNa, 
            @ParamInfo(name="gBar_L in mS/mm^2", options="value=0.003D") double gBarL, 
            @ParamInfo(name="E_L in mV", options="value=-54.387D") double eL, 
            @ParamInfo(name="externally injected current in mA/cm^2", options="value=0.50D") double i,
            @ParamInfo(name="Membrane conductance in uF/cm^2", options="value=1.0D") double cm) {
        this.gBarK = gBarK;
        this.eK = eK;
        this.gBarNa = gBarNa;
        this.eNa = eNa;
        this.gBarL = gBarL;
        this.eL = eL;
        this.i = i;
        this.cm = cm;
        
        
    }

//    public void setgBarK(
//             @ParamInfo(name="gBar_K in mS/mm^2", options="value=0.36D") double gBarK) {
//        this.gBarK = gBarK;
//    }
//
//    public void seteK(
//            @ParamInfo(name="E_K in mV", options="value=-77.00D") double eK) {
//        this.eK = eK;
//    }
//
//    public void setgBarNa(
//            @ParamInfo(name="gBar_Na in mS/mm^2", options="value=1.2D") double gBarNa) {
//        this.gBarNa = gBarNa;
//    }
//
//    public void seteNa(
//            @ParamInfo(name="E_Na in mV", options="value=50.00D") double eNa) {
//        this.eNa = eNa;
//    }
//
//    public void setgBarL(
//            @ParamInfo(name="gBar_L in mS/mm^2", options="value=0.003D") double gBarL) {
//        this.gBarL = gBarL;
//    }
//
//    public void seteL(
//            @ParamInfo(name="E_L in mV", options="value=-54.387D") double eL) {
//        this.eL = eL;
//    }
//
//    public void setCm(
//            @ParamInfo(name="Membrane conductance in uF/cm^2", options="value=1.0D") double cm) {
//        this.cm = cm;
//    }
//    
//    
//    public void setI(
//             @ParamInfo(name="externally injected current in mA/cm^2", options="value=0.50D") double i) {
//        this.i = i;
//    }

    public void setN(double n) {
        this.n = n;
    }

    public void setM(double m) {
        this.m = m;
    }

    public void setH(double h) {
        this.h = h;
    }
//
//    public double getgBarK() {
//        return gBarK;
//    }
//
//    public double geteK() {
//        return eK;
//    }
//
//    public double getgBarNa() {
//        return gBarNa;
//    }
//
//    public double geteNa() {
//        return eNa;
//    }
//
//    public double getgBarL() {
//        return gBarL;
//    }
//
//    public double geteL() {
//        return eL;
//    }
//
//    public double getI() {
//        return i;
//    }
//
//    public double getCm() {
//        return cm;
//    }

    public double getN() {
        return n;
    }

    public double getM() {
        return m;
    }

    public double getH() {
        return h;
    }
   
    
      
    
    @Override
    public Double run(Double x, Double y) {
       
        return (i-(Math.pow(n,4)*gBarK*(y - eK) + Math.pow(m,3)*h*(y - eNa) + gBarL*(y - eL)))/cm;
        
    }
    
      
}
