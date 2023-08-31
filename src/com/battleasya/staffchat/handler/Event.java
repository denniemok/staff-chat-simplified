package com.battleasya.staffchat.handler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class Event implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        String playerName = event.getPlayer().getName();

        if (Util.chatToggleList.containsKey(playerName)) {
            String message = event.getMessage();
            event.setCancelled(true);
            Util.msgStaff(Config.chatMessage
                    .replaceAll("%name%", playerName)
                    .replaceAll("%message%",  message));
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (player.hasPermission("staffchat.use")) {
            Util.staffList.put(player.getName(), 1);
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        String playerName = event.getPlayer().getName();

        Util.staffList.remove(playerName);
        Util.chatToggleList.remove(playerName);

    }

}
