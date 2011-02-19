/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos;

import java.io.File;
import java.util.ArrayList;
import su.acom.icepos.commons.POSPlugin;
import su.acom.icepos.plugins.samples.BarcodeScanner;
import su.acom.icepos.plugins.samples.FiscalPrinter;
import su.acom.icepos.plugins.PluginManager;
import su.acom.icepos.core.Core;
import su.acom.icepos.commons.POSLogger;

/**
 *
 * @author az
 */
public class Test {

    

    String name = "testClassName";

    private Core core = new Core();

    private static POSLogger log = POSLogger.getLogger(Test.class);

    public void onScanBarcode1(String code) {
        System.out.println("Barcode scanned: " + code + " (" + name + ")" );
    }

    public void run() {


        //LF5Appender lf = new LF5Appender();
        //log.getRootLogger().addAppender(lf);


        FiscalPrinter fp;
        BarcodeScanner s = new BarcodeScanner();

        long startTime = System.nanoTime();
        long startHeapSize = Runtime.getRuntime().freeMemory();

        System.out.println("Free memory: " + startHeapSize);
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());

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

        // Attaching out appender to all loggers

        ArrayList<POSLogger> l = POSLogger.getLoggers();
        l.contains(l);


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
