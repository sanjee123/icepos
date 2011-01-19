/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins.samples;

import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.core.Core;
import su.acom.icepos.types.POSException;

/**
 *
 * @author az
 */
public class BarcodeScanner {

    public BarcodeScanner() {
        try {
            Core.registerEvent("onScanBarcode", new Class[]{String.class});
        } catch (POSException ex) {
            Logger.getLogger(BarcodeScanner.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void scan() {
        try {
            Core.invokeEvent((Object) this, "onScanBarcode", "20000036955");
        } catch (POSException ex) {
            Logger.getLogger(BarcodeScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
