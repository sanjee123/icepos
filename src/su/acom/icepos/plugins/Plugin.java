/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author az
 */
public abstract class Plugin {
    /**
     * this method is called when plugin is loaded
     * if failed, core shows exception
     */
    //public void OnCreate() throws Exception;

    protected String m_name = "";
    protected String m_desc = "";
    protected double m_ver  = 1.0;


    public double getVersion() {
        return m_ver;
    }

    public String getName() {
        return m_name;
    }

    public String getDescription() {
        return m_desc;
    }

    /**
     *
     * This method is used to register events and prepare plugin to work
     * 
     */
    public abstract void register();

}
