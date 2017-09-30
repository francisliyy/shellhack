/**
 * 
 */
package edu.shellhack.shelder;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * @author ThinkPad
 *
 */
public class MessageListener extends ListenerAdapter {
	
	public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException
    {
        JDA jda = new JDABuilder(AccountType.BOT).setToken("MzYzNTk4ODM3NDg4NjgwOTYx.DLDkZQ.pQd7kFU3lTKnEwG5UrK50MmIOsg").buildBlocking();
        jda.addEventListener(new MessageListener());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                                    event.getMessage().getContent());
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                        event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                        event.getMessage().getContent());
            String toBeInterpreted = event.getMessage().getContent();
            if("ping".equals(toBeInterpreted))
            {
            	//reply pong
            }
        }
    }

}
