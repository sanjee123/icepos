/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins.samples;

import su.acom.icepos.plugins.Plugin;
import su.acom.icepos.types.Receipt;

/**
 *
 * @author az
 */
public class FiscalPrinter extends Plugin {

    public FiscalPrinter() {
        m_name = "BarcodeScanner";
        m_desc = "Barcode Scanner";
        m_ver  = 1.0;
    }


    public void printReceipt(Receipt r) {
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

    @Override
    public void register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
