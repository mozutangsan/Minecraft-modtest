package com.example.examplemod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;

public class IronPickaxe extends PickaxeItem {
    public IronPickaxe(){
        super(ModIItemTier.IRON,0,2.0F,new Properties().tab(ItemGroup.TAB_TOOLS));
    }
}