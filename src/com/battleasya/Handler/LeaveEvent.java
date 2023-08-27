package com.battleasya.Handler;

import com.battleasya.StaffChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    private final StaffChat plugin;

    public LeaveEvent(StaffChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        plugin.staff.remove(player.getName());
        plugin.chatToggle.remove(player.getName());
    }

}
