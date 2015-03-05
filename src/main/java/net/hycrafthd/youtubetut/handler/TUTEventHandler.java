package net.hycrafthd.youtubetut.handler;

import net.hycrafthd.youtubetut.TUTMain;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class TUTEventHandler {
	
	@SubscribeEvent
	public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent e) {
		e.player.addChatMessage(new ChatComponentText(TUTMain.tutgreeting));
	}
	
}
