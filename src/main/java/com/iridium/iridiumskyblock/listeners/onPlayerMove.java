package com.iridium.iridiumskyblock.listeners;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onPlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        try {
            if (e.getPlayer().getLocation().getY() < 0 && IridiumSkyblock.getConfiguration().voidTeleport) {
                Island island = IridiumSkyblock.getIslandManager().getIslandViaLocation(e.getPlayer().getLocation());
                if (island != null) {
                    if (e.getPlayer().getLocation().getWorld().equals(IridiumSkyblock.getIslandManager().getWorld())) {
                        island.teleportHome(e.getPlayer());
                    } else {
                        island.teleportNetherHome(e.getPlayer());
                    }
                }
            }
            User user = User.getUser(e.getPlayer());
            Island island = user.getIsland();
            if (island != null) {
                if (user.flying && !island.isInIsland(e.getPlayer().getLocation())) {
                    e.getPlayer().setAllowFlight(false);
                    e.getPlayer().setFlying(false);
                    user.flying = false;
                }
            }
        } catch (Exception ex) {
            IridiumSkyblock.getInstance().sendErrorMessage(ex);
        }
    }
}
