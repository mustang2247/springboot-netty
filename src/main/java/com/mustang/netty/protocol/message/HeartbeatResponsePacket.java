package com.mustang.netty.protocol.message;

import com.mustang.netty.protocol.message.command.Command;

/**
 * 心跳回复
 */
public class HeartbeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }
}
