window.app={
    //和后段枚举一一对应
    CONNECT: 1,    // "第一次(或重连)初始化连接"
    CHAT:2,//聊天消息
    SIGNED: 3,     // "消息签收"),
    /**
     * 和后端的ChatMsg 聊天模型对象保持一致
     * @param {Object} senderId
     * @param {Object} receiverId
     * @param {Object} msg
     * @param {Object} msgId
     */
    ChatMsgParam: function(senderId,receiverId,msg,msgId){
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.msg = msg;
        this.msgId = msgId;
    },
    /**构建消息DataContent模型对象
     * @param {Object} action
     * @param {Object} chatMsgParam
     * @param {Object} extand
     */
    DataContent: function(action,chatMsgParam,extand){
        this.action = action;
        this.chatMsgParam = chatMsgParam;
        this.extand = extand;
    },
}