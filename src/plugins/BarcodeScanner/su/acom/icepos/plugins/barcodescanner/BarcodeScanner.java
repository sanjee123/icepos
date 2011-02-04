/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins.barcodescanner;

import su.acom.icepos.commons.*;

/**
 *
 * @author az
 */
public class BarcodeScanner extends POSPlugin {

    public BarcodeScanner() {
        System.err.println("Barcodescanner created!");
    }
    
    public String getName() {
        return "BSSan";
    }

    @Override
    public Object createInstance(POSCore posc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void showSettings(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
