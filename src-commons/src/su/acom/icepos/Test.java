/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.commons.POSPlugin;
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

    Core core = new Core();

    public void onScanBarcode1(String code) {
        System.out.println("Barcode scanned: " + code + " (" + name + ")" );
    }

    public void run() {
        FiscalPrinter fp;
        BarcodeScanner s = new BarcodeScanner();

        long startTime = System.nanoTime();
        long startHeapSize = Runtime.getRuntime().freeMemory();

        System.out.println("Free memory: " + startHeapSize);

        s.register(core);

        try {
            core.getEventManager().addEventListener(this, "onScanBarcode", "onScanBarcode1");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            fp = new FiscalPrinter();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        s.scan();

        PluginManager m = new PluginManager(core);
        m.loadPluginsFromFolder(new File("../plugins/"));

        for (int i = 0; i < m.getPluginCount(); i++) {
            POSPlugin p = m.getPlugin(i);
            int count = m.getInstanceCount(p);
        }
        
        /*URL u = new URL("jar", "", url + "!/");
        JarURLConnection uc = (JarURLConnection)u.openConnection();
        Attributes att= uc.getMainAttributes();
        Attributes.Name.*/

    }

}
