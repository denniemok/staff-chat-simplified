package com.battleasya.Handler;

import com.battleasya.StaffChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private final StaffChat plugin;

    public JoinEvent(StaffChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player.hasPermission("staffchat.use")) {
            plugin.staff.put(player.getName(), 1);
        }
    }

}
