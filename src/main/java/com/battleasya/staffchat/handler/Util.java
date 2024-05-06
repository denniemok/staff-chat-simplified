package com.battleasya.staffchat.handler;

import com.battleasya.staffchat.StaffChat;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static HashSet<String> staffList = new HashSet<>();

    public static HashSet<String> chatEnabledList = new HashSet<>();

    public static void msgPlayer(CommandSender sender, String message) {
        sender.sendMessage(translate(message));
    }

    public static void msgStaff(String message) {

        for (String staffName : staffList) {
            Player staff = Bukkit.getPlayer(staffName);
            if (staff != null) {
                msgPlayer(staff, message);
            } else {
                Util.staffList.remove(staffName);
                Util.chatEnabledList.remove(staffName);
            }
        }

    }

    public static String translate(String message) {

        /* HEX code support starts at 1.16 */
        if (StaffChat.getServerVersion() >= 16) {

            Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
//                String color = message.substring(matcher.start(), matcher.end());
                String color = matcher.group(0);
                message = message.replace(color, ChatColor.of(color).toString());
                matcher = pattern.matcher(message);
            }

        }

        return ChatColor.translateAlternateColorCodes('&', message);

    }

}
