# JMS
  ConnectionFactory ----> Connection ----> Session ---> MessageProducer(MessageConsumer)

# spring 集成JMS连接ActiveMQ
 ConnectionFactory 管理连接的连接工厂
    连接池 。实现SingleConnectionFactory 和 CachingConnectionFactory（新增缓存回话）。
 JmsTemplate 用于发送和接受信息的模版类
    线程安全
 MessageListerner 消息监听器
    实现onMessage 方法