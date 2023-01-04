package com.example.examplemod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class IronGroup extends ItemGroup {
    public IronGroup(){
        super("iron_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.ironIngot.get());
    }
}
