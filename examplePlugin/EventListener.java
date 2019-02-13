package examplePlugin;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.utils.TextFormat;

public class EventListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    event.getPlayer().sendChat(TextFormat.GREEN + "Welcome to the server!");
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    event.setQuitMessage(event.getPlayer().getName() + " " + "Has just left the server!");
  }

}
