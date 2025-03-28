package me.Davinsonm.PluginTpsBooster;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.NBTTagCompound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class LevelPlaceholder extends PlaceholderExpansion {
	public String getIdentifier() {
		return "level";
	}

	public String getAuthor() {
		return "TuNombre";
	}

	public String getVersion() {
		return "1.0";
	}

	public String onRequest(Player player, String params) {
		if (params == null || params.isEmpty())
			return String.valueOf(calculateLevel(player));
		return null;
	}

	private int getAttributeValue(Player player, String attribute) {
		CraftPlayer craftPlayer = (CraftPlayer) player;
		EntityPlayer entityPlayer = craftPlayer.getHandle();
		NBTTagCompound nbtTag = new NBTTagCompound();
		entityPlayer.c(nbtTag);
		if (nbtTag.hasKey(attribute))
			return nbtTag.getInt(attribute);
		return 0;
	}

	private int calculateLevel(Player player) {
		int str = getAttributeValue(player, "jrmcStrl");
		int dex = getAttributeValue(player, "jrmcDexl");
		int con = getAttributeValue(player, "jrmcCnsl");
		int wil = getAttributeValue(player, "jrmcWill");
		int mnd = getAttributeValue(player, "jrmcIntl");
		int spi = getAttributeValue(player, "jrmcCncl");
		double average = (str + dex + con + wil + mnd + spi - 60) / 5.0D;
		int level = (int) (average + 1.0D);
		return Math.max(level, 0);
	}
}
