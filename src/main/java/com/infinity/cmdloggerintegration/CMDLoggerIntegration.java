package com.infinity.cmdloggerintegration;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CMDLoggerIntegration extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("CMDLogger has been enabled successfully :)");

        saveDefaultConfig();

        String webhookURL = getConfig().getString("webhook-url");



        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        Objects.requireNonNull(getCommand("cmdlogger")).setExecutor(new MainCommand(this));

        if (webhookURL == null || !webhookURL.startsWith("https://")) {
            getLogger().warning("WebHook URL is null or it doesn't start with https://! Disabling plugin...");
            Plugin plugin = Bukkit.getPluginManager().getPlugin("CMDLoggerIntegration");
            getServer().getPluginManager().disablePlugin(plugin);

        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("CMDLogger has been disabled successfully :(");
    }
}
