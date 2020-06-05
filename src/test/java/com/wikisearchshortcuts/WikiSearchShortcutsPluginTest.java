package com.wikisearchshortcuts;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class WikiSearchShortcutsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(WikiSearchShortcutsPlugin.class);
		RuneLite.main(args);
	}
}