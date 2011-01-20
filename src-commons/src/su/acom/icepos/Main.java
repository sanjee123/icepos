/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos;

/**
 *
 * @author az
 */

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.plugins.samples.BarcodeScanner;
import su.acom.icepos.plugins.samples.FiscalPrinter;
import su.acom.icepos.core.Core;

public class Main {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test t = new Test();
        t.run();
    }

}
