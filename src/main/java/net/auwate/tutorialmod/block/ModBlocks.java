package net.auwate.tutorialmod.block;

import net.auwate.tutorialmod.TutorialMod;
import net.auwate.tutorialmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MODID);

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
                    .setId(
                            ResourceKey.create(
                                    Registries.BLOCK,
                                    ResourceLocation.parse(TutorialMod.MODID + ":alexandrite_block")
                            )
                    )
            )
    );

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
                    .setId(
                            ResourceKey.create(
                                    Registries.BLOCK,
                                    ResourceLocation.parse(TutorialMod.MODID + ":raw_alexandrite_block")
                            )
                    )
            )
    );

    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of()
                            .strength(3f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)
                            .setId(ResourceKey.create(
                                    Registries.BLOCK,
                                    ResourceLocation.parse(TutorialMod.MODID + ":alexandrite_ore")
                            ))

            )
    );

    public static final RegistryObject<Block> DEEPSLATE_ALEXANDRITE_ORE = registerBlock(
            "deepslate_alexandrite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(4, 6),
                    BlockBehaviour.Properties.of()
                            .strength(5f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE)
                            .setId(ResourceKey.create(
                                    Registries.BLOCK,
                                    ResourceLocation.parse(
                                            TutorialMod.MODID + ":deepslate_alexandrite_ore"
                                    )
                            ))
            )
    );

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {

        RegistryObject<T> block = BLOCKS.register(
                name,
                blockSupplier
        );

        registerBlockAsItem(name, block);

        return block;

    }

    private static <T extends Block> void registerBlockAsItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(
                name,
                () -> new BlockItem(
                        block.get(),
                        new Item.Properties().setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        ResourceLocation.parse(TutorialMod.MODID + ":" + name)
                                )
                        )
                )
        );
    }

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
