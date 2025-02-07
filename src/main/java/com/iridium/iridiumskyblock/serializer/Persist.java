package com.iridium.iridiumskyblock.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.serializer.typeadapter.EnumTypeAdapter;
import com.iridium.iridiumskyblock.serializer.typeadapter.InventoryTypeAdapter;
import com.iridium.iridiumskyblock.serializer.typeadapter.LocationTypeAdapter;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class Persist {


    private final Gson gson = buildGson().create();

    public static String getName(Class<?> clazz) {
        return clazz.getSimpleName().toLowerCase();
    }

    // ------------------------------------------------------------ //
    // GET NAME - What should we call this type of object?
    // ------------------------------------------------------------ //

    public static String getName(Object o) {
        return getName(o.getClass());
    }

    public static String getName(Type type) {
        return getName(type.getClass());
    }

    private GsonBuilder buildGson() {
        return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping()
                .enableComplexMapKeySerialization()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.VOLATILE)
                .registerTypeAdapter(Location.class, new LocationTypeAdapter())
                .registerTypeAdapter(Inventory.class, new InventoryTypeAdapter())
                .registerTypeAdapterFactory(EnumTypeAdapter.ENUM_FACTORY);
    }

    // ------------------------------------------------------------ //
    // GET FILE - In which file would we like to store this object?
    // ------------------------------------------------------------ //

    public File getFile(String name) {
        return new File(IridiumSkyblock.getInstance().getDataFolder(), name + ".json");
    }

    public File getFile(Class<?> clazz) {
        return getFile(getName(clazz));
    }

    public File getFile(Object obj) {
        return getFile(getName(obj));
    }

    // SAVE

    public boolean save(Object instance) {
        return save(instance, getFile(instance));
    }

    public boolean save(Object instance, File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                IridiumSkyblock.getInstance().sendErrorMessage(e);
            }
        }
        return DiscUtil.writeCatch(file, gson.toJson(instance), true);
    }

    // LOAD BY CLASS

    public <T> T load(Class<T> clazz) {
        return load(clazz, getFile(clazz));
    }

    public <T> T load(Class<T> clazz, File file) {
        String content = DiscUtil.readCatch(file);
        if (content == null) {
            return null;
        }

        try {
            return gson.fromJson(content, clazz);
        } catch (Exception ex) {    // output the error message rather than full stack trace; error parsing the file, most likely
            IridiumSkyblock.getInstance().getLogger().warning(ex.getMessage());
        }

        return null;
    }
}