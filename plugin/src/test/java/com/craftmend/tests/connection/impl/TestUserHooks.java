package com.craftmend.tests.connection.impl;

import com.craftmend.openaudiomc.generic.logging.OpenAudioLogger;
import com.craftmend.openaudiomc.generic.proxy.interfaces.UserHooks;
import com.craftmend.openaudiomc.generic.proxy.messages.StandardPacket;
import com.craftmend.openaudiomc.generic.proxy.models.ProxyNode;
import com.craftmend.openaudiomc.generic.user.User;
import com.craftmend.openaudiomc.generic.user.adapters.CommandSenderUserAdapter;
import com.craftmend.tests.connection.ConnectionTest;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class TestUserHooks implements UserHooks {

    public static Map<UUID, User> fakeUsers = new HashMap<>();

    public static void createFakeUser(UUID uuid, String name) {
        fakeUsers.put(uuid, new TestUser(false, uuid, name));
    }

    @Override
    public Collection<ProxyNode> getNodes() {
        return Collections.emptyList();
    }

    @Override
    public Collection<User> getOnlineUsers() {
        return fakeUsers.values();
    }

    @Override
    public void sendPacket(User user, StandardPacket packet) {
        // nothing
    }

    @Override
    public User byUuid(UUID uuid) {
        return fakeUsers.get(uuid);
    }

    @Override
    public User fromCommandSender(CommandSender commandSender) {
        return new CommandSenderUserAdapter(commandSender);
    }

}
