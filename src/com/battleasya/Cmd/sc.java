package com.battleasya.Cmd;

import com.battleasya.StaffChat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sc implements CommandExecutor {

    private final StaffChat plugin;

    public sc(StaffChat plugin) {
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
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.commandList));
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        plugin.msgStaff(plugin.config.chatMessage.replaceAll("%NAME%", sender.getName()).replaceAll("%MESSAGE%", str.toString()));
        return true;

    }

}
