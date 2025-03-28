package me.Davinsonm.PluginTpsBooster;

abstract class Booster {
	static double multiplicador=1.0;
	static int tiempo = -1;
	static String nombre = "";
	static int tiemporest=-1;

	public static double getMultiplicador() {
		return multiplicador;
	}

	public static void setMultiplicador(double multiplier) {
		if (multiplier >= 1.0) {
			multiplicador = multiplier;
		} 
		if (multiplier < 1.0 && multiplier > 0) {
			multiplicador = 1.0+multiplier;
		}
	}

	public static int getTiempo() {
		return tiempo;
	}

	public static  void setTiempo(int time) {
		tiempo = time;
	}

	public static String getNombre() {
		return nombre;
	}

	public static  void setNombre(String name) {
		nombre = name;
	}

	public static int parseTime(String input) {
	    if (input.equals("-1"))
	        return -1;
	    int totalSeconds = 0;
	    try {
	        if (input.endsWith("s")) {
	            totalSeconds = Integer.parseInt(input.replace("s", ""));
	        } else if (input.endsWith("m")) {
	            totalSeconds = Integer.parseInt(input.replace("m", "")) * 60;
	        } else if (input.endsWith("h")) {
	            totalSeconds = Integer.parseInt(input.replace("h", "")) * 3600;
	        } else if (input.endsWith("d")) {
	            totalSeconds = Integer.parseInt(input.replace("d", "")) * 86400;
	        } else if (input.endsWith("w")) {
	            totalSeconds = Integer.parseInt(input.replace("w", "")) * 604800;
	        } else {
	            totalSeconds = Integer.parseInt(input); // Si no tiene sufijo, asumir segundos
	        }
	    } catch (NumberFormatException e) {
	        return 0; // Si falla, devolver 0 como valor inválido
	    }
	    return totalSeconds;
	}

	public static String formatTime(int seconds) {
		if (seconds == -1)
			return "∞";
		int d = seconds / 86400;
		int h = seconds % 86400 / 3600;
		int m = seconds % 3600 / 60;
		int s = seconds % 60;
		return ((d > 0) ? (d + " días ") : "") + ((h > 0) ? (h + " horas ") : "") + ((m > 0) ? (m + " minutos ") : "")
				+ ((s > 0) ? (s + " segundos") : "").trim();
	}
}