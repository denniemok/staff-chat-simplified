package com.battleasya;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private final StaffChat plugin;

    public Config(StaffChat plugin) {
        this.plugin = plugin;
    }

    public String noPermission;
    public String commandList;
    public String chatMessage;
    public String toggleEnable;
    public String toggleDisable;
    public String reloadConfig;

    /* load config into memory */
    public void fetchConfig() {

        FileConfiguration config = plugin.getConfig();

        noPermission = config.getString("no-permission");
        commandList = config.getString("command-list");
        chatMessage = config.getString("chat-message");
        toggleEnable = config.getString("toggle-enable");
        toggleDisable = config.getString("toggle-disable");
        reloadConfig = config.getString("reload-config");

    }

}
