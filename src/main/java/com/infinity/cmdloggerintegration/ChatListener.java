package com.infinity.cmdloggerintegration;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ChatListener implements Listener {

    // Registering plugin

    private final CMDLoggerIntegration plugin;

    public ChatListener(CMDLoggerIntegration plugin) {
        this.plugin = plugin;
    }

    // Main event

    @EventHandler
    public void onCommandSend(PlayerCommandPreprocessEvent event) throws IOException {
        if (event.getPlayer().hasPermission("cmdlogger.staff")) {
            // Getting configurations
            String webhookURL = this.plugin.getConfig().getString("webhook-url");
            String command = event.getMessage();
            String isPlayerOp = String.valueOf(event.getPlayer().isOp());
            String playerWorld = event.getPlayer().getWorld().getName();
            String embedTitle = this.plugin.getConfig().getString("embed.title");
            Color embedHexColor = Color.decode(Objects.requireNonNull(this.plugin.getConfig().getString("embed.color")));
            List<?> ignoredCommands = this.plugin.getConfig().getStringList("ignored-commands");
            DiscordWebhook webhook = new DiscordWebhook(webhookURL);

            // Checking configuration
            if (isPlayerOp == "true") {
                isPlayerOp = "Yes";
            } else {
                isPlayerOp = "No";
            }
            if (embedTitle == null) {
                embedTitle = "Staffs Command Logger";
                webhook.setUsername("Staff Command Logger");
                webhook.setTts(false);
                webhook.addEmbed(new DiscordWebhook.EmbedObject()

                        .setTitle(embedTitle)
                        .addField("Executed Command", command, true)
                        .addField("Player Username", event.getPlayer().getDisplayName(), false)
                        .addField("World", playerWorld, false)
                        .addField("Is player a operator?", isPlayerOp, false)
                        .setFooter("Powered by CMDLoggerIntegration", "http://185.3.200.22/assets/cmdlogger-avatar.png")
                        .setThumbnail("http://185.3.200.22/assets/cmdlogger-avatar.png")
                        .setColor(embedHexColor)
                );

                webhook.setAvatarUrl("http://185.3.200.22/assets/cmdlogger-avatar.png");
                webhook.execute();
            } else if (embedHexColor == null) {
                embedHexColor = Color.decode("#020101");
                webhook.setUsername("Staff Command Logger");
                webhook.setTts(false);
                webhook.addEmbed(new DiscordWebhook.EmbedObject()

                        .setTitle(embedTitle)
                        .addField("Executed Command", command, true)
                        .addField("Player Username", event.getPlayer().getDisplayName(), false)
                        .addField("World", playerWorld, false)
                        .addField("Is player a operator?", isPlayerOp, false)
                        .setFooter("Powered by CMDLoggerIntegration", "http://185.3.200.22/assets/cmdlogger-avatar.png")
                        .setThumbnail("http://185.3.200.22/assets/cmdlogger-avatar.png")
                        .setColor(embedHexColor)
                );

                webhook.setAvatarUrl("http://185.3.200.22/assets/cmdlogger-avatar.png");
                webhook.execute();
            } else {
                webhook.setUsername("Staff Command Logger");
                webhook.setTts(false);
                webhook.addEmbed(new DiscordWebhook.EmbedObject()

                        .setTitle(embedTitle)
                        .addField("Executed Command", command, true)
                        .addField("Player Username", event.getPlayer().getDisplayName(), false)
                        .addField("World", playerWorld, false)
                        .addField("Is player a operator?", isPlayerOp, false)
                        .setFooter("Powered by CMDLoggerIntegration", "http://185.3.200.22/assets/cmdlogger-avatar.png")
                        .setThumbnail("http://185.3.200.22/assets/cmdlogger-avatar.png")
                        .setColor(embedHexColor)
                );

                webhook.setAvatarUrl("http://185.3.200.22/assets/cmdlogger-avatar.png");
                webhook.execute();

            }
        }

    }

}
