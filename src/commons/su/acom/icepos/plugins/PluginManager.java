/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.plugins;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import su.acom.icepos.commons.POSCore;
import su.acom.icepos.commons.POSException;
import su.acom.icepos.commons.POSPlugin;
import su.acom.icepos.commons.POSPluginManager;

/**
 *
 * @author az
 * This class is used to manage user plugins
 * IcePOS plugin - is a java archive file which is located in /plugins/ folder.
 * For additional information read plugins writing guide.
 */

public class PluginManager extends POSPluginManager {

    private static Logger log;

    private ArrayList <PluginFactory> m_plugins;
    private POSCore m_core;

    public PluginManager(POSCore core) {
        m_plugins = new ArrayList<PluginFactory>();
        m_core = core;
        log = POSCore.getLogger(PluginManager.class, m_core);
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

    public void loadPluginsFromFolder(File pluginFolder) {

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        };

        File dir = null;
        try {
            dir = pluginFolder.getCanonicalFile();
        } catch (IOException ex) {
            log.error(ex);
        }

        File[] pluginsList = dir.listFiles(filter);

        if (pluginsList != null) {
            for (int i=0; i < pluginsList.length; i++) {
                // Get filename of file or directory
                File f = pluginsList[i];
                loadPlugin(f);
            }
        }

        log.info("---------------------------------------------");
        for (int i = 0; i < m_plugins.size(); i++) {
            log.info("Loaded plugins: " + m_plugins.get(i).getName());
        }


    }

    @Override
    public int getPluginCount() {
        return m_plugins.size();
    }

    @Override
    public POSPlugin getPlugin(int id) {
        if (id >= 0 && id <= m_plugins.size()) {
            return m_plugins.get(id).getPlugin();
        } else {
            return null;
        }
    }

    @Override
    public int getInstanceCount(POSPlugin pluginClass) {

        PluginFactory buf = null;
        for (int i = 0; i< m_plugins.size(); i++) {
            buf = m_plugins.get(i);
            if (buf.getPlugin() == pluginClass) {
                return buf.getInstanceCount();
            }
        }

        return 0;
    }

    @Override
    public Object getInstance(POSPlugin plugin, int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
