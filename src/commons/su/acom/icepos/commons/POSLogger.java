/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.commons;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author az
 */

// TODO: rewrite to use IceLogger
// TODO: maybe rewrite this class to abstract and move all code inside IcePOS?

public class POSLogger {

    private Logger m_log;

    private final static ConsoleAppender m_consoleAppender = new ConsoleAppender();

    private static HashMap<String, POSLogger> loggersMap = new HashMap<String, POSLogger>();

    static {
        m_consoleAppender.setWriter(new OutputStreamWriter(System.out));
        m_consoleAppender.setLayout(new PatternLayout("%-5p [%t]: %m%n"));
    }

    public void addAppender(POSAppender appender) {
        m_log.addAppender((Appender)appender);
    }

    public void addAppender(Appender nappender) {
        m_log.addAppender(nappender);
    }

    public POSLogger(String name) {
        m_log = Logger.getLogger(name);
        m_log.addAppender(m_consoleAppender);
    }

    public POSLogger(Class clazz) {
        m_log = Logger.getLogger(clazz);
        m_log.addAppender(m_consoleAppender);
    }

    public static POSLogger getLogger(Class clazz) {

        String name = clazz.getName();

        if (loggersMap.containsKey(name)) {
            return loggersMap.get(name);
        }

        POSLogger l = new POSLogger(name);

        loggersMap.put(name, l);

        return l;
    }

    public static ArrayList<POSLogger> getLoggers() {
        return new ArrayList<POSLogger>(loggersMap.values());
    }


    public void error(Object msg) {
        m_log.error(msg);
    }

    public void info(Object message) {
        m_log.info(message);
    }

    public void warn(Object message) {
        m_log.warn(message);
    }

   

}
