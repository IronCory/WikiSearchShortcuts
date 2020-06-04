package com.wikishortcuts;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.screenshot.ScreenshotConfig;
import net.runelite.client.plugins.wiki.WikiSearchChatboxTextInput;
import net.runelite.client.util.HotkeyListener;
import javax.inject.Inject;
import javax.inject.Provider;

@Slf4j
@PluginDescriptor(
		name = "Wiki Search Shortcuts",
		description = "Shortcut keys to open osrs wiki search",
		tags = {"wiki", "search", "shortcut", "hotkey"}
)
public class WikiShortcutsPlugin extends Plugin
{
	@Inject
	private WikiShortcutsConfig config;

	@Inject
	private Provider<WikiSearchChatboxTextInput> wikiSearchChatboxTextInputProvider;

	@Inject
	private KeyManager keyManager;

	@Getter(AccessLevel.PACKAGE)
	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> config.hotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			wikiSearchChatboxTextInputProvider.get()
					.build();
		}
	};
	@Provides
	WikiShortcutsConfig getConfig(ConfigManager configManager) { return configManager.getConfig(WikiShortcutsConfig.class); }

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(hotkeyListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(hotkeyListener);
	}

}
