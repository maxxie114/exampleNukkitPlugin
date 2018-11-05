package examplePlugin;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class ExamplePlugin extends PluginBase {

  private String msg;
  private int number;
  // private Config config;

  // @SuppressWarnings("deprecation")
  @Override
  public void onEnable() {
    this.getLogger().info(TextFormat.GREEN + "ExamplePlugin enabled.");
    this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
    this.saveDefaultConfig();
    msg = String.valueOf(this.getConfig().get("commandMessage"));
    number = this.getConfig().getInt("Number");
    /*
     * this.config = new Config(new File(this.getDataFolder(), "config.yml"), Config.YAML,
     * 
     * new LinkedHashMap<String, Object>() {
     * 
     * private static final long serialVersionUID = 1L;
     * 
     * // create key spawnRange with default input 900 { // default settings specific to 2b2tbe
     * put("commandMessage", "Welcome!"); } });
     * 
     * msg = String.valueOf(config.get("commandMessage"));
     */
  }

  @Override
  public void onDisable() {
    this.getLogger().info(TextFormat.RED + "ExamplePlugin disabled.");
    // this.getConfig().save();
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    // String name = command.getName();
    if (command.getName().equalsIgnoreCase("example")) {
      String message = msg;
      sender.sendMessage(TextFormat.BLUE + message);
      int num = number;
      sender.sendMessage(TextFormat.GREEN + Integer.toString(num));
      return true;
    } else if (command.getName().equalsIgnoreCase("getnum")) {
      int num = number;
      sender.sendMessage(TextFormat.GREEN + Integer.toString(num));
      return true;
    } else {
      sender.sendMessage(TextFormat.RED + "Command doesn't exist.");
    }
    return false;
  }

  /** For eclipse compiler */
  public static void main(String[] Args) {
    System.out.println("Compiled!");
  }
}
