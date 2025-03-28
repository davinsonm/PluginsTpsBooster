package me.Davinsonm.PluginTpsBooster;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.NBTTagCompound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TrainingPointsPlaceholder extends PlaceholderExpansion {
	public String getIdentifier() {
		return "trainingpoints";
	}

	public String getAuthor() {
		return "TuNombre";
	}

	public String getVersion() {
		return "1.0";
	}

	public String onRequest(Player player, String params) {
		if (params == null || params.isEmpty())
			return String.valueOf(getTrainingPoints(player));
		return null;
	}

	private int getTrainingPoints(Player player) {
		CraftPlayer craftPlayer = (CraftPlayer) player;
		EntityPlayer entityPlayer = craftPlayer.getHandle();
		NBTTagCompound nbtTag = new NBTTagCompound();
		entityPlayer.c(nbtTag);
		if (nbtTag.hasKey("jrmcTpint"))
			return nbtTag.getInt("jrmcTpint");
		return 0;
	}
}