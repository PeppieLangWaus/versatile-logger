package xyz.peppie.versatilelogger.chat;

import java.util.regex.Pattern;

final class ClanBroadcastPatterns
{
	private static final Pattern DROP_PATTERN =
		Pattern.compile(".*received (a(?: rare)? drop|special loot from a raid): .*", Pattern.DOTALL);

	private static final Pattern LEVEL_MILESTONE_PATTERN =
		Pattern.compile(".* has reached (a |the highest possible )?[^<>]+? level( of)? [\\d,]+[!.].*", Pattern.DOTALL);

	private ClanBroadcastPatterns() {	}

	static boolean isLevelUpOrDropBroadcast(String message)
	{
		if (message == null)
		{
			return false;
		}

		return DROP_PATTERN.matcher(message).matches() || LEVEL_MILESTONE_PATTERN.matcher(message).matches();
	}
}
