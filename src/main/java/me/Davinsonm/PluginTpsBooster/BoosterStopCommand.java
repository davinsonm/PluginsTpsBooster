package me.Davinsonm.PluginTpsBooster;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

class BoosterStopCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 1) {
			sender.sendMessage("§cUso correcto: /boosterstop <tipo> [nombre]");
			return false;
		}else {
		String tipo= args[0];
		String nombre= args[1];
		///booster <tipo> <multi> <tiempo> [nombre]
		if(tipo.equalsIgnoreCase("global")) {
			BoosterGlobal.Desactivar();
		}/*else if(tipo=="personal") {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "booster " + tipo +" "+ multi +" "+ tiempo + " "+Bukkit.getPlayer(nombre));

		}else if(tipo=="pasivo") {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "booster " + tipo +" "+ multi +" "+ tiempo +" "+ nombre);
			
		}*/
			}
		return true;
	}
	
}
