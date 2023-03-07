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
        if (event.getRightClicked().getType() != EntityType.AXOLOTL) return;

        Axolotl axolotl = ((Axolotl) event.getRightClicked());
        Axolotl.Variant variant = axolotl.getVariant();

        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Material itemType = item.getType();

        switch (itemType) {
            case BLUE_DYE -> axolotl.setVariant(Axolotl.Variant.BLUE);
            case CYAN_DYE -> axolotl.setVariant(Axolotl.Variant.CYAN);
            case YELLOW_DYE -> axolotl.setVariant(Axolotl.Variant.GOLD);
            case PINK_DYE -> axolotl.setVariant(Axolotl.Variant.LUCY);
            case BROWN_DYE -> axolotl.setVariant(Axolotl.Variant.WILD);
        }

        boolean isChanged = variant != axolotl.getVariant();
        boolean isCreative = event.getPlayer().getGameMode() == GameMode.CREATIVE;

        if (isChanged && !isCreative) item.setAmount(item.getAmount() - 1);
    }
}
