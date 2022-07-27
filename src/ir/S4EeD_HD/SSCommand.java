package ir.S4EeD_HD;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;

public class SSCommand extends Command {

	public SSCommand(String name, String permission) {
		super(name, permission);
	}
	
	public main plugin = main.getPlugin();
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		try {
			Configuration conf = config.getConfig();
			String server = this.getName();
			if ( conf.getStringList(server) == null || ! conf.contains(server) ) {
				sender.sendMessage("§cServer not found.");
				return;
			}
			ProxiedPlayer player = (ProxiedPlayer) sender;
	        List<String> servers = conf.getStringList(server);
	        Random rand = new Random();
	        String sv = servers.get(rand.nextInt(servers.size()));
	        sender.sendMessage("§aSending you to " + server);
	        ServerInfo serverInfo = ProxyServer.getInstance().getServerInfo(sv);
	        player.connect(serverInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
