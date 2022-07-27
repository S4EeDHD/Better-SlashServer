package ir.S4EeD_HD;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class config {
	
	public static main plugin = main.getPlugin();
	
	public static void drop(){
		File dir = new File(plugin.getDataFolder().getPath());
		if ( ! ( dir.exists() ) ) {
			dir.mkdir();
		}
		File file = new File(plugin.getDataFolder() + "/servers.yml");
		try {
			if ( file.createNewFile() ){
				file.createNewFile();
				Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
				List<String> Bedwars = new ArrayList<String>();
				Bedwars.add("bedwars");
				Bedwars.add("bedwars1");
				List<String> lobby = new ArrayList<String>();
				lobby.add("lobby1");
				lobby.add("lobby2");
				config.set("lobby", lobby);
				config.set("bedwars", Bedwars);
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static Configuration getConfig() throws IOException{
		File file = new File(plugin.getDataFolder() + "/servers.yml");
		Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
		return config;
	}
	
}
