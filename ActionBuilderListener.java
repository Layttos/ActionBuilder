package fr.layttos.listeners;

import fr.layttos.MainClass;
import fr.layttos.utils.ItemBuilder;
import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

public class ActionBuilderListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getCurrentItem() == null) return;
        ItemStack clickedItem = event.getCurrentItem();
        if(!(event.getWhoClicked() instanceof Player)) return;
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(clickedItem);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.INVENTORY_CLICK_EVENT, clickedItem, (Player) event.getWhoClicked(), event.getAction(), event);
        }
    }

    @EventHandler
    public void onEntityDropItem(PlayerDropItemEvent event) {
        if(event.getItemDrop() == null) return;
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(droppedItem);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_DROP_ITEM_EVENT, droppedItem, event.getPlayer(), null, event);
        }
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        if(event.getItem() == null) return;
        ItemStack pickedUpItem = event.getItem().getItemStack();
        if(!(event.getEntity() instanceof Player)) return;
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(pickedUpItem);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_PICKUP_ITEM_EVENT, pickedUpItem, (Player) event.getEntity(), null, event);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        ItemStack itemStack = event.getItem();
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(itemStack);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_INTERACT_EVENT, itemStack, event.getPlayer(), null, event);
        }
    }

    @EventHandler
    public void onInventoryItemSwitch(PlayerInventorySlotChangeEvent event) {
        if(event.getNewItemStack() == null) return;
        ItemStack itemStack = event.getNewItemStack();
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(itemStack);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_SWITCH_SLOT_EVENT, itemStack, event.getPlayer(), null, event);
        }
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack itemStack = event.getItem();
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(itemStack);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_CONSUME_ITEM_EVENT, itemStack, event.getPlayer(), null, event);
        }
    }

    @EventHandler
    public void onInteractToEntity(PlayerInteractEntityEvent event) {
        ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(itemStack);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_INTERACT_TO_ENTITY_EVENT, itemStack, event.getPlayer(), null, event);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // /event_template create template_id: 1 - Disponibilités event_start: 2023-07-27 20:00 title: Êtes-vous disponible Jeudi ? template: 2 - Attendance
        ItemStack itemStack = event.getPlayer().getItemInHand();
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(itemStack);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_BREAKS_BLOCK_WHILE_HANDLING_ITEM, itemStack, event.getPlayer(), null, event);
        }
    }

    @EventHandler
    public void onFishingRodReturn(PlayerFishEvent event) {
        ItemStack itemStack = event.getPlayer().getItemInHand();
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(itemStack);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.PLAYER_FISH_EVENT, itemStack, event.getPlayer(), null, event);
        }
    }

    @EventHandler
    public void onItemCraft(CraftItemEvent event) {
        ItemStack itemStack = event.getRecipe().getResult();
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if(MainClass.INSTANCE.items.isEmpty()) return;
        ActionBuilder actionBuilder = ItemBuilder.getActionBuilderFromItem(itemStack);
        if(actionBuilder != null) {
            actionBuilder.event(ActionBuilderEvent.CRAFT_ITEM_EVENT, itemStack, player, event.getAction(), event);
        }
    }

}
