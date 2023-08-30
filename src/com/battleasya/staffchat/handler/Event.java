package com.battleasya.staffchat.handler;

import com.battleasya.staffchat.StaffChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class Event implements Listener {

    private final StaffChat plugin;

    public Event(StaffChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        String playerName = event.getPlayer().getName();

        if (plugin.chatToggleList.containsKey(playerName)) {
            String message = event.getMessage();
            event.setCancelled(true);
            plugin.util.msgStaff(plugin.config.chatMessage
                    .replaceAll("%name%", playerName)
                    .replaceAll("%message%",  message));
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (player.hasPermission("staffchat.use")) {
            plugin.staffList.put(player.getName(), 1);
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        String playerName = event.getPlayer().getName();

        plugin.staffList.remove(playerName);
        plugin.chatToggleList.remove(playerName);

    }

}
