package com.example.examplemod;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IronApple extends Item {
    private static Food food=(new Food.Builder())
            .nutrition(20)
            .saturationMod(10)
            .effect(()->new EffectInstance(Effects.POISON,3*20),1.0F)
            .build();
    public IronApple(){
        super(new Properties().food(food).tab(ModGroup.ironGroup));
    }
}