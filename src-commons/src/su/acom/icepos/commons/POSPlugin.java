/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.commons;

import java.util.ArrayList;

/**
 *
 * @author az
 */
public abstract class POSPlugin {
    /**
     * this method is called when plugin is loaded
     * if failed, core shows exception
     */
    //public void OnCreate() throws Exception;

    protected String m_name = "";
    protected String m_desc = "";
    protected double m_ver  = 1.0;
    
    private ArrayList m_array;


    public double getVersion() {
        return m_ver;
    }

    public abstract String getName();/* {
        return m_name;
    }*/

    public String getDescription() {
        return m_desc;
    }

    public POSPlugin() {
        m_array = new ArrayList(100000);
    }

    /**
     *
     * This method is used to register events and prepare plugin to work
     * core - is a reference to core
     */
    public abstract Object createInstance(POSCore core);
    
    public abstract void showSettings(Object instance);

}
