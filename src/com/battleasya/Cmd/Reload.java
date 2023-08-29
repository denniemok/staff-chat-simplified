package com.battleasya.Cmd;

import com.battleasya.Hdlr.Util;
import com.battleasya.StaffChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    private final StaffChat plugin;

    public Reload(StaffChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!sender.hasPermission("staffchat.reload")) {
            Util.msgSender(sender, plugin.config.noPermission);
            return true;
        }

        if (args.length == 0) {

            plugin.reloadConfig();
            plugin.config.fetchConfig();

            Util.msgSender(sender, plugin.config.reloadConfig);
            return true;

        }

        Util.msgSender(sender, plugin.config.commandSyntax);
        return true;

    }

}
