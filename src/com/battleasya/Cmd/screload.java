package com.battleasya.Cmd;

import com.battleasya.StaffChat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class screload implements CommandExecutor {

    private final StaffChat plugin;

    public screload(StaffChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("staffchat.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
            return true;
        }

        if (args.length == 0) {
            plugin.reloadConfig();
            plugin.config.fetchConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.reloadConfig));
            return true;
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.commandList));
        return true;

    }

}
