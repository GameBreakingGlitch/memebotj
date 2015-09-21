package me.krickl.memebotj.InternalCommands;

import me.krickl.memebotj.ChannelHandler;
import me.krickl.memebotj.CommandHandler;
import me.krickl.memebotj.Memebot;
import me.krickl.memebotj.UserHandler;

public class UserPowerCommand extends CommandHandler {

	public UserPowerCommand(String channel, String command, String dbprefix) {
		super(channel);
		this.setAccess("botadmin");
	}
	
	@Override
	protected void commandScript(UserHandler sender, ChannelHandler channelHandler, String[] data) {
		try {
			boolean success = false;
			for(String key : channelHandler.getUserList().keySet()) {
				UserHandler uh = channelHandler.getUserList().get(key);
				if( uh.getUsername().equals(data[1]) ) {
					uh.setCommandPower(Integer.parseInt(data[1]));
					uh.writeDBUserData();
					success = true;
				}
			}
			
			if(!success) {
				UserHandler uh = new UserHandler(data[1], channelHandler.getChannel());
				if(!uh.isNewUser()) {
					uh.setCommandPower(Integer.parseInt(data[1]));
					uh.writeDBUserData();
					success = true;
				}
			}
			
			if(success) {
				channelHandler.sendMessage("Changed user power to " + data[1], this.getChannelOrigin());
			} else {
				channelHandler.sendMessage("This user never joined this channel: " + data[1], this.getChannelOrigin());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
	}

}