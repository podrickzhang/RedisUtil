# RedisUtil


RedisUtil为redis的主要工具类，在controller中可以通过调用RedisService来操作redis,也可以用过RedisUtil来操作redis，这里我建议使用RedisUtil.<br>

获取key的url:<br>
`http://localhost:8080/user/get?key=a`
<br>

添加实体对象到redis中的url:<br>
`http://localhost:8080/user/addUser?userName=rosam&password=root`
<br>

将key为userName,value为password的值添加到redis中，反复添加同一个key,会覆盖之前的value;<br>
`http://localhost:8080/user/addStr?userName=hansahns&password=123`
<br>

springboot整合redis
pom.xml中的依赖为
```java
<!-- 整合redis -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
```

在application.properties进行redis的相关配置<br>
这里的是基于springboot进行的配置，所以开头有spring，如果不是基于springboot，那么你可以写个redisConfig的配置类,再将配置中的内容注入到redisConfig
```java
#使用的db
spring.redis.database=1
#连接
spring.redis.host=127.0.0.1
#端口
spring.redis.port=6379
#超时时间
spring.redis.timeout=5000
```
