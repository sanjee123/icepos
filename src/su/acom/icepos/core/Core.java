/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.core;

import su.acom.icepos.types.POSException;
import su.acom.icepos.events.EventListener;
import su.acom.icepos.events.Event;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.events.EventManager;

/**
 *
 * @author az
 */
public abstract class Core {

    // Event system

    private static EventManager m_eventManager = new EventManager();

    /**
     * This function is used to register event to which can connect listeners
     * @param eventName - name of the event
     * @param args - array of Class type variables
     * @throws Exception - if cannot register event inside core
     */
    public static void registerEvent(String eventName, Class[] args) throws POSException {
        m_eventManager.registerEvent(eventName, args);
    }

    public static void addEventListener(Object listener, String eventName, String listenerName) throws POSException {
        m_eventManager.addEventListener(listener, eventName, listenerName);
    }

    /**
     * This function calls every connected eventListener with delivered args
     * @param eventName
     * @param args
     * @throws Exception
     */
    public static void invokeEvent(Object sender, String eventName, Object... args) throws POSException {
        m_eventManager.invokeEvent(sender, eventName, args);
    }

}
