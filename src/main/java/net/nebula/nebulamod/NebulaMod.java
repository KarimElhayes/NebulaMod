package net.nebula.nebulamod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.recipe.Ingredient;

public class NebulaMod implements ModInitializer {
    public static final String MOD_ID = "nebula";

    public static final Block NEBULA_ORE = new Block(AbstractBlock.Settings.of(Material.STONE)
            .strength(3.0f, 3.0f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
            
    public static final Item NEBULA_INGOT = new Item(new Item.Settings());

    public static final ToolMaterial NEBULA_TOOL_MATERIAL = new ToolMaterial() {
        @Override public int getDurability() { return 2500; }
        @Override public float getMiningSpeedMultiplier() { return 9.0F; }
        @Override public float getAttackDamage() { return 4.0F; }
        @Override public int getMiningLevel() { return 4; } 
        @Override public int getEnchantability() { return 15; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(NEBULA_INGOT); }
    };

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "nebula_ore"), NEBULA_ORE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_ore"), new BlockItem(NEBULA_ORE, new Item.Settings()));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_ingot"), NEBULA_INGOT);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_sword"), 
            new SwordItem(NEBULA_TOOL_MATERIAL, 3, -2.4F, new Item.Settings()));
        
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_pickaxe"), 
            new PickaxeItem(NEBULA_TOOL_MATERIAL, 1, -2.8F, new Item.Settings()));
        
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_axe"), 
            new AxeItem(NEBULA_TOOL_MATERIAL, 6.0F, -3.0F, new Item.Settings()));
        
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_shovel"), 
            new ShovelItem(NEBULA_TOOL_MATERIAL, 1.5F, -3.0F, new Item.Settings()));
        
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_hoe"), 
            new HoeItem(NEBULA_TOOL_MATERIAL, -3, 0.0F, new Item.Settings()));
    }
}