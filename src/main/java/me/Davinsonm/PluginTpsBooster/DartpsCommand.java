package me.Davinsonm.PluginTpsBooster;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

class DartpsCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int baseAmount;
		if (args.length < 2) {
			sender.sendMessage("§cUso correcto: /dartps <jugador> <cantidad>");
			return false;
		}
		@SuppressWarnings("deprecation")
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) {
			sender.sendMessage("§cEl jugador no está en línea.");
			return false;
		}
		try {
			baseAmount = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			sender.sendMessage("§cCantidad inválida.");
			return false;
		}
		Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
				"tpgive " + target.getName() + " " + baseAmount);
		try {
			double globalMultiplier = BoosterGlobal.getGlobalBooster();
			if (globalMultiplier > 1.0D) {
				int extraTP = (int) (baseAmount * globalMultiplier - baseAmount);
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"tpgive " + target.getName() + " " + extraTP + " §6Booster Global §aX" + globalMultiplier);
			}
		} catch (Exception exception) {
		}
		/*
		try {
			double personalMultiplier = BoosterGlobal.getMultiplicador(target);
			if (personalMultiplier > 1.0D) {
				int extraTP = (int) (baseAmount * personalMultiplier - baseAmount);
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"tpgive " + target.getName() + " " + extraTP + " §6Booster Personal §aX" + personalMultiplier);
			}
		} catch (Exception exception) {
		}*/
		/*try {
			double passiveMultiplier = BoosterManager.getHighestPassiveMultiplier(target);
			if (passiveMultiplier > 1.0D) {
				int extraTP = (int) (baseAmount * passiveMultiplier - baseAmount);
				String passiveID = BoosterManager.getPassiveBoosterID(target);
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "tpgive " + target.getName() + " "
						+ extraTP + " §6Booster Pasivo §aX" + passiveMultiplier + " §6Rango " + passiveID);
			}
		} catch (Exception exception) {
		}*/
		return true;
	}
}
