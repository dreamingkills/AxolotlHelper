package house.catgirl.AxolotlHelper;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DyeListener implements Listener {
    @EventHandler
    public void onAxolotlClick(PlayerInteractEntityEvent event) {
        if(event.getRightClicked().getType() != EntityType.AXOLOTL) return;

        Axolotl axolotl = ((Axolotl) event.getRightClicked());
        Axolotl.Variant variant = axolotl.getVariant();

        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Material itemType = item.getType();

        if(itemType == Material.BLUE_DYE) {
            axolotl.setVariant(Axolotl.Variant.BLUE);
        } else if (itemType == Material.CYAN_DYE) {
            axolotl.setVariant(Axolotl.Variant.CYAN);
        } else if (itemType == Material.YELLOW_DYE) {
            axolotl.setVariant(Axolotl.Variant.GOLD);
        } else if (itemType == Material.PINK_DYE) {
            axolotl.setVariant(Axolotl.Variant.LUCY);
        } else if (itemType == Material.BROWN_DYE) {
            axolotl.setVariant(Axolotl.Variant.WILD);
        }

        boolean isChanged = variant != axolotl.getVariant();
        boolean isCreative = event.getPlayer().getGameMode().equals(GameMode.CREATIVE);

        if(isChanged && !isCreative) item.setAmount(item.getAmount() - 1);
    }
}
