/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gcsc.vrl.hodgkin_huxley_plugin;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

/**
 *
 * @author myra
 */
public class HHequs implements FirstOrderDifferentialEquations{
    
    public double gBarK;
    public double eK;
    public double gBarNa;
    public double eNa;
    public double gBarL;
    public double eL;
    public double i;
    public double cm;
    
    private final VFunction2D vf = new VFunction2D(gBarK, eK, gBarNa,eNa,gBarL,eL,i,cm);
    private final NFunction2D nf = new NFunction2D();
    private final MFunction2D mf = new MFunction2D();
    private final HFunction2D hf = new HFunction2D();

    public HHequs() {
        
    }

    
    
    
    @Override
    public int getDimension() {
        return 2;
    }

    @Override
    public void computeDerivatives(double t, double[] y, double[] yDot) throws MaxCountExceededException, DimensionMismatchException {
        yDot[0] = vf.run(t, y[0]);
        yDot[1] = nf.run(t, y[1]);
        yDot[2] = mf.run(t, y[2]);
        yDot[3] = hf.run(t, y[3]);
    }
    
}
