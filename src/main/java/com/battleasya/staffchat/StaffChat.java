package com.battleasya.staffchat;

import com.battleasya.staffchat.bstats.Metrics;
import com.battleasya.staffchat.command.Msg;
import com.battleasya.staffchat.command.Reload;
import com.battleasya.staffchat.command.Toggle;
import com.battleasya.staffchat.handler.Config;
import com.battleasya.staffchat.handler.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffChat extends JavaPlugin {

    public Config config;

    public static int version;

    public static boolean PAPI;

    @Override
    public void onEnable() {

        /* generate default config if not exists */
        saveDefaultConfig();

        /* initialise config */
        config = new Config(this);

        /* fetch config */
        config.fetchConfig();

        /* register command */
        getCommand("sc").setExecutor(new Msg());
        getCommand("sct").setExecutor(new Toggle());
        getCommand("screload").setExecutor(new Reload(this));

        /* register listener */
        getServer().getPluginManager().registerEvents(new Event(), this);

        /* register bstats */
        new Metrics(this, 19691);
        getLogger().info("Starting Metrics. Opt-out using the global bStats config.");

        /* e.g., 1.14-R0.1-SNAPSHOT */
        try {
            version = Integer.parseInt(getServer().getBukkitVersion().split("-")[0].split("\\.")[1]);
        } catch (Exception e) {
            version = 8;
        }

        /* hook into PAPI */
        PAPI = getServer().getPluginManager().getPlugin("PlaceholderAPI") != null;

    }

    public static int getServerVersion() {
        return version;
    }

    public static boolean getPAPIStatus() {
        return PAPI;
    }

}
