package com.wikishortcuts;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class WikiShortcutsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(WikiShortcutsPlugin.class);
		RuneLite.main(args);
	}
}