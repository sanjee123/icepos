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
import java.util.jar.Attributes;
import su.acom.icepos.commons.POSException;

/**
 *
 * @author az
 */
public class PluginFactory {
    private URL m_url;
    private URLClassLoader m_classLoader;
    private String m_fileName = "";

    public PluginFactory(URL url) throws POSException {
        m_url = url;
        //String buf = m_url.toString();
        //m_fileName = buf.substring(buf.lastIndexOf("/")+1, buf.length());
        System.out.print("Loading plugin from url (" + m_url.getPath() + ")");
        loadPlugin();
    }

    public PluginFactory(File file) throws POSException {
        try {
            m_url = file.toURI().toURL();
            //m_fileName = file.getName();
            System.out.print("Loading plugin from file (" + file.getAbsolutePath() + ")");
            loadPlugin();
        } catch (MalformedURLException ex) {
            throw new POSException("Cannot convert " + file.getAbsolutePath() + " to URL. Plugin cannot be loaded!");
        }

    }

    private void loadPlugin() throws POSException {
        String loaderName = getPluginClassName();
        if (loaderName == null)
            throw new POSException("Plugin class loader not found! Plugin cannot be loaded!");

        m_classLoader = new URLClassLoader(new URL[] {m_url} );
        System.out.println("...done!");
    }

    /**
     * Returns the name of the jar file main class, or null if
     * no "Main-Class" manifest attributes was defined.
     */
    public String getPluginClassName() {
        Attributes attr = null;
        try {
            URL u = new URL("jar", "", m_url + "!/");
            JarURLConnection uc = (JarURLConnection) u.openConnection();
            attr = uc.getMainAttributes();
        } catch (IOException ex) {
            System.out.println("...failed");
            System.out.println("Cannot open plugin .jar " + m_url.toString() + " (" + ex.getLocalizedMessage() + ")");
            return null;
        }
        return attr != null ? attr.getValue("IcePlugin") : null;

    }


}
