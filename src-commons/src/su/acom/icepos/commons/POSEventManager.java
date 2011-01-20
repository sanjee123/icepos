/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.commons;

/**
 *
 * @author az
 */
public abstract class POSEventManager {

    /**
     * This function is used to register event to which can connect listeners
     * @param eventName - name of the event
     * @param args - array of Class type variables
     * @throws Exception - if cannot register event inside core
     */
    public abstract void registerEvent(String eventName, Class[] args) throws POSException;

    public abstract void addEventListener(Object listener, String eventName, String listenerName) throws POSException;

    /**
     * This function calls every connected eventListener with delivered args
     * @param eventName
     * @param args
     * @throws Exception
     */
    public abstract void invokeEvent(Object sender, String eventName, Object... args) throws POSException;


}
