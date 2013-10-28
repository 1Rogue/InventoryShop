/*
 * Copyright (C) 2013 Spencer
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

/**
 * Holds string instances of config values
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public enum ConfigValues {

    DEBUG_LEVEL("general.debug-level") {
        @Override public Object getDefault() { return 0; }
    },
    UPDATE_CHECK("general.update-check") {
        @Override public Object getDefault() { return true; }
    },
    CURRENT_MANAGER("data.manager") {
        @Override public Object getDefault() { return "yaml"; }
    },
    MYSQL_HOST("managers.mysql.host") {
        @Override public Object getDefault() { return "localhost"; }
    },
    MYSQL_PORT("managers.mysql.port") {
        @Override public Object getDefault() { return "3306"; }
    },
    MYSQL_DATABASE("managers.mysql.database") {
        @Override public Object getDefault() { return "minecraft"; }
    },
    MYSQL_USERNAME("managers.mysql.username") {
        @Override public Object getDefault() { return "root"; }
    },
    MYSQL_PASSWORD("managers.mysql.password") {
        @Override public Object getDefault() { return "password"; }
    };
    private final String key;

    /**
     * Returns the default value of the key
     *
     * @since 1.0.0
     * @version 1.0.0
     *
     * @return The key's default value
     */
    public abstract Object getDefault();

    /**
     * private constructor for {@link ConfigValues}
     *
     * @since 1.0.0
     * @version 1.0.0
     *
     * @param key The string path to the value
     */
    private ConfigValues(String key) {
        this.key = key;
    }

    /**
     * Returns the string path to the value
     *
     * @since 1.0.0
     * @version 1.0.0
     *
     * @return The string path to the value
     */
    @Override
    public String toString() {
        return this.key;
    }
}
