# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.6/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.6/maven-plugin/build-image.html)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

第1周
□ 第1天：项目启动成功
□ 第2天：连上MySQL
□ 第3天：User实体+Mapper
□ 第4天：注册接口
□ 第5天：登录接口+JWT
□ 周末：Postman测通注册+登录

第2周
□ 第6天：Fiction实体+Mapper
□ 第7天：发布文章
□ 第8天：文章列表（分页）
□ 第9天：文章详情
□ 第10天：删除自己的文章
□ 周末：发→列→详→删 全通

第3周
□ 第11天：Comment实体+Mapper
□ 第12天：发表评论
□ 第13天：评论列表
□ 第14天：LikeRecord表+Mapper
□ 第15天：点赞/取消点赞
□ 周末：完整闭环测试