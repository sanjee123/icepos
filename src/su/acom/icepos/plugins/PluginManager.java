/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import su.acom.icepos.common.POSException;

/**
 *
 * @author az
 * This class is used to manage user plugins
 * IcePOS plugin - is a java archive file which is located in /plugins/ folder.
 * For additional information read plugins writing guide.
 */

public class PluginManager {

    private ArrayList <PluginFactory> m_plugins;

    public PluginManager() {
        m_plugins = new ArrayList<PluginFactory>();
    }
    
    public void loadPlugin(File file) {
        PluginFactory pf;
        try {
            pf = new PluginFactory(file);
            m_plugins.add(pf);
        } catch (POSException ex) {
            System.out.println(ex.getLocalizedMessage());
            //Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadAllPlugins() {

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        };

        File dir = null;
        try {
            dir = new File("./plugins/").getCanonicalFile();
        } catch (IOException ex) {
            Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        File[] pluginsList = dir.listFiles(filter);

        if (pluginsList != null) {
            for (int i=0; i < pluginsList.length; i++) {
                // Get filename of file or directory
                File f = pluginsList[i];
                loadPlugin(f);
            }
        }

        System.out.println("---------------------------------------------");
        for (int i = 0; i < m_plugins.size(); i++) {
            System.out.println("Loaded plugins: " + m_plugins.get(i).getPluginClassName());
        }


    }

}
