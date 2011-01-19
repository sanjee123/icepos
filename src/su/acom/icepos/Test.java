/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.plugins.samples.BarcodeScanner;
import su.acom.icepos.plugins.samples.FiscalPrinter;
import su.acom.icepos.plugins.PluginManager;
import su.acom.icepos.core.Core;

/**
 *
 * @author az
 */
public class Test {

    String name = "testClassName";

    public void onScanBarcode1(String code) {
        System.out.println("Barcode scanned: " + code + " (" + name + ")" );
    }

    public void run() {
        FiscalPrinter fp;
        BarcodeScanner s = new BarcodeScanner();

        try {
            Core.addEventListener(this, "onScanBarcode", "onScanBarcode1");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            fp = new FiscalPrinter();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


        s.scan();

        PluginManager m = new PluginManager();
        m.loadAllPlugins();
        
        /*URL u = new URL("jar", "", url + "!/");
        JarURLConnection uc = (JarURLConnection)u.openConnection();
        Attributes att= uc.getMainAttributes();
        Attributes.Name.*/

    }

}
