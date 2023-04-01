package fr.layttos.listeners;

import fr.layttos.utils.ActionBuilder;
import fr.layttos.utils.ActionBuilderEvent;
import fr.layttos.utils.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ActionBuilderListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getCurrentItem() == null) return;
        ItemStack clickedItem = event.getCurrentItem();
        if(!(event.getWhoClicked() instanceof Player)) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(clickedItem);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.INVENTORY_CLICK_EVENT, clickedItem, (Player) event.getWhoClicked(), event.getAction(), event);
        }
    }

    @EventHandler
    public void onEntityDropItem(EntityDropItemEvent event) {
        if(event.getItemDrop() == null) return;
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        if(!(event.getEntity() instanceof Player)) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(droppedItem);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_DROP_ITEM_EVENT, droppedItem, (Player) event.getEntity(), null, event);
        }
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        if(event.getItem() == null) return;
        ItemStack pickedUpItem = event.getItem().getItemStack();
        if(!(event.getEntity() instanceof Player)) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(pickedUpItem);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_PICKUP_ITEM_EVENT, pickedUpItem, (Player) event.getEntity(), null, event);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        ItemStack itemStack = event.getItem();
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(itemStack);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_INTERACT_EVENT, itemStack, event.getPlayer(), null, event);
        }
    }

}
