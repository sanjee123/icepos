/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.events;

import java.util.ArrayList;

/**
 *
 * @author az
 */
public class Event {
    private Class[] m_argTypes;
    public ArrayList <EventListener> listeners;

    public Event(Class[] argTypes) {
        this.m_argTypes = argTypes;
        this.listeners = new ArrayList<EventListener>();
    }

    public Class[] getArgTypes() {
        return m_argTypes;
    }

    public void putListener(EventListener listener) {
        this.listeners.add(listener);
    }

}
