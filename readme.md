# Vert.x

Vert.x,构建基于jvm的响应式服务

## 开始

该git仓库中通过不同的demo分支将程序划分为几个状态,vertx-sample-1分支,vertx-sample-2分支 ...

分支内容逐步丰富,逐步深入Vert.x

深入了解参见[vert.x官方文档](https://vertx.io/docs/)

### 准备

必备:

- git环境(win下通常会在安装git的时候附加安装bash环境,除非你是linuxOS)

- jdk1.8版本或以上版本
- IDE上的lombok插件,lombok介绍安装详见[lombok安装](http://selton.cn/lombok.html)

可选:

- 一个IDE,可以是IDEA,可以是Eclipse,当然也可以是vscode或者vi

> 提示: 可以选择不使用lombok插件,条件是在所有的项目的类中包含@Data或者@Tostring(callsuper = true)的类中,去掉这两个注解,@Data的类,需要手动加入所有类属性的get,set方法,以及无参构造器;@Tostring(callsuper = true)的类中,需要覆写Tostring方法,如果继承自某一个类,记得调用super.tostring()

### 安装

在Bash中输入git命令以得到工程,当然你也可以通过直接在当前页面下载zip或者wget获取

```
git clone https://github.com/seltonGitHub/vertx.git
```

进入该目录下,切换到demo程序的分支

```
git checkout vertx-sample-1
```

## 简单测试

让我们启动程序并进行简单的测试

从git上取得代码后,切入到主目录下,编译整个项目

````
mvn clean install
````

然后切入到vertx-api目录下,使用maven assemby命令得到可运行jar

````
mvn clean package assembly:single
````

这样就得到了一个这种格式的jar包=>vertx-api-${版本号}_${年月日}-jar-with-dependencies.jar

````
java -jar -DappConfigPath=/配置文件位置 jar包名称
````

启动成功在输出日志的控制台的最下方可以看到日志

````
17:19:48.610 [vert.x-eventloop-thread-0] INFO  pers.selton.vertx.datasearch.ApiVerticle - Server started on port 8080
17:19:48.611 [vert.x-eventloop-thread-1] INFO  pers.selton.vertx.datasearch.ApiLaunch - Deployment Verticle success. id [2671b50d-f10b-4b61-b868-c486cefe6bdd]
````

配置文件才用typesafe配置,目前配置为服务占用的端口号,为8080

接着访问其中的一个接口

浏览器或者insomnia或者是postman

访问localhost:8080/user/id/333,浏览器默认是get请求,insomnia或者postman一样是get请求

后台服务消息

````
17:22:00.041 [vert.x-eventloop-thread-0] INFO  pers.selton.vertx.service.impl.UserServiceImpl - user message get User(super=BaseEntity(id=333), name=testUserGet333, age=333)
````

## 发布

在发布环境部署[准备工作](#准备),在项目的顶级目录下编译以得到发布服务包

````shell
mvn clean install
````

将该jar包和vertx-api目录下的conf目录组装为tar.gz即可交付

## 构建

* [Maven](https://maven.apache.org/) - 依赖管理

## 贡献

贡献文件未记录

## 版本

目前未完善,计划之后完善版本管理,类似SemVer的版本控制.

## 作者

* **Selton.zhao** - *初始化工作* - [Selton Blog](http://selton.cn/)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## 证书

该项目基于GPL开源协议 - 具体参见 [LICENSE.md](LICENSE.md)

## 声明

* 来源于公司框架的熟悉,记录学习vert.x的点点滴滴

