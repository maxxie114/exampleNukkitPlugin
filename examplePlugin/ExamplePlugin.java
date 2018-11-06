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
    String name = command.getName().toLowerCase();
    switch (name) {
      case "getText":
        String message = msg;
        sender.sendMessage(TextFormat.BLUE + message);
        break;
      case "getNum": // Don't forget to specify in plugin.yml XD
        int num = number;
        sender.sendMessage(TextFormat.GREEN + Integer.toString(num));
        break;
    }
    return true;
  }

  /** For eclipse compiler */
  public static void main(String[] Args) {
    System.out.println("Compiled!!!!");
  }
}
