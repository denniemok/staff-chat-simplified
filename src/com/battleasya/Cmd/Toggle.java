package com.battleasya.Cmd;

import com.battleasya.Hdlr.Util;
import com.battleasya.StaffChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Toggle implements CommandExecutor {

    private final StaffChat plugin;

    public Toggle(StaffChat plugin) {
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
            if (plugin.chatToggleList.containsKey(sender.getName())) {
                plugin.chatToggleList.remove(sender.getName());
                Util.msgSender(sender, plugin.config.toggleDisable);
            } else {
                plugin.chatToggleList.put(sender.getName(), 1);
                Util.msgSender(sender, plugin.config.toggleEnable);
            }
            return true;
        }

        Util.msgSender(sender, plugin.config.commandSyntax);
        return true;

    }

}
