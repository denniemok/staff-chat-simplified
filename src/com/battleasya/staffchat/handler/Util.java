package com.battleasya.staffchat.handler;

import com.battleasya.staffchat.StaffChat;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static HashMap<String, Integer> staffList = new HashMap<>();

    public static HashMap<String, Integer> chatToggleList = new HashMap<>();

    public static void msgPlayer(CommandSender sender, String message) {
        sender.sendMessage(translate(message));
    }

    public static String translate(String message) {

        /* HEX code support starts at 1.16 */
        if (StaffChat.getServerVersion() >= 16) {

            Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                String color = message.substring(matcher.start(), matcher.end());
                message = message.replace(color, ChatColor.of(color).toString());
                matcher = pattern.matcher(message);
            }

        }

        return ChatColor.translateAlternateColorCodes('&', message);

    }

    public static void msgStaff(String msg) {
        for (Map.Entry<String, Integer> entry : staffList.entrySet()) {
            String staffName = entry.getKey();
            Player staff = Bukkit.getPlayer(staffName);
            if (staff != null) {
                msgPlayer(staff, msg);
            } else {
                Util.staffList.remove(staffName);
                Util.chatToggleList.remove(staffName);
            }
        }
    }

}
