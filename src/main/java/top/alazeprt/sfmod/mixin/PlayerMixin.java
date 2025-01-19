package top.alazeprt.sfmod.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import top.alazeprt.sfmod.SpringFestivalMod;
import top.alazeprt.sfmod.entity.custom.AndyLauEntity;

@Mixin(PlayerEntity.class)
public class PlayerMixin {

    /**
     * @author alazeprt
     * @reason prevent vanilla music from playing when Spring Festival's musics are playing
     */
    @Overwrite
    public void playSound(SoundEvent sound, float volume, float pitch) {
        PlayerEntity thisPlayer = (PlayerEntity) (Object) this;
        System.out.println("PlayerMixin playSound called");
        if (AndyLauEntity.map.containsKey(thisPlayer.getUuidAsString()) && sound.getId().getPath().contains("music") &&
                sound != SpringFestivalMod.ANDY_LAU_MUSIC) {
            return;
        }
        thisPlayer.getWorld().playSound(thisPlayer, thisPlayer.getX(), thisPlayer.getY(), thisPlayer.getZ(), sound, thisPlayer.getSoundCategory(), volume, pitch);
    }
}
