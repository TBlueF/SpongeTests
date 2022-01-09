package de.bluecolored.spongetest.testplugin;

import com.google.inject.Inject;
import net.kyori.adventure.text.Component;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.event.lifecycle.RegisterCommandEvent;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.api.event.lifecycle.StartingEngineEvent;
import org.spongepowered.api.event.network.ServerSideConnectionEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.plugin.PluginContainer;

import java.nio.file.Path;

@org.spongepowered.plugin.builtin.jvm.Plugin("testplugin")
public class Plugin {

    private final Logger logger;
    private final PluginContainer pluginContainer;
    private final Path configPath;

    @Inject
    public Plugin(Logger logger, PluginContainer pluginContainer, @ConfigDir(sharedRoot = false) Path configDir) {
        this.logger = logger;
        this.pluginContainer = pluginContainer;
        this.configPath = configDir.resolve("config.json");
    }

    @Listener
    public void onRegisterCommands(RegisterCommandEvent<Command.Parameterized> evt) {

    }

    @Listener
    public void onInit(StartingEngineEvent<Server> evt) {

    }

    @Listener
    public void onServerStart(StartedEngineEvent<Server> evt) {
        logger.info("Main world UUID:");
        logger.info(evt.engine().worldManager().defaultWorld().uniqueId());
    }

}
