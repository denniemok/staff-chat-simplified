package com.battleasya.staffchat.command;

import com.battleasya.staffchat.handler.Config;
import com.battleasya.staffchat.handler.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Toggle implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("This is a player-only command!");
            return true;
        }

        if(!sender.hasPermission("staffchat.use")) {
            Util.msgPlayer(sender, Config.noPermission);
            return true;
        }

        if (args.length == 0) {
            if (Util.chatToggleList.containsKey(sender.getName())) {
                Util.chatToggleList.remove(sender.getName());
                Util.msgPlayer(sender, Config.toggleDisable);
            } else {
                Util.chatToggleList.put(sender.getName(), 1);
                Util.msgPlayer(sender, Config.toggleEnable);
            }
            return true;
        }

        Util.msgPlayer(sender, Config.toggleSyntax);
        return true;

    }

}
