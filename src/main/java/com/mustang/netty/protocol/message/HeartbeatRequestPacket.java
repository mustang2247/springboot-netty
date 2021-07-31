package com.mustang.netty.protocol.message;

import com.mustang.netty.protocol.message.command.Command;
import lombok.Data;

@Data
public class HeartbeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_REQUEST;
    }
}
