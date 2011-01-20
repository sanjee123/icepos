/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.commons;

/**
 *
 * @author az
 */
public abstract class POSCore {
    
    public abstract POSEventManager getEventManager();
    public abstract POSLogger getLogger();

}
