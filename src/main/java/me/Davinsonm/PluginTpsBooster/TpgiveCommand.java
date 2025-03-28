package me.Davinsonm.PluginTpsBooster;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

class TpgiveCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int amount;
		if (args.length < 2) {
			sender.sendMessage("§cUso correcto: /tpgive <jugador> <cantidad> [comentario]");
			return false;
		}
		@SuppressWarnings("deprecation")
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) {
			sender.sendMessage("§cEl jugador no está en línea.");
			return false;
		}
		try {
			amount = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			sender.sendMessage("§cCantidad inválida.");
			return false;
		}
		String comment = (args.length > 2)
				? String.join(" ", Arrays.<CharSequence>copyOfRange((CharSequence[]) args, 2, args.length))
				: "";
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "jrmctp " + amount + " " + target.getName());
		String color = (amount >= 0) ? "§a+" : "§c";
		String message = color + amount + " TPs!" + (comment.isEmpty() ? "" : (" §f(§e" + comment + "§f)"));
		target.sendMessage(message);
		return true;
	}
}
