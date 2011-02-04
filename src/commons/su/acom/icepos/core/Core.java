/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.core;

import java.io.OutputStreamWriter;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.lf5.LF5Appender;
import su.acom.icepos.commons.POSCore;
import su.acom.icepos.commons.POSPluginManager;
import su.acom.icepos.events.EventManager;
import su.acom.icepos.plugins.PluginManager;

/**
 *
 * @author az
 */
public class Core extends POSCore {

    // Event system

    private EventManager m_eventManager = new EventManager();
    private PluginManager m_pluginManager = new PluginManager(this);

    private static ConsoleAppender m_consoleAppender = new ConsoleAppender();


    @Override
    public EventManager getEventManager() {
        return m_eventManager;
    }


    @Override
    public POSPluginManager getPluginManager() {
        return m_pluginManager;
    }

    @Override
    public void addAppenders(Logger log) {
        m_consoleAppender.setWriter(new OutputStreamWriter(System.out));
        m_consoleAppender.setLayout(new PatternLayout("%-5p [%t]: %m%n"));
        log.addAppender(m_consoleAppender);

        LF5Appender lf = new LF5Appender();
        log.addAppender(lf);
    }

    /*public Logger getLogger(Class clazz) {
        return POSCore.getLogger(clazz, this);
    }*/

}
