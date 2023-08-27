package com.battleasya;

import com.battleasya.Cmd.sc;
import com.battleasya.Cmd.screload;
import com.battleasya.Cmd.sct;
import com.battleasya.Handler.ChatEvent;
import com.battleasya.Handler.JoinEvent;
import com.battleasya.Handler.LeaveEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class StaffChat extends JavaPlugin {

    public HashMap<String, Integer> staff = new HashMap<>();

    public HashMap<String, Integer> chatToggle = new HashMap<>();

    public Config config;

    @Override
    public void onEnable() {

        /* generate default config if not exists */
        saveDefaultConfig();

        /* initialise config */
        config = new Config(this);

        /* fetch config */
        config.fetchConfig();

        /* register command */
        getCommand("sc").setExecutor(new sc(this));
        getCommand("sct").setExecutor(new sct(this));
        getCommand("screload").setExecutor(new screload(this));

        /* register listener */
        getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(this), this);

    }

    public void msgStaff(String msg) {
        for (Map.Entry<String, Integer> entry : staff.entrySet()) {
            Player player = Bukkit.getPlayer(entry.getKey());
            if (player != null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
        }
    }

}
