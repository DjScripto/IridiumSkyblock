package com.iridium.iridiumskyblock.placeholders;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.User;
import com.iridium.iridiumskyblock.Utils;
import org.bukkit.entity.Player;

import java.text.NumberFormat;
import java.util.List;

public class MVDWPlaceholderAPIManager {

    public MVDWPlaceholderAPIManager() {
    }

    public void register() {
        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_value", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? NumberFormat.getInstance().format(user.getIsland().getValue()) + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_level", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? NumberFormat.getInstance().format(Math.floor(user.getIsland().getValue() / IridiumSkyblock.getConfiguration().valuePerLevel)) + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_rank", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? NumberFormat.getInstance().format(Utils.getIslandRank(user.getIsland())) + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_owner", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? User.getUser(user.getIsland().getOwner()).name : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_name", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getName() : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_crystals", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? NumberFormat.getInstance().format(user.getIsland().getCrystals()) + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_members", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getMembers().size() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_upgrade_member_level", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getMemberLevel() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_upgrade_member_amount", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? IridiumSkyblock.getUpgrades().memberUpgrade.upgrades.get(user.getIsland().getMemberLevel()).size + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_upgrade_size_level", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getSizeLevel() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_upgrade_ore_level", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getOreLevel() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_upgrade_warp_level", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getWarpLevel() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_booster_spawner", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getSpawnerBooster() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_booster_exp", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getExpBooster() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_booster_farming", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getFarmingBooster() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_booster_flight", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().getFlightBooster() + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_bank_vault", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().money + "" : "N/A";
        });

        PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_bank_experience", e -> {
            Player player = e.getPlayer();
            if (player == null) {
                return "N/A";
            }
            User user = User.getUser(player);
            return user.getIsland() != null ? user.getIsland().exp + "" : "N/A";
        });

        for (int i = 0; i < 10; i++) { //TODO there is probabbly a more efficient way to do this?
            int finalI = i;
            PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_top_name_" + (i + 1), e -> {
                List<Island> islands = Utils.getTopIslands();
                return islands.size() > finalI ? User.getUser(Utils.getTopIslands().get(finalI).getOwner()).name : "N/A";
            });
            PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_top_value_" + (i + 1), e -> {
                List<Island> islands = Utils.getTopIslands();
                return islands.size() > finalI ? Utils.getTopIslands().get(finalI).getValue() + "" : "N/A";
            });
            PlaceholderAPI.registerPlaceholder(IridiumSkyblock.getInstance(), "iridiumskyblock_island_top_level_" + (i + 1), e -> {
                List<Island> islands = Utils.getTopIslands();
                return islands.size() > finalI ? NumberFormat.getInstance().format(Math.floor(Utils.getTopIslands().get(finalI).getValue() / IridiumSkyblock.getConfiguration().valuePerLevel)) + "" : "N/A";
            });
        }
    }
}