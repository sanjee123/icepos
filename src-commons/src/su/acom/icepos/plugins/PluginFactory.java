/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.commons.POSCore;
import su.acom.icepos.commons.POSException;
import su.acom.icepos.commons.POSPlugin;

/**
 *
 * @author az
 */
public class PluginFactory {
    private URL m_url;
    private URLClassLoader m_classLoader;
    private JarURLConnection m_connection;

    private String m_fileName = "";
    private ArrayList<Object> m_instances;
    private POSPlugin m_plugin;


    public PluginFactory(File file) throws POSException {

        try {
            m_fileName = file.getAbsolutePath();
            m_url = new URL("jar", "", file.toURI() + "!/");
            //m_url = file.toURI().toURL();
            //m_fileName = file.getName();
            System.out.println("Loading plugin from file (" + m_fileName + ")");
        } catch (MalformedURLException ex) {
            throw new POSException("Cannot convert " + m_fileName + " to URL. Plugin cannot be loaded!");
        }

        System.out.print("Initializing connection...");
        try {
            m_connection = (JarURLConnection) m_url.openConnection();
            Attributes attr = m_connection.getAttributes();
        } catch (IOException ex) {
            System.out.println("failed (" + ex.getMessage() + ")");
            throw new POSException(ex.getMessage());
        }
        System.out.println("done!");


       loadPlugin();


    }

    private void loadPlugin() throws POSException {

        m_instances = new ArrayList<Object>();

        m_classLoader = new URLClassLoader(new URL[] {m_url} );


        String loaderName = getPluginClassName();
        if (loaderName == null)
            throw new POSException("Plugin class loader not found! Plugin cannot be loaded!");


        System.out.println("...done!");

        try {
            Class c = m_classLoader.loadClass(loaderName);
            try {
                m_plugin = (POSPlugin)c.newInstance();
            } catch (InstantiationException ex) {
                System.out.println(ex.getCause());
                Logger.getLogger(PluginFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getCause());
                Logger.getLogger(PluginFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getCause());
            Logger.getLogger(PluginFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns the name of the jar file main class, or null if
     * no "Main-Class" manifest attributes was defined.
     */
    private String getPluginClassName() {
        Attributes attr = null;
        try {
            //URL u = new URL("jar", "", m_url + "!/");
            attr = m_connection.getMainAttributes();
        } catch (IOException ex) {
            System.out.println("Cannot open plugin .jar " + m_url.toString() + " (" + ex.getLocalizedMessage() + ")");
            return null;
        }
        return attr != null ? attr.getValue("IcePlugin") : null;


    }

    public int getInstanceCount() {
        return m_instances.size();
    }

    public POSPlugin getInstance(int id) {
        if (id >= 0 && id <= m_instances.size()) {
            return (POSPlugin)m_instances.get(id);
        } else {
            return null;
        }
    }

    public String getInstanceName(Object instance) {
        return ((POSPlugin)instance).getName();
    }

    public String getInstanceName(int id) {
        return "";
    }

    public String getName() {
        return m_plugin.getName();
    }

    public POSPlugin getPlugin() {
        return m_plugin;
    }


}
