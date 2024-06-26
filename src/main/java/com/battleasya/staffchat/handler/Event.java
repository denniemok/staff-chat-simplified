package com.battleasya.staffchat.handler;

import com.battleasya.staffchat.StaffChat;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class Event implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        String playerName = event.getPlayer().getName();

        if (Util.chatEnabledList.contains(playerName)) {

            String message = event.getMessage();
            event.setCancelled(true);

            String msg;

            if (StaffChat.getPAPIStatus()) {
                msg = PlaceholderAPI.setPlaceholders(event.getPlayer(), Config.chatMessage);
            } else {
                msg = Config.chatMessage;
            }

            Util.msgStaff(msg
                    .replace("%name%", playerName)
                    .replace("%message%",  message));

        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (player.hasPermission("staffchat.use")) {
            Util.staffList.add(player.getName());
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        String playerName = event.getPlayer().getName();

        Util.staffList.remove(playerName);
        Util.chatEnabledList.remove(playerName);

    }

}
