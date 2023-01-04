package com.example.examplemod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class IronIngot extends Item {
    public IronIngot(){
        super(new Properties().tab(ModGroup.ironGroup));
    }
}
