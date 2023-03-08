package house.catgirl.AxolotlHelper;

import org.bukkit.plugin.java.JavaPlugin;

public class AxolotlHelper extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        getServer().getPluginManager().registerEvents(new DyeListener(), this);
    }
}
