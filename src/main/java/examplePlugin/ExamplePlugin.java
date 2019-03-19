package examplePlugin;

// import, means the code depend on some external code, in this case, nukkit itself
// these can be found here
// https://github.com/NukkitX/Nukkit
// Those code up there are nukkit source code, you can take a look at it to get familiar with the API
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

// after import, you just need to type something like this
// public class ExamplePlugin {
// the name after the class must be exactly the same as the file name
// extends, also means it depends on something, for more info google "OOP" 
// In this case, it depends on a code called PluginBase, which is from Nukkit itself
// This has to be there, else the plugin wont work kok
public class ExamplePlugin extends PluginBase {
  
  // here you declare some variables, like math, x y z
  // you can totally just use x,y,z as variable names: but its not a good practice
  private String msg;
  private int number;

  // Override, just means this piece of code, from { to } is one piece of code, we call it one method
  @Override
  public void onEnable() {
    // everything in onEnable is what the plugin will do when it enabled
    // this line send "ExamplePlugin enabled" to the console, in green color, you can change it
    this.getLogger().info(TextFormat.BLUE + "Plugin enabled.");
    // a listener, listen to server events, or player action, a listener have to be registed before it will work
    // in this case, we registerEvents
    // Just know that this line is important, u can copy this exactly as how it is, you don't have to touch this line
    this.getServer().getPluginManager().registerEvents(new EventListener(), this);
    // saveDefaultConfig, save the condiguration file, called config.yml
    this.saveDefaultConfig();
    // This line right here will get commandMessage from the config
    // This line right here, we set variable name "msg" to the info in the config
    msg = String.valueOf(this.getConfig().get("commandMessage"));
    // This line right here will get number, as an integer, so it has to be a number, an it has to be integer
    // else it will error
    number = this.getConfig().getInt("Number");
  }

  // This is what to do when plugin disabled
  @Override
  public void onDisable() {
    this.getLogger().info(TextFormat.RED + "Plugin disabled.");
  }

  // This is where you make commands
  /*
   * sender, is the player who send the command
   * command, is the command text itself
   * label is the command name
   * String[] args is a list, that store all the arguments of the command
   */
  // This line have to be like that, it cant be changed
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    // this one is obvious, get the command, and convert the text to lowercase
    // for example /NAME will become /name
    // Command should always be lowercase, else the entire game will crash for some reason
    String name = command.getName().toLowerCase();
    // switch, its like a condition check
    switch (name) {
      // The next 4 lines: if the command name is /gettext, it will get the commandMessage from the config, and broadcast it
      case "gettext":
	// This line right here, we set a variable named message to "msg"
        String message = msg;
	// This here we send the message as a blue text to the command sender
        sender.sendMessage(TextFormat.BLUE + message);
	// this here we quit the command
        break;
	// This here is another commmand, called /getnum
      case "getnum": // Don't forget to specify in plugin.yml
	// it does the same thing, it take the number from config and send it to the command sender 
        int num = number;
        sender.sendMessage(TextFormat.GREEN + Integer.toString(num));
        break;
      // To create a command, what you need to do here, is like the above, make a new case, put a command name, and then add a column at the end of that line
      case "yeet":
	//now we send a message
	sender.sendMessage(TextFormat.RED + "lol");
	// now we end the command using break;
	break;
    }
    return true;
  }
}

// so we save the code
