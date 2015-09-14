package me.krickl.memebotj.InternalCommands;

import me.krickl.memebotj.ChannelHandler;
import me.krickl.memebotj.CommandHandler;
import me.krickl.memebotj.UserHandler;

public class QuitCommand extends CommandHandler {

	public QuitCommand(String channel, String command, String dbprefix) {
		super(channel, command, dbprefix);
		this.setAccess("broadcaster");
		this.setUnformattedOutput("Quitting bot MrDestructoid");
	}

	@Override
	protected void commandScript(UserHandler sender, ChannelHandler channelHandler, String[] data) {
		System.exit(0);
	}

}
