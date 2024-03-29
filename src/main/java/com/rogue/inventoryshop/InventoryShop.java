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
package com.rogue.inventoryshop;

import com.rogue.inventoryshop.config.ConfigValues;
import com.rogue.inventoryshop.config.ConfigurationLoader;
import com.rogue.inventoryshop.data.DataManager;
import com.rogue.inventoryshop.listener.ListenerManager;
import com.rogue.inventoryshop.update.UpdateHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for {@link InventoryShop}
 *
 * @since 1.0.0
 * @author 1Rogue
 * @author drtshock
 * @version 1.0.0
 */
public final class InventoryShop extends JavaPlugin {
    
    private ConfigurationLoader config;
    private DataManager data;
    private ListenerManager listener;
    private UpdateHandler update;
    private int debug = 0;

    /**
     * Loads configuration and other data. Unused
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    @Override
    public void onLoad() {
        this.config = new ConfigurationLoader(this);
        
        //Sets the debug value for caching simplicity
        this.debug = this.config.getInt(ConfigValues.DEBUG_LEVEL);
        if (this.debug > 3) {
            this.debug = 3;
        }
        if (this.debug < 0) {
            this.debug = 0;
        }
    }

    /**
     * Registers code handlers and managers. Unused
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    @Override
    public void onEnable() {
        this.data = new DataManager(this, true);
        this.listener = new ListenerManager(this);
    }

    /**
     * Cleans up any buffers / tasks. Unused.
     * 
     * @since 1.0.0
     */
    @Override
    public void onDisable() {
    }
    
    /**
     * Sends a formatted message to a provided player
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param player The player's name in string form
     * @param message The message to send
     */
    public void communicate(String player, String message) {
        Player p = this.getServer().getPlayer(player);
        if (p != null && p.isOnline()) {
            this.communicate(p, message);
        }
    }
    
    /**
     * Sends a formatted message to a provided player
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param player The player to send to
     * @param message The message to send
     */
    public void communicate(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&biShop&e] " + message));
    }
    
    /**
     * Returns the current debug level for {@link InventoryShop}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The debug level
     */
    public int getDebug() {
        return this.debug;
    }
    
    /**
     * Gets the configuration loader for {@link InventoryShop}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link ConfigurationLoader} for {@link InventoryShop}
     */
    public ConfigurationLoader getConfigurationLoader() {
        return this.config;
    }
    
    /**
     * Gets the update handler for {@link InventoryShop}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return The {@link UpdateHandler} for {@link InventoryShop}
     */
    public UpdateHandler getUpdateHandler() {
        return this.update;
    }
}
