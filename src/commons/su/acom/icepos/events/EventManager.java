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
import su.acom.icepos.commons.POSException;

// TODO: rewrite logging

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


    public void addEventListener(Object listener, String eventName, String listenerName) throws POSException {
        if (!m_eventMap.containsKey(eventName)) {
            throw new POSException("Event " + eventName + " not found!");
        }

        Event e = m_eventMap.get(eventName);

        // Looking for a listener function reference
        Method m = null;
        try {
            m = listener.getClass().getMethod(listenerName, e.getArgTypes());
        } catch (NoSuchMethodException ex) {
            System.out.println("Listener " + listenerName + " not found!");
            Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            System.out.println("Cannot access to this method " + listenerName);
            Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (m == null) {
            return;
        }

        e.putListener(new EventListener(listener, listenerName, m));

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
        

        for (int i = 0; i < manager.listeners.size(); i++) {

            EventListener listener = manager.listeners.get(i);
            Method m = null;
            m = listener.getListenerFunc();

            try {
                m.invoke(listener.object, args);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

    }


}
