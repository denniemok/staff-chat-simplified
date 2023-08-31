package com.battleasya.staffchat.command;

import com.battleasya.staffchat.handler.Config;
import com.battleasya.staffchat.handler.Util;
import com.battleasya.staffchat.StaffChat;
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
            Util.msgPlayer(sender, Config.noPermission);
            return true;
        }

        if (args.length == 0) {

            plugin.reloadConfig();
            plugin.config.fetchConfig();

            Util.msgPlayer(sender, Config.reloadConfig);
            return true;

        }

        Util.msgPlayer(sender, Config.reloadSyntax);
        return true;

    }

}
