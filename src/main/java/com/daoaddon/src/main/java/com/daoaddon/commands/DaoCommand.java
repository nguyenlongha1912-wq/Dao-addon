package com.daoaddon.commands;

import com.daoaddon.modules.AutoClear3x3;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.util.math.BlockPos;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static meteordevelopment.meteorclient.MeteorClient.mc;

public class DaoCommand extends Command {
    public DaoCommand() {
        super("dao", "Đặt vùng đào cho AutoClear3x3.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("pos1").executes(ctx -> {
            AutoClear3x3.pos1 = mc.player.getBlockPos();
            AutoClear3x3.resetState();
            ChatUtils.info("pos1 = " + fmt(AutoClear3x3.pos1));
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("pos2").executes(ctx -> {
            AutoClear3x3.pos2 = mc.player.getBlockPos();
            AutoClear3x3.resetState();
            ChatUtils.info("pos2 = " + fmt(AutoClear3x3.pos2));
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("reset").executes(ctx -> {
            AutoClear3x3.resetState();
            ChatUtils.info("Đã xóa tiến độ.");
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("info").executes(ctx -> {
            ChatUtils.info("pos1 = " + fmt(AutoClear3x3.pos1) + ", pos2 = " + fmt(AutoClear3x3.pos2));
            return SINGLE_SUCCESS;
        }));
    }

    private static String fmt(BlockPos p) {
        return p == null ? "chưa đặt" : p.getX() + " " + p.getY() + " " + p.getZ();
    }
}
