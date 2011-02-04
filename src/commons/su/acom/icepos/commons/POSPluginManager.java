/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package su.acom.icepos.commons;

import java.io.File;

/**
 *
 * @author az
 */
public abstract class POSPluginManager {
    public abstract void loadPlugin(File file);
    public abstract void loadPluginsFromFolder(File pluginFolder);

    public abstract int getPluginCount();
    public abstract POSPlugin getPlugin(int index);

    // Plugin instances managment
    public abstract int getInstanceCount(POSPlugin pluginClass);
    public abstract Object getInstance(POSPlugin plugin, int index);



}
