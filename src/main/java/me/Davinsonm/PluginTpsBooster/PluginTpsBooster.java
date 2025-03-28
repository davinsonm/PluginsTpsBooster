package me.Davinsonm.PluginTpsBooster;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginTpsBooster extends JavaPlugin {
	private static PluginTpsBooster instance;
	public void onEnable() {
		instance = this;
		getLogger().info("DBCPlugin activado!");
		(new LevelPlaceholder()).register();
		(new TrainingPointsPlaceholder()).register();
		if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
			(new LevelPlaceholder()).register();
			(new TrainingPointsPlaceholder()).register();
			getLogger().info("PlaceholderAPI está presente. Placeholder de Training Points registrado.");
		} else {
			getLogger().warning("PlaceholderAPI no está instalado. El placeholder de Training Points no se registrará.");
		}
		getCommand("tpgive").setExecutor(new TpgiveCommand());
		getCommand("dartps").setExecutor(new DartpsCommand());
		getCommand("booster").setExecutor(new BoosterCommand());
		getCommand("dartpsbooster").setExecutor(new ReloadCommand((Plugin) this));
	}

	public void onDisable() {
		instance = null;
		getLogger().info("DBCPlugin desactivado!");
	}
	public static PluginTpsBooster getInstance() {
        return instance; // Devuelve la instancia del plugin
    }
}
