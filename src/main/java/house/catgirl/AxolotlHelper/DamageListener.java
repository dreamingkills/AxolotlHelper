package house.catgirl.AxolotlHelper;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void onAxolotlDamage(EntityDamageEvent event) {
        if(event.getEntity().getType() != EntityType.AXOLOTL) return;
        LivingEntity axolotl = ((LivingEntity) event.getEntity());

        EntityDamageEvent.DamageCause cause = event.getCause();

        if(cause == EntityDamageEvent.DamageCause.DRYOUT || cause == EntityDamageEvent.DamageCause.SUFFOCATION) {
            axolotl.setRemainingAir(30 * 60 * 20);
            event.setCancelled(true);
        }
    }
}
