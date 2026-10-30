package com.daoaddon;

import com.daoaddon.commands.DaoCommand;
import com.daoaddon.modules.AutoClear3x3;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.modules.Modules;

public class DaoAddon extends MeteorAddon {
    @Override
    public void onInitialize() {
        Modules.get().add(new AutoClear3x3());
        Commands.add(new DaoCommand());
    }

    @Override
    public void onRegisterCategories() {
    }

    @Override
    public String getPackage() {
        return "com.daoaddon";
    }
}
