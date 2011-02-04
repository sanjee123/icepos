/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos;

import java.io.File;
import su.acom.icepos.commons.POSPlugin;
import su.acom.icepos.plugins.samples.BarcodeScanner;
import su.acom.icepos.plugins.samples.FiscalPrinter;
import su.acom.icepos.plugins.PluginManager;
import su.acom.icepos.core.Core;
import org.apache.log4j.Logger;
import su.acom.icepos.commons.POSCore;

/**
 *
 * @author az
 */
public class Test {

    

    String name = "testClassName";

    private Core core = new Core();

    private static Logger log;

    public void onScanBarcode1(String code) {
        System.out.println("Barcode scanned: " + code + " (" + name + ")" );
    }

    public void run() {

        log = POSCore.getLogger(Test.class, core);

        FiscalPrinter fp;
        BarcodeScanner s = new BarcodeScanner();

        long startTime = System.nanoTime();
        long startHeapSize = Runtime.getRuntime().freeMemory();

        System.out.println("Free memory: " + startHeapSize);

        s.register(core);

        try {
            core.getEventManager().addEventListener(this, "onScanBarcode", "onScanBarcode1");
        } catch (Exception ex) {
            log.warn("Can't add listener!");
        }

        try {
            fp = new FiscalPrinter();
        } catch (Exception ex) {
            log.warn("Can't create fiscal printer class!");
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
