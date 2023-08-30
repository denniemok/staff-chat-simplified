package com.battleasya.staffchat.handler;

import com.battleasya.staffchat.StaffChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class Util {

    private final StaffChat plugin;

    public Util(StaffChat plugin) {
        this.plugin = plugin;
    }

    public static void msgSender(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public void msgStaff(String msg) {
        for (Map.Entry<String, Integer> entry : plugin.staffList.entrySet()) {
            Player player = Bukkit.getPlayer(entry.getKey());
            if (player != null) {
                msgSender(player, msg);
            }
        }
    }

}
