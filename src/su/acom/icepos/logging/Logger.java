/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.logging;

import java.util.logging.Level;
import su.acom.icepos.commons.POSLogger;

/**
 *
 * @author az
 */
public class Logger extends POSLogger {

    @Override
    public void log(Level level, String msg, Throwable thrown) {
        System.out.println(msg);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
