/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.test;

import java.util.ArrayList;
import su.acom.icepos.commons.POSEventManager;
import su.acom.icepos.commons.POSException;

/**
 *
 * @author az
 */
public class PluginTestEventManager extends POSEventManager {

    private ArrayList <String> m_events;
    private ArrayList <String> m_eventListeners;

    @Override
    public void registerEvent(String eventName, Class[] types) throws POSException {
        m_events.add(eventName);
    }

    @Override
    public void addEventListener(Object o, String eventName, String listenerName) throws POSException {
        m_eventListeners.add(eventName);
    }

    @Override
    public void invokeEvent(Object o, String string, Object... os) throws POSException {
        return; // TODO: message about invoking event
    }

}
