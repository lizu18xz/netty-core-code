package com.imooc.netty.core.$26.common.msg;

import com.imooc.netty.core.$26.common.protocol.MahjongResponse;
import lombok.Data;

@Data
public class EnterTableResponse implements MahjongResponse {
    private boolean result;
    private String msg;
}
