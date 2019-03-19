// This line is just to tell the compiler that this java file is in a directory directory(aka package) called examplePlugin
package examplePlugin;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.player.PlayerChatEvent;

import cn.nukkit.utils.TextFormat;
// Now lets add a color to the join leave messages
// Add you need to do to add color, is edited setJoinMessage and setLeaveMessage. 
// For example, if u want a red join message edit it like this.
// event.setJoinMessage(TextFormat.RED + "message");
// there are many different colors RED BLUE, ORANGE, GREEN, YELLOW, WHITE, BLACK.etc.

public class EventListener implements Listener {
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    // This is to save the playername into a name variable, to make it easier
    String name = event.getPlayer().getName();
    // Now lets make one for just you
    // This is if the name variable is "example" then it will show the special message, else it will show the other message
    if (name.equals("example")) {
      event.setJoinMessage(TextFormat.RED + "SERVER OWNER: " + name + ", HAS JOINED! LET'S WELCOME HIM!"); // "SERVER OWNER: example, HAS JOINED! LET'S WELCOME HIM!"
    } else {
      // this next line will send a join message, color have to be uppercase
      // In this case, if the player joined is called example2, it will show "example2, Welcome to the server!"
      event.setJoinMessage(TextFormat.GREEN + name + "," +  " Welcome to the server!"); 
    }
    // This line send a welcome message to the player who joined
    //event.getPlayer().sendMessage("Welcome to the server!");
  }

  // This method specify what should the server do when someone quit the server, in other word, when a PlayerQuitEvent occurred
  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    String name = event.getPlayer().getName(); // assigning variables make stuff so much easier
    event.setQuitMessage(TextFormat.RED + name + " " + "Has left the server, let's hope we can see him again!");
    // This will print "playername Has left the server, let's hope we can see him again!" 
  }

// This method specify what to do when a player talk
// This will be a bit more complicated
// for this we need another event called PlayerChatEvent, so like I said, when we need something, we import it
 @EventHandler // this just means it handle an event
 public void onPlayerChat(PlayerChatEvent event) {
   String msg = event.getMessage(); // This get the content of the message and then store in "msg" variable
   // This check if the message is started with >
   if (msg.startsWith(">")) {
     event.setMessage(TextFormat.AQUA + msg); 
   } 
 }
}
