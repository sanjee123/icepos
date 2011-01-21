/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.commons.POSEventManager;
import su.acom.icepos.core.Core;
import su.acom.icepos.commons.POSException;

/**
 *
 * @author az
 */
public class EventManager extends POSEventManager {

    private static HashMap<String, Event> m_eventMap = new HashMap<String, Event>();

    /**
     * This function is used to register event to which can connect listeners
     * @param eventName - name of the event
     * @param args - array of Class type variables
     * @throws Exception - if cannot register event inside core
     */
    public void registerEvent(String eventName, Class[] args) throws POSException {
        if (!m_eventMap.containsKey(eventName)) {
            m_eventMap.put(eventName, new Event(args));
            //throw new UnsupportedOperationException("This event is already registered!");
        }
    }


    // TODO: move code which gets function pointer here from invokeEvent
    public void addEventListener(Object listener, String eventName, String listenerName) throws POSException {
        if (!m_eventMap.containsKey(eventName)) {
            throw new POSException("Event " + eventName + " not found!");
        }

        m_eventMap.get(eventName).putListener(new EventListener(listener, listenerName));

    }

    /**
     * This function calls every connected eventListener with delivered args
     * @param eventName
     * @param args
     * @throws Exception
     */
    public void invokeEvent(Object sender, String eventName, Object... args) throws POSException {
        if (!m_eventMap.containsKey(eventName)) {
            throw new POSException("Event " + eventName + " not found!");
        }

        // Now going thru all listeners and call them
        Event manager = m_eventMap.get(eventName);
        Method m;

        for (int i = 0; i < manager.listeners.size(); i++) {
            try {
                EventListener listener = manager.listeners.get(i);
                m = listener.object.getClass().getMethod(listener.handlerName, manager.classTypes);

                try {
                    m.invoke(listener.object, args);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }


}
