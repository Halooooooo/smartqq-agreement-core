package com.thankjava.wqq.test.qq;

import com.thankjava.wqq.SmartQQClient;
import com.thankjava.wqq.entity.msg.PollMsg;
import com.thankjava.wqq.entity.msg.SendMsg;

public class NotifyHandler {

    private static SmartQQClient smartQQClient;

    public NotifyHandler(SmartQQClient smartQQClient) {
        NotifyHandler.smartQQClient = smartQQClient;
    }

    // 指定不同类型的不同msg回复
    public void hander(PollMsg pollMsg) {
        switch (pollMsg.getMsgType()) {
            case message:
                smartQQClient.sendMsg(new SendMsg(pollMsg, "I Have Got Your Msg: friend"));
                break;
            case group_message:
                smartQQClient.sendMsg(new SendMsg(pollMsg, "I Have Got Your Msg: group"));
                break;
            case discu_message:
                smartQQClient.sendMsg(new SendMsg(pollMsg, "I Have Got Your Msg: discu"));
                break;
        }
    }


    // sendMsg 接口能通过pollMsg得到msg的类型，然后自动回复该类型的msg
//	public void handler(PollMsg pollMsg){
//		SMART_QQ_CLIENT.sendMsg(new SendMsg(pollMsg, "I Have Got Your Msg"));
//	}


}
