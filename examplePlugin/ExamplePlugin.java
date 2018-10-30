package examplePlugin;

import java.io.File;
import java.util.LinkedHashMap;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class ExamplePlugin extends PluginBase {

  private String msg;
  private Config config;

  @SuppressWarnings("deprecation")
  @Override
  public void onEnable() {
    this.getLogger().info(TextFormat.GREEN + "ExamplePlugin enabled.");
    this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

    this.config = new Config(new File(this.getDataFolder(), "config.yml"), Config.YAML,

        new LinkedHashMap<String, Object>() {
          /**
           * 
           */
          private static final long serialVersionUID = 1L;

          // create key spawnRange with default input 900
          {
            // default settings specific to 2b2tbe
            put("commandMessage", "Welcome!");
          }
        });

    msg = String.valueOf(config.get("commandMessage"));

  }

  @Override
  public void onDisable() {
    this.getLogger().info(TextFormat.RED + "ExamplePlugin disabled.");
    // this.getConfig().save();
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("example")) {
      String message = msg;
      sender.sendMessage(TextFormat.BLUE + message);
      return true;
    } else {
      sender.sendMessage(TextFormat.RED + "Command doesn't exist.");
      return true;
    }

  }

  /** For eclipse compiler */
  public static void main(String[] Args) {
    System.out.println("Compiled.");
  }
}
