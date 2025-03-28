package me.Davinsonm.PluginTpsBooster;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class ReloadCommand implements CommandExecutor {
	private final Plugin plugin;

	public ReloadCommand(Plugin plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
			if (!sender.hasPermission("dartpsbooster.reload")) {
				sender.sendMessage("§cNo tienes permiso para usar este comando.");
				return true;
			}
			this.plugin.reloadConfig();
			sender.sendMessage("§aEl plugin se ha recargado correctamente.");
			return true;
		}
		sender.sendMessage("§cUso correcto: /dartpsbooster reload");
		return false;
	}
}
