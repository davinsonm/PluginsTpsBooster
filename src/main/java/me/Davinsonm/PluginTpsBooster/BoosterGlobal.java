package me.Davinsonm.PluginTpsBooster;


import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

public class BoosterGlobal extends Booster {
    public static double GlobalBooster = 1.0;
    private static BukkitRunnable boosterTask = null; // Solo un temporizador global

    public static void Activar(String type, CommandSender sender, double multiplier, int time, String name) {
        setTiempo(time);
        setNombre(name);
        setGlobalBooster(multiplier);
        tiemporest = time;

        Bukkit.broadcastMessage("§a" + sender.getName() + " activó un booster X" + getGlobalBooster() +
                " por " + formatTime(getTiempo()) + ".");

        // Si ya hay un booster activo, lo cancelamos antes de iniciar uno nuevo
        if (boosterTask != null) {
            boosterTask.cancel();
        }

        // Iniciar la cuenta regresiva
        boosterTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (tiemporest <= 0) {
                    Desactivar();
                    cancel();
                } else {
                    tiemporest--;
                }
            }
        };

        boosterTask.runTaskTimer(PluginTpsBooster.getInstance(), 20L, 20L); // Cada segundo
    }

    public static void setGlobalBooster(double multiplier) {
        GlobalBooster = multiplier;
    }

    public static double getGlobalBooster() {
        return GlobalBooster;
    }

    public static void Desactivar() {
        setGlobalBooster(1.0);
        Bukkit.broadcastMessage("§cBooster Global desactivado.");
        if (boosterTask != null) {
            boosterTask.cancel();
            boosterTask = null;
        }
    }
}