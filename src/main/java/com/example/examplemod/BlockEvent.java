package com.example.examplemod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class BlockEvent {
    @SubscribeEvent
    public void blockBreak(net.minecraftforge.event.world.BlockEvent.BreakEvent event){
    }
}
