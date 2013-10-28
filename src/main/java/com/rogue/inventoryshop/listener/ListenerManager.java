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
package com.rogue.inventoryshop.listener;

import com.rogue.inventoryshop.InventoryShop;
import com.rogue.inventoryshop.listener.listeners.InventoryListener;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.event.Listener;

/**
 *
 * @since
 * @author 1Rogue
 * @version
 */
public class ListenerManager {
    
    private final Map<String, Listener> listeners = new HashMap();
    
    public ListenerManager(InventoryShop plugin) {
        
        this.listeners.put("inventory", new InventoryListener(plugin));
        
        for (Listener l : this.listeners.values()) {
            plugin.getServer().getPluginManager().registerEvents(l, plugin);
        }
    }
    
    /**
     * Gets a listener by its string name. Returns null if the listener is
     * disabled.
     * 
     * Available names: afk, death, event, online, update
     * 
     * @since 1.4.1
     * @version 1.4.1
     * 
     * @param name Name of the listener
     * @return The listener class, null if disabled
     */
    public Listener getListener(String name) {
        return this.listeners.get(name);
    }

}
