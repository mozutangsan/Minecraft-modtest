package com.example.examplemod;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IronApple extends Item {
    private static final Food food= new Food.Builder().nutrition(20).saturationMod(10).saturationMod(0.3F).effect(()->new EffectInstance(Effects.DAMAGE_RESISTANCE, 6000, 0), 1.0F).effect(()-> new EffectInstance(Effects.FIRE_RESISTANCE,6000,0),1.0F).build();
    public IronApple(){
        super(new Properties().tab(ItemGroup.TAB_FOOD).food(food));
    }
}
