package com.example.examplemod;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class IronSword extends SwordItem {
    public IronSword(){
        super(ModIItemTier.IRON,3,-2.4F,new Item.Properties().tab(ModGroup.ironGroup));
    }
}
