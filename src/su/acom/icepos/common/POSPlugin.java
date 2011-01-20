/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.common;

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
     * core - is a reference to core
     */
    public abstract void register(POSCore core);

}
