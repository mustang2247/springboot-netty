package com.mustang.netty.protocol.message;

import lombok.Data;

/**
 * 包
 *
 */
@Data
public abstract class Packet {
    /**
     * 版本
     */
    private Byte version = 1;

    public abstract Byte getCommand();
}
