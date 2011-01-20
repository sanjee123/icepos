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
    public Class[] classTypes;
    public ArrayList <EventListener> listeners;

    public Event(Class[] classTypes) {
        this.classTypes = classTypes;
        this.listeners = new ArrayList<EventListener>();
    }

    public void putListener(EventListener listener) {
        this.listeners.add(listener);
    }

}
