# Setup
To setup the files, you'll need to edit some classes :
  - ItemBuilder
  - Your Main Class

Download ActionBuilder.java, ActionBuilderEvent.java and ActionBuilderListener.java
 
 In your main class, put this line of code:
 ```java
 public HashMap<ItemStack, ActionBuilder> items; 
 ```
 
In your onEnable function:
```java
@Override
public void onEnable() {
  items = new HashMap<>();
  getServer().getPluginManager().registerEvents(new ActionBuilderListener(), this);
}
```

If you already have the ItemBuilder class, just add these lines, otherwhise, download my custom ItemBuilder:
```java
/**
 *
 * @param actionBuilder
 * Way to set a custom action when the player interacts with the item.
 */
public ItemBuilder createAction(ActionBuilder actionBuilder) {
    ToolsMain.INSTANCE.items.put(this.toItemStack(), actionBuilder);
    return this;
}

/**
 *
 * @param itemStack
 * Get any ActionBuilder from any ItemStack that has an ActionBuilder linked with.
 * @return The Action of the ItemStack.
 */
public static ActionBuilder getActionBuilderFromItem(ItemStack itemStack) {
    return ToolsMain.INSTANCE.items.get(itemStack);
}
```

# How to use it?
Great question! How to use ActionBuilder???
Well, this is pretty very easy.

Here is an example:
```java
ItemBuilder myItemBuilder = new ItemBuilder(Material.STICK).setName("§d§lMagic Wand").createAction(new ActionBuilder() {
  @Override
  public void event(ActionBuilderEvent event, ItemStack itemStack, Player aPlayer, InventoryAction action, Event bukkitEvent) {
    if(event == ActionBuilderEvent.PLAYER_INTERACT_EVENT) {
      aPlayer.sendMessage("§cOoOoh! You interacted with the magic WAND!");
    }
    if(event == ActionBuilderEvent.PLAYER_PICKUP_ITEM_EVENT) {
      aPlayer.sendMessage("§dYou picked up the wand! §dYou became a WIZARD!");
    }
    if(event == ActionBuilderEvent.PLAYER_DROP_ITEM_EVENT) {
      aPlayer.sendMessage("§9You dropped the wand... §bYou became a muggle!");
    }
  }
});
```
