/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.test;

import su.acom.icepos.commons.POSCore;
import su.acom.icepos.commons.POSEventManager;
import su.acom.icepos.commons.POSLogger;
import su.acom.icepos.commons.POSPluginManager;
import su.acom.icepos.plugins.PluginManager;

/**
 *
 * @author az
 */
public class PluginTestCore extends POSCore {

    private PluginTestEventManager m_eventManager = new PluginTestEventManager();
    private PluginManager m_pluginManager = new PluginManager(this);

    @Override
    public POSEventManager getEventManager() {
        return m_eventManager;
    }

    @Override
    public POSLogger getLogger() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public POSPluginManager getPluginManager() {
        return m_pluginManager;
    }

}
