package ir.S4EeD_HD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class main extends Plugin{
	
	private final List<Command> serverCommands = new ArrayList<>();
	public static main ins;
	public static main getPlugin(){
		return ins;
	}
	
	
	@EventHandler
	public void onEnable(){
		ins = this;
		config.drop();
		loadServers();
	}
	
	@EventHandler
	public void onDisable(){
		unloadServers();
	}
	
	public void loadServers() {
        try {
			for (String server : config.getConfig().getKeys()) {
				System.out.println("Server added: " + server);
			    Command command = new SSCommand(server, "server." + server);
			    this.getProxy().getPluginManager().registerCommand(this, command);
			    serverCommands.add(command);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	 public void unloadServers() {
	        for (Command command : serverCommands){
	            this.getProxy().getPluginManager().unregisterCommand(command);
	        }
	        serverCommands.clear();
	    }

}
