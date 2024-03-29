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
package com.rogue.inventoryshop.listener.listeners;

import com.rogue.inventoryshop.InventoryShop;
import org.bukkit.event.Listener;

/**
 * Handles default listening... stuff.
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class InventoryListener implements Listener {
    
    private final InventoryShop plugin;
    
    public InventoryListener(InventoryShop plugin) {
        this.plugin = plugin;
    }

}
