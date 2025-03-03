## slg2d-avatar

### 性能验证建议
- 压力测试：使用Gatling或JMeter模拟万级连接，监控线程数和内存占用。
- 监控指标：通过Akka的MetricsExtension跟踪Actor邮箱大小和消息处理延迟。
- JVM参数调优：增加堆外内存（-XX:MaxDirectMemorySize）以支持Netty的Direct Buffer。