### 使用AOP的注意事项|坑

1. 不宜把重要的业务逻辑放到aop中处理，容易被忽略

2. 无法拦截static final方法、private方法

3. 无法拦截内部方法调用