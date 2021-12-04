window.app={
    //和后段枚举一一对应
    CONNECT: 1,    // "第一次(或重连)初始化连接"
    /**
     * 和后端的ChatMsg 聊天模型对象保持一致
     * @param {Object} senderId
     * @param {Object} receiverId
     * @param {Object} msg
     * @param {Object} msgId
     */
    ChatMsg: function(senderId,receiverId,msg,msgId){
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.msg = msg;
        this.msgId = msgId;
    },
    /**构建消息DataContent模型对象
     * @param {Object} action
     * @param {Object} chatMsg
     * @param {Object} extand
     */
    DataContent: function(action,chatMsg,extand){
        this.action = action;
        this.chatMsg = chatMsg;
        this.extand = extand;
    },
}