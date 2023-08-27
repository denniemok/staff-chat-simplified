package com.battleasya.Handler;

import com.battleasya.StaffChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class ChatEvent implements Listener {

    private final StaffChat plugin;

    public ChatEvent(StaffChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String playerName = event.getPlayer().getName();
        if (plugin.chatToggle.containsKey(playerName)) {
            String message =  event.getMessage();
            event.setCancelled(true);
            plugin.msgStaff(plugin.config.chatMessage.replaceAll("%NAME%", playerName).replaceAll("%MESSAGE%",  message));
        }
    }

}
