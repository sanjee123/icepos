/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.commons;

import org.apache.log4j.Logger;

/**
 *
 * @author az
 */
public abstract class POSCore {
    
    public abstract POSEventManager getEventManager();
    public abstract POSPluginManager getPluginManager();


    public abstract void addAppenders(Logger log);

    public static Logger getLogger(Class clazz, POSCore core) {
        Logger log = Logger.getLogger(clazz);
        core.addAppenders(log);
        return log;
    }

}
