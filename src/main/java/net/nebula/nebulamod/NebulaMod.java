package net.nebula.nebulamod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NebulaMod implements ModInitializer {
    public static final String MOD_ID = "nebulamod";

    public static final ToolMaterial NEBULA_TOOL_MATERIAL = new ToolMaterial() {
        @Override public int getDurability() { return 1561; }
        @Override public float getMiningSpeedMultiplier() { return 8.0F; }
        @Override public float getAttackDamage() { return 3.0F; }
        @Override public int getMiningLevel() { return 3; }
        @Override public int getEnchantability() { return 10; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.EMPTY; }
    };

    public static final Item NEBULA_SWORD = new SwordItem(NEBULA_TOOL_MATERIAL, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item NEBULA_PICKAXE = new ModPickaxeItem(NEBULA_TOOL_MATERIAL, 1, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item NEBULA_SHOVEL = new ModShovelItem(NEBULA_TOOL_MATERIAL, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item NEBULA_AXE = new ModAxeItem(NEBULA_TOOL_MATERIAL, 6.0F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item NEBULA_HOE = new ModHoeItem(NEBULA_TOOL_MATERIAL, -3, 0.0F, new Item.Settings().group(ItemGroup.TOOLS));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_sword"), NEBULA_SWORD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_pickaxe"), NEBULA_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_shovel"), NEBULA_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_axe"), NEBULA_AXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "nebula_hoe"), NEBULA_HOE);
    }

    public static class ModPickaxeItem extends PickaxeItem {
        public ModPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class ModShovelItem extends ShovelItem {
        public ModShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class ModAxeItem extends AxeItem {
        public ModAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class ModHoeItem extends HoeItem {
        public ModHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
}
