/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins.samples;

import su.acom.icepos.commons.POSCore;
import su.acom.icepos.commons.POSPlugin;
import su.acom.icepos.commons.POSReceipt;

/**
 *
 * @author az
 */
public class FiscalPrinter extends POSPlugin {

    public FiscalPrinter() {
        m_name = "BarcodeScanner";
        m_desc = "Barcode Scanner";
        m_ver  = 1.0;
    }


    public void printReceipt(POSReceipt r) {
        for (int i = 0; i < r.lines.length; i++) {
            System.out.println(r.lines[i]);
        }
    }
    
    public void printXReport() {
        System.out.println("X-report printed");
    }

    //public FiscalPrinter() throws Exception {
        //Core.addListener(this, "onReceiptDone",  "printReceipt");
        //Core.addListener(this, "onPrintXReport", "printXReport");
        //throw new UnsupportedOperationException("Not supported yet.");
    //}

    public void register(POSCore core) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        return "FiscalPrinterSample";
    }

}
