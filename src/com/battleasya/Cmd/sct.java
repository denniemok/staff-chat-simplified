package com.battleasya.Cmd;

import com.battleasya.StaffChat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sct implements CommandExecutor {

    private final StaffChat plugin;

    public sct(StaffChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        if(!sender.hasPermission("staffchat.use")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
            return true;
        }

        if (args.length == 0) {
            if (plugin.chatToggle.containsKey(sender.getName())) {
                plugin.chatToggle.remove(sender.getName());
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.toggleDisable));
            } else {
                plugin.chatToggle.put(sender.getName(), 1);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.toggleEnable));
            }
            return true;
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.commandList));
        return true;

    }

}
