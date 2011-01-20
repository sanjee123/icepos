/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.core;

import su.acom.icepos.common.POSCore;
import su.acom.icepos.events.EventManager;

/**
 *
 * @author az
 */
public class Core extends POSCore {

    // Event system

    private static EventManager m_eventManager = new EventManager();

    @Override
    public EventManager getEventManager() {
        return m_eventManager;
    }

}
