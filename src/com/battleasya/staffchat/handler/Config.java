package com.battleasya.staffchat.handler;

import com.battleasya.staffchat.StaffChat;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private final StaffChat plugin;

    public Config(StaffChat plugin) {
        this.plugin = plugin;
    }

    public static String chatMessage;

    public static String toggleEnable;

    public static String toggleDisable;

    public static String noPermission;

    public static String messageSyntax;

    public static String toggleSyntax;

    public static String reloadSyntax;

    public static String reloadConfig;

    /* load config into memory */
    public void fetchConfig() {

        FileConfiguration config = plugin.getConfig();

        chatMessage = config.getString("chat-message");

        toggleEnable = config.getString("toggle-enable");
        toggleDisable = config.getString("toggle-disable");

        noPermission = config.getString("no-permission");

        messageSyntax = config.getString("message-syntax");
        toggleSyntax = config.getString("toggle-syntax");
        reloadSyntax = config.getString("reload-syntax");

        reloadConfig = config.getString("reload-config");

    }

}
