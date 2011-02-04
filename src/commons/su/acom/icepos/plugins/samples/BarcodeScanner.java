/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins.samples;

import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.commons.POSCore;
import su.acom.icepos.commons.POSPlugin;
import su.acom.icepos.commons.POSException;

/**
 *
 * @author az
 */
public class BarcodeScanner extends POSPlugin {

    private POSCore m_core;


    public void scan() {
        try {
            m_core.getEventManager().invokeEvent((Object) this, "onScanBarcode", "20000036955");
        } catch (POSException ex) {
            Logger.getLogger(BarcodeScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void register(POSCore core) {
        m_core = core;
        try {
            m_core.getEventManager().registerEvent("onScanBarcode", new Class[]{String.class});
        } catch (POSException ex) {
            Logger.getLogger(BarcodeScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public POSPlugin createInstance(POSCore core) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void showSettings(Object instance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        return "BarcodeScannerSample";
    }

}
