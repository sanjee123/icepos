/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.core;

import su.acom.icepos.commons.POSCore;
import su.acom.icepos.commons.POSLogger;
import su.acom.icepos.commons.POSPluginManager;
import su.acom.icepos.logging.Logger;
import su.acom.icepos.events.EventManager;
import su.acom.icepos.plugins.PluginManager;

/**
 *
 * @author az
 */
public class Core extends POSCore {

    // Event system

    private EventManager m_eventManager = new EventManager();
    private Logger m_logger = new Logger();
    private PluginManager m_pluginManager = new PluginManager(this);

    @Override
    public EventManager getEventManager() {
        return m_eventManager;
    }

    @Override
    public POSLogger getLogger() {
        return m_logger;
    }

    @Override
    public POSPluginManager getPluginManager() {
        return m_pluginManager;
    }

}
