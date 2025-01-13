package net.auwate.tutorialmod.item;

import net.auwate.tutorialmod.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MODID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register(
            "alexandrite",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("tutorialmod:alexandrite"))))
    );

    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register(
            "raw_alexandrite",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("tutorialmod:raw_alexandrite"))))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
