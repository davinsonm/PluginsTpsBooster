package me.Davinsonm.PluginTpsBooster;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

class BoosterCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		double multiplicador;
		int tiempo;
		if (args.length < 3 || (!args[0].equalsIgnoreCase("global") && !args[0].equalsIgnoreCase("personal")
				&& !args[0].equalsIgnoreCase("pasivo"))) {
			sender.sendMessage("§cUso correcto: /booster <tipo> <multi> <tiempo> [nombre]");
			return false;
		}
		String tipo = args[0];
		try {
			multiplicador = Double.parseDouble(args[1]);
		} catch (NumberFormatException e) {
			sender.sendMessage("§cMultiplicador inválido.");
			return false;
		}
		tiempo=Booster.parseTime(args[2]);
		String nombre = (args.length >= 4) ? args[3] : "Booster Global";
		if(tipo.equalsIgnoreCase("global")) {
			BoosterGlobal.Activar(tipo, sender, multiplicador, tiempo, nombre);
		}
		return true;
	}
}
