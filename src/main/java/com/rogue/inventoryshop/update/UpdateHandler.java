/*
 * Copyright (C) 2013 Spencer Alderman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rogue.inventoryshop.update;

import com.rogue.inventoryshop.InventoryShop;
import com.rogue.inventoryshop.config.ConfigValues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/**
 * Handles the update process for {@link InventoryShop}
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class UpdateHandler {
    
    protected final InventoryShop plugin;
    private boolean update = false;
    
    public UpdateHandler(InventoryShop plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getScheduler().runTaskLater(this.plugin,
                new UpdateRunnable(this.plugin),
                10L);
    }
    
    protected void setUpdate(boolean value) {
        this.update = value;
    }
    
    public boolean isUpdateAvailable() {
        return this.update;
    }

}

/**
 * Runs an update check
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
class UpdateRunnable extends UpdateHandler implements Runnable {
    
    private final String VERSION_URL = "https://raw.github.com/1Rogue/InventoryShop/master/VERSION";
    
    /**
     * Constructor for {@link UpdateRunnable}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param plugin The {@link InventoryShop} instance
     */
    public UpdateRunnable(InventoryShop plugin) {
        super(plugin);
    }

    /**
     * Checks for an update
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    public void run() {
        String curVersion = this.plugin.getDescription().getVersion();
        InputStream stream = null;
        InputStreamReader isr = null;
        BufferedReader reader = null;
        try {
            URL call = new URL(VERSION_URL);
            stream = call.openStream();
            isr = new InputStreamReader(stream);
            reader = new BufferedReader(isr);
            String latest = reader.readLine();
            super.setUpdate(!latest.equalsIgnoreCase(curVersion));
        } catch (MalformedURLException ex) {
            plugin.getLogger().log(Level.SEVERE,
                    "Error checking for an update",
                    this.plugin.getDebug() >= 3 ? ex : "");
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE,
                    "Error checking for an update",
                    this.plugin.getDebug() >= 3 ? ex : "");
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                this.plugin.getLogger().log(Level.SEVERE,
                        "Error closing updater streams!",
                        this.plugin.getDebug() >= 3 ? ex : "");
            }
        }
    }

}
