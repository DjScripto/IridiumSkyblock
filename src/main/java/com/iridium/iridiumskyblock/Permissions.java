package com.iridium.iridiumskyblock;

public class Permissions {


    public boolean breakBlocks;
    public boolean placeBlocks;
    public boolean interact;
    public boolean kickMembers;
    public boolean inviteMembers;
    public boolean regen;
    public boolean islandprivate;
    public boolean promote;
    public boolean demote;
    public boolean useNetherPortal;
    public boolean useWarps;
    public boolean coop;
    public boolean withdrawBank;
    public boolean killMobs;

    public Permissions(boolean breakBlocks, boolean placeBlocks, boolean interact, boolean kickMembers, boolean inviteMembers, boolean regen, boolean islandprivate, boolean promote, boolean demote, boolean useNetherPortal, boolean useWarps, boolean coop, boolean withdrawBank, boolean killMobs) {
        this.breakBlocks = breakBlocks;
        this.placeBlocks = placeBlocks;
        this.interact = interact;
        this.kickMembers = kickMembers;
        this.inviteMembers = inviteMembers;
        this.regen = regen;
        this.islandprivate = islandprivate;
        this.promote = promote;
        this.demote = demote;
        this.useNetherPortal = useNetherPortal;
        this.useWarps = useWarps;
        this.coop = coop;
        this.withdrawBank = withdrawBank;
        this.killMobs = killMobs;
    }

    public Permissions() {
        breakBlocks = true;
        placeBlocks = true;
        interact = true;
        kickMembers = true;
        inviteMembers = true;
        regen = true;
        islandprivate = true;
        promote = true;
        demote = true;
        useNetherPortal = true;
        useWarps = true;
        coop = true;
        withdrawBank = true;
        killMobs = true;
    }
}