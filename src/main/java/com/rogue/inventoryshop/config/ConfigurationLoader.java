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
package com.rogue.inventoryshop.config;

import com.rogue.inventoryshop.InventoryShop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Loads and manages the main configuration file for {@link InventoryShop}
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class ConfigurationLoader {
    
    private final InventoryShop plugin;
    private final File file;
    private YamlConfiguration yaml = null;
    
    
    /**
     * Constructor for {@link ConfigurationLoader}
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param plugin The {@link InventoryShop} instance
     */
    public ConfigurationLoader(InventoryShop plugin) {
        this.plugin = plugin;
        this.file = new File(this.plugin.getDataFolder(), "config.yml");
        this.verifyConfig();
    }
    
    /**
     * Verifies the current configuration, or loads the default configuration
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    private void verifyConfig() {
        if (!this.file.exists()) {
            this.plugin.saveDefaultConfig();
            this.yaml = YamlConfiguration.loadConfiguration(this.file);
        } else {
            this.yaml = YamlConfiguration.loadConfiguration(this.file);
            for (ConfigValues conf : ConfigValues.values()) {
                if (!this.yaml.isSet(conf.getPath())) {
                    this.yaml.set(conf.getPath(), conf.getDefault());
                }
            }
            this.saveConfig();
        }
    }
    
    /**
     * Saves the current configuration from memory
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    public void saveConfig() {
        try {
            this.yaml.save(this.file);
        } catch (IOException ex) {
            this.plugin.getLogger().log(Level.SEVERE, "Error saving configuration file!", ex);
        }
    }
    
    /**
     * Gets the configuration file for {@link InventoryShops}
     *
     * @since 1.3.0
     * @version 1.3.0
     *
     * @return YamlConfiguration file, null if verifyConfig() has not been run
     */
    public YamlConfiguration getConfig() {
        return this.yaml;
    }
    
    /**
     * Gets a string value from the config
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param path Path to string value
     * @return String value
     */
    public synchronized String getString(ConfigValues path) {
        return this.yaml.getString(path.toString());
    }
    
    /**
     * Gets an int value from the config
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param path Path to int value
     * @return int value
     */
    public synchronized int getInt(ConfigValues path) {
        return this.yaml.getInt(path.toString());
    }
    
    /**
     * Gets a boolean value from the config
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param path Path to boolean value
     * @return boolean value
     */
    public synchronized boolean getBoolean(ConfigValues path) {
        return this.yaml.getBoolean(path.toString());
    }

}
