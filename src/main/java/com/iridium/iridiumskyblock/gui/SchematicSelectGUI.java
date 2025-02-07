package com.iridium.iridiumskyblock.gui;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.NMSUtils;
import com.iridium.iridiumskyblock.Utils;
import com.iridium.iridiumskyblock.configs.Schematics;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SchematicSelectGUI extends GUI implements Listener {

    public SchematicSelectGUI(Island island) {
        super(island, IridiumSkyblock.getInventories().schematicselectGUISize, IridiumSkyblock.getInventories().schematicselectGUITitle);
        IridiumSkyblock.getInstance().registerListeners(this);
    }

    @Override
    public void addContent() {
        super.addContent();
        if (IridiumSkyblock.getIslandManager().islands.containsKey(islandID)) {
            int i = 0;
            for (Schematics.FakeSchematic fakeSchematic : IridiumSkyblock.getSchematics().schematics) {
                if (fakeSchematic.slot == null) fakeSchematic.slot = i;
                try {
                    setItem(fakeSchematic.slot, Utils.makeItem(fakeSchematic.item.parseMaterial(), 1, fakeSchematic.item.data, fakeSchematic.displayname, fakeSchematic.lore));
                } catch (Exception e) {
                    setItem(fakeSchematic.slot, Utils.makeItem(Material.STONE, 1, 0, fakeSchematic.displayname, fakeSchematic.lore));
                }
                i++;
            }
        }
    }

    @EventHandler
    @Override
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().equals(getInventory())) {
            e.setCancelled(true);
            for (Schematics.FakeSchematic fakeSchematic : IridiumSkyblock.getSchematics().schematics) {
                if (e.getSlot() == fakeSchematic.slot && (fakeSchematic.permission.isEmpty() || e.getWhoClicked().hasPermission(fakeSchematic.permission))) {
                    getIsland().setSchematic(fakeSchematic.name);
                    getIsland().generateIsland();
                    getIsland().setHome(getIsland().getHome().add(fakeSchematic.x, fakeSchematic.y, fakeSchematic.z));
                    getIsland().teleportHome((Player) e.getWhoClicked());
                    NMSUtils.sendTitle((Player) e.getWhoClicked(), IridiumSkyblock.getMessages().islandCreated, 20, 40, 20);
                    return;
                }
            }
        }
    }
}
