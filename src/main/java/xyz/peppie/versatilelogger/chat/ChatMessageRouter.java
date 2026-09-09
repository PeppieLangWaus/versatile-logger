package xyz.peppie.versatilelogger.chat;

import java.util.Optional;
import net.runelite.api.ChatMessageType;


public class ChatMessageRouter
{
	public Optional<ChatCategory> categorize(ChatMessageType type, String message)
	{
		if (type == ChatMessageType.GAMEMESSAGE)
		{
			Optional<ChatCategory> patternMatch = GameMessagePatterns.classify(message);
			if (patternMatch.isPresent())
			{
				return patternMatch;
			}
		}
		else if (type == ChatMessageType.CLAN_MESSAGE && ClanBroadcastPatterns.isLevelUpOrDropBroadcast(message))
		{
			return Optional.of(ChatCategory.CLAN_CHAT);
		}

		for (ChatCategory category : ChatCategory.values())
		{
			if (category.getTypes().contains(type))
			{
				return Optional.of(category);
			}
		}

		return Optional.empty();
	}
}
