package com.example.examplemod;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class ModIItemTier {
    public static IItemTier IRON=new IItemTier() {
        @Override
        public int getUses() {
            return 2000;
        }

        @Override
        public float getSpeed() {
            return 10.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 4.0F;
        }

        @Override
        public int getLevel() {
            return 3;
        }

        @Override
        public int getEnchantmentValue() {
            return 30;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ItemRegistry.ironIngot.get());
        }
    };
}

