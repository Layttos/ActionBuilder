package fr.layttos.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;

/**
 *
 * Created by Layttos.
 *
 *  ActionBuilder.java is a class that allows the developer
 *  to create an action for any ITEMBUILDER (c.f ItemBuilder.java).
 *  In order to make it work, you'll need to edit some classes such as your main class,
 *  and ItemBuilder, obviously.
 *
 *  You are allowed to: edit it, copy it, publish it, whatever UNLESS for a commercial use.
 *  Each modification must be OPEN-SOURCE.
 */


public interface ActionBuilder {

    void event(ActionBuilderEvent event, ItemStack itemStack, Player player, InventoryAction action, Event bukkitEvent);

}

