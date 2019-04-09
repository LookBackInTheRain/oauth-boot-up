#### OAUTH-BOOT-UP

[OAUTH-BOOT](https://github.com/LookBackInTheRain/oauth-boot) 的升级，spring-security ，spring-security-oauth2 ，string boot 学习

---

#### Current
1. 授权码模式，密码模式，简化模式（未测试），客户端模式（未测试）
2. JWT 
3. 自定义登录页面和授权页面
4. 自定义异常处理

#### Future
1. 短信登录
2. 第三方登录（QQ、微信、微博）
3. 基础管理界面

#### 配置

1. 认证服务配置
```yaml
server:
  port: 8000

spring:
  application:
    name: oauth-boot-service
  # mysql 配置
  datasource:
    username: dev
    password: Sys@gzu123+
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://172.16.2.103:3306/boot?useUnicode=true&characterEncoding=utf-8&useSSL=false
    type: com.alibaba.druid.pool.DruidDataSource
  #redis 配置
  redis:
    host: 172.16.2.104
    port: 6379
    password: Sys@redis123+
    jedis:
      pool:
        max-active: 8 # 连接词最大链接数
        max-wait: -1 # 连接池最大阻塞等待时间（负数代表没有限制）
        max-idle: 8 # 连接池最大空闲连接数
        min-idle: 0 # 连接池最小空闲连接数
    timeout: 10000 # 链接超时时间 （ms）,连接时间小会导致连接超时
  # 模板引擎配置
  thymeleaf:
    prefix: classpath:/views/
    suffix: .html
    cache: false
  mvc:
    throw-exception-if-no-handler-found: true

mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper # mapper 文件路径
  # type-aliases-package: club.yuit.boot.entity
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      id-type: uuid
      db-type: mysql  # 3.0 版本的必须配置 不然无法启动 nested exception is com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Error: GlobalConfigUtils setMetaData Fail !  Cause:java.lang.NullPointerException

boot:
  oauth:
    # token 存储方式，可选配置
    token-store-type: jwt #默认为 memory
    # token签名秘钥，可选配置，默认：OAUTHBOOT@IUY09&098#UIOKNJJ-YUIT.CLUB
    token-signing-key: 123qwe 
    # 登录处理url 可选配置
    login-process-url: /auth/authorize 
```

2. 资源服务配置
```yaml

server:
  port: 9000
#  servlet:
#    context-path: /api/v1

spring:
  application:
    name: oauth-boot-resource
  # mysql 配置，如果token存储方式为jdbc，必须配置
  datasource:
    username: dev
    password: Sys@gzu123+
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://172.16.2.103:3306/boot?useUnicode=true&characterEncoding=utf-8&useSSL=false
    type: com.alibaba.druid.pool.DruidDataSource
  #redis 配置,如果token存储方式为redis，必须配置
  redis:
    host: 172.16.2.104
    port: 6379
    password: Sys@redis123+
    jedis:
      pool:
        max-active: 8 # 连接词最大链接数
        max-wait: -1 # 连接池最大阻塞等待时间（负数代表没有限制）
        max-idle: 8 # 连接池最大空闲连接数
        min-idle: 0 # 连接池最小空闲连接数
    timeout: 10000 # 链接超时时间 （ms）,连接时间小会导致连接超时

  mvc:
    throw-exception-if-no-handler-found: true

boot:
  oauth:
    token-store-type: jwt
    token-signing-key: 123123

```

#### 授权码模式
    
   1. 请求授权 http://ip:port/oauth/authorize?response_type=code&client_id=client&client_secret=123qwe&redirect_uri=http://localhost:9000&scope=select
   2. 如果没有登录会跳转到登录页面，登录后跳转到授权页面（是否会跳转到授权页面取决于是否将isAutoApprove字段的值 ）
   3. 授权后得到一个授权码，拿着授权码即可申请token

#### 密码模式
   没有配置允许客户端表单登录的，将客户端id和密码base64编码放入请求头中，根据oauth2协议规定的密码模式正确填写参数即可申请token

#### 依赖

|框架/类库/数据库|   版本号 |
|--|--|
|java|11（Mac）/ 8（Win10）|
| spring-boot | 2.1.3.RELEASE |
|spring-security|5.1.4.RELEASE |
|spring-security-oauth2-autoconfigure|2.1.3.RELEASE|
|mybatis-plus|3.1.0|
|数据库连接池（druid）|1.1.14|
|swagger-ui|2.9.2|
|hibernate-validator|6.0.13.Final|
|MySQL|5.7.22 MySQL Community Server|
|Redis|4.0.10|

#### 项目效果
1. 自定义登录和授权页面效果图
![自定义登录和授权页面效果图](https://img-blog.csdnimg.cn/20181102173054952.gif)

#### 建表语句在doc/table.sql中
    
   相关的测试数据也在这个sql文件中，加密的密码统一为123qwe
   
#### 注

   请使用上述依赖所规定的版本

> 技术交流群 QQ: 931534231
> 单纯的技术交流


