package com.battleasya.command;

import com.battleasya.handler.Util;
import com.battleasya.StaffChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Msg implements CommandExecutor {

    private final StaffChat plugin;

    public Msg(StaffChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            return true;
        }

        if(!sender.hasPermission("staffchat.use")) {
            Util.msgSender(sender, plugin.config.noPermission);
            return true;
        }

        if (args.length == 0) {
            Util.msgSender(sender, plugin.config.commandSyntax);
            return true;
        }

        StringBuilder str = new StringBuilder();

        for (String arg : args) {
            str.append(arg).append(" ");
        }

        plugin.util.msgStaff(plugin.config.chatMessage
                .replaceAll("%name%", sender.getName())
                .replaceAll("%message%", str.toString()));
        return true;

    }

}
