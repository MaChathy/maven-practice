                **Spring practice project**

this module is about some simple practice of spring .

###### **异常映射**
将异常类型和某个具体的视图关联起来，建立映射关系。好处是可以通过 SpringMVC 框架来帮助我们管理异常。
1. 使用声明式代替编程式来实现异常管理
   
    - 让异常控制和核心业务解耦，二者各自维护，结构性更好
   
2. 使用声明式代替编程式来实现异常管理

   - 整个项目代码风格更加统一、简洁

   - 便于团队成员之间的彼此协作
   
异常处理器类需要使用 @ControllerAdvice 注解标记

区分请求类型

异常处理机制和拦截器机制都面临这样的问题：
![img.png](img.png)

查看请求消息头中是否包含 Ajax 请求独有的特征：

   - Accept 请求消息头：包含 application/json
   
   - X-Requested-With 请求消息头：包含 XMLHttpRequest

两个条件满足一个即可。

###### **拦截器**
在程序中，使用拦截器在请求到达具体 handler 方法前，统一执行检测。

![img_1.png](img_1.png)

拦截器与过滤器的不同点
- 工作平台不同
   - 过滤器工作在 Servlet 容器中
   - 拦截器工作在 SpringMVC 的基础上
- 拦截的范围
   - 过滤器：能够拦截到的最大范围是整个 Web 应用
   - 拦截器：能够拦截到的最大范围是整个 SpringMVC 负责的请求
- IOC 容器支持
   - 过滤器：想得到 IOC 容器需要调用专门的工具方法，是间接的
   - 拦截器：它自己就在 IOC 容器中，所以可以直接从 IOC 容器中装配组件，也就是可以直接得到 IOC 容器的支持
     
**功能需要如果用 SpringMVC 的拦截器能够实现，就不使用过滤器。**

