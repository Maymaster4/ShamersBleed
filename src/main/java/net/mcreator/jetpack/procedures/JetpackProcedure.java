package net.mcreator.jetpack.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.jetpack.JetpackModElements;
import net.mcreator.jetpack.JetpackMod;

import java.util.Random;
import java.util.Map;

@JetpackModElements.ModElement.Tag
public class JetpackProcedure extends JetpackModElements.ModElement {
	public JetpackProcedure(JetpackModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JetpackMod.LOGGER.warn("Failed to load dependency entity for procedure Jetpack!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				JetpackMod.LOGGER.warn("Failed to load dependency itemstack for procedure Jetpack!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				JetpackMod.LOGGER.warn("Failed to load dependency x for procedure Jetpack!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				JetpackMod.LOGGER.warn("Failed to load dependency y for procedure Jetpack!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				JetpackMod.LOGGER.warn("Failed to load dependency z for procedure Jetpack!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				JetpackMod.LOGGER.warn("Failed to load dependency world for procedure Jetpack!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity.isSneaking())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 10, (int) 9, (false), (false)));
			if (((((itemstack)).getDamage()) <= 9500)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Extra Height! More Energy Consumed!!"), (true));
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Rockets About to burn!"), (true));
				}
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, (x + 1), (y - 2), z, (int) 2, 0, 1, 0, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, (x - 1), (y - 2), z, (int) 2, 0, 1, 0, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, x, (y - 2), (z - 1), (int) 2, 0, 1, 0, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FIREWORK, x, (y - 2), (z + 1), (int) 2, 0, 1, 0, 1);
			}
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 3, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		} else {
			if (((((world.getBlockState(new BlockPos((int) x, (int) (y - 6), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 6), (int) z))).getBlock() == Blocks.VOID_AIR.getDefaultState()
							.getBlock())) == (false))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 1, (int) 3, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 30, (int) 0, (false), (false)));
				{
					ItemStack _ist = (itemstack);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, (y - 2), z, (int) 10, 0, 1, 0, 0.1);
				}
				if (((((itemstack)).getDamage()) <= 9500)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Ground Hovering."), (true));
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Rockets About to burn!"), (true));
					}
				}
			} else {
				if (((((itemstack)).getDamage()) <= 9500)) {
					if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 7), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
							|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 7), (int) z))).getBlock() == Blocks.VOID_AIR.getDefaultState()
									.getBlock()))) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Auto Descending..."), (true));
						}
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Rockets About to burn!"), (true));
					}
				}
			}
		}
	}
}
