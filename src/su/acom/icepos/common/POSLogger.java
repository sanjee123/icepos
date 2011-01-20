/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.common;

import java.util.logging.Level;

/**
 *
 * @author az
 */
public abstract class POSLogger {
    public abstract void log(Level level, String msg, Throwable thrown);
}
