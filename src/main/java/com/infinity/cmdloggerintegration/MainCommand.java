package com.infinity.cmdloggerintegration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class MainCommand implements CommandExecutor {

    private final CMDLoggerIntegration plugin;

    public MainCommand(CMDLoggerIntegration plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCMDLOGGER &8| &fYou're welcome to check our github page on https://github.com/BedlessFighterX and https://github.com/KiloSheet"));
        return true;
    }
}
