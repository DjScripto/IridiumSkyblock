package com.iridium.iridiumskyblock.gui;

import com.iridium.iridiumskyblock.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.lang.reflect.Field;
import java.util.HashMap;

public class PermissionsGUI extends GUI implements Listener {

    private Role role;

    private HashMap<Role, PermissionsGUI> permissions = new HashMap<>();

    public PermissionsGUI(Island island) {
        super(island, IridiumSkyblock.getInventories().permissionsGUISize, IridiumSkyblock.getInventories().permissionsGUITitle);
        IridiumSkyblock.getInstance().registerListeners(this);
        int i = 11;
        for (Role role : Role.values()) {
            permissions.put(role, new PermissionsGUI(island, role));
            setItem(i, Utils.makeItem(Material.STAINED_CLAY, 1, 14, "&b&l" + role.name()));
            i++;
        }
    }

    public PermissionsGUI(Island island, Role role) {
        super(island, 27, IridiumSkyblock.getInventories().permissionsGUITitle);
        this.role = role;
    }

    @Override
    public void addContent() {
        super.addContent();
        if (role != null && getIsland() != null) {
            int i = 0;
            try {
                for (Field field : Permissions.class.getDeclaredFields()) {
                    Object object = field.get(getIsland().getPermissions(role));
                    if (object instanceof Boolean) {
                        setItem(i, Utils.makeItem(Material.STAINED_CLAY, 1, (Boolean) object ? 5 : 14, "&b&l" + field.getName()));
                    }
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        User u = User.getUser(p);
        if (e.getInventory().equals(getInventory())) {
            e.setCancelled(true);
            int i = 11;
            for (Role role : Role.values()) {
                if (e.getSlot() == i) {
                    e.getWhoClicked().openInventory(permissions.get(role).getInventory());
                }
                i++;
            }
        } else {
            for (Role role : permissions.keySet()) {
                PermissionsGUI gui = permissions.get(role);
                if (e.getInventory().equals(gui.getInventory())) {
                    e.setCancelled(true);
                    if (role.getRank() < u.role.getRank()) {
                        int i = 0;
                        try {
                            for (Field field : Permissions.class.getDeclaredFields()) {
                                Object object = field.get(getIsland().getPermissions(role));
                                if (i == e.getSlot()) {
                                    field.setAccessible(true);
                                    field.setBoolean(getIsland().getPermissions(role), !(Boolean) object);
                                }
                                i++;
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        e.getWhoClicked().sendMessage(Utils.color(IridiumSkyblock.getMessages().noPermission.replace("%prefix%", IridiumSkyblock.getConfiguration().prefix)));
                    }
                }
            }
        }
    }
}