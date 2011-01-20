/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.core;

import su.acom.icepos.commons.POSCore;
import su.acom.icepos.commons.POSLogger;
import su.acom.icepos.logging.Logger;
import su.acom.icepos.events.EventManager;

/**
 *
 * @author az
 */
public class Core extends POSCore {

    // Event system

    private EventManager m_eventManager = new EventManager();
    private Logger m_logger = new Logger();

    @Override
    public EventManager getEventManager() {
        return m_eventManager;
    }

    @Override
    public POSLogger getLogger() {
        return m_logger;
    }

}
