<<<<<<< HEAD
#综合的springboot项目
##写在前面
>这个文档会记录这个项目使用到的技术如何整合 springboot 以及基本使用,是本人 springboot 的整合复习,如果对你有帮助,留个 star 吧

##git的使用
>创建远程仓库
>
>克隆远程仓库到本地
>```shell script
>git clone 远程仓库地址
>```
>提交代码
>```shell script
>git add . #提交代码到暂存区
>git commit -m 提交说明 #提交代码到本地仓库
>git push 远程仓库地址 提交分支 #提交代码到远程仓库
>```
>不小心提交了多余的文件
>```shell script
>git rm -r --cached 文件名
>#删除指定文件后再提交代码
>#记得编辑 .gitignore 文件
>```
>
##后台基础配置

>添加 swagger-ui配置和filter
>引入jwt无状态维护用户的登录状态
=======
# xinli
心理沙盘项目
[master db72b1a] 提交项目
 65 files changed, 4933 insertions(+), 1 deletion(-)
 create mode 100644 .gitignore
 create mode 100644 pom.xml
 create mode 100644 src/main/java/com/xinli/xinli/XinliApplication.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbAddcontactfriendEntity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbAdvisoryEntity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbApplicationEntity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbAuthorityEntity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbCatalogV1Entity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbCatalogV2Entity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbMasterEntity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbModelEntity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/TbUserEntity.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/other/TbAllAdvisory.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/other/TbAllCatalog.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/other/TbApplicationAll.java
 create mode 100644 src/main/java/com/xinli/xinli/bean/other/TbApplicationResult.java
 create mode 100644 src/main/java/com/xinli/xinli/conf/FilterConfig.java
 create mode 100644 src/main/java/com/xinli/xinli/conf/SwaggerConfig.java
 create mode 100644 src/main/java/com/xinli/xinli/conf/WebSocketAutoConfig.java
 create mode 100644 src/main/java/com/xinli/xinli/controller/AdminController.java
 create mode 100644 src/main/java/com/xinli/xinli/controller/AuthorityController.java
 create mode 100644 src/main/java/com/xinli/xinli/controller/InfoController.java
 create mode 100644 src/main/java/com/xinli/xinli/controller/MasterController.java
 create mode 100644 src/main/java/com/xinli/xinli/controller/ModelController.java
 create mode 100644 src/main/java/com/xinli/xinli/controller/UserController.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/TbAdvisoryDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/TbApplicationDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/TbAuthorityDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/TbCatalogV1Dao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/TbCatalogV2Dao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/TbMasterDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/TbModelDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/TbUserDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/other/TbAllAdvisoryDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/other/TbAllCatalogDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/other/TbApplicationAllDao.java
 create mode 100644 src/main/java/com/xinli/xinli/dao/other/TbApplicationResultDao.java
 create mode 100644 src/main/java/com/xinli/xinli/filter/LoginHandlerInterceptor.java
 create mode 100644 src/main/java/com/xinli/xinli/request/MasterLoginRequest.java
 create mode 100644 src/main/java/com/xinli/xinli/response/CommonResponse.java
 create mode 100644 src/main/java/com/xinli/xinli/response/data/CataLog.java
 create mode 100644 src/main/java/com/xinli/xinli/service/AdminService.java
 create mode 100644 src/main/java/com/xinli/xinli/service/InfoService.java
 create mode 100644 src/main/java/com/xinli/xinli/service/MasterService.java
 create mode 100644 src/main/java/com/xinli/xinli/service/ModelService.java
 create mode 100644 src/main/java/com/xinli/xinli/service/UserService.java
 create mode 100644 src/main/java/com/xinli/xinli/service/impl/AdminServiceImpl.java
 create mode 100644 src/main/java/com/xinli/xinli/service/impl/InfoServiceImpl.java
 create mode 100644 src/main/java/com/xinli/xinli/service/impl/MasterServiceImpl.java
 create mode 100644 src/main/java/com/xinli/xinli/service/impl/ModelServiceImpl.java
 create mode 100644 src/main/java/com/xinli/xinli/service/impl/UserServiceImpl.java
 create mode 100644 src/main/java/com/xinli/xinli/util/SnowflakeIdUtils.java
 create mode 100644 src/main/java/com/xinli/xinli/util/TimeUtil.java
 create mode 100644 src/main/java/com/xinli/xinli/util/TokenUtil.java
 create mode 100644 src/main/java/com/xinli/xinli/websocket/NewWebsocket.java
 create mode 100644 src/main/java/com/xinli/xinli/websocket/bean/Hotel.java
 create mode 100644 src/main/java/com/xinli/xinli/websocket/bean/Location.java
 create mode 100644 src/main/java/com/xinli/xinli/websocket/bean/Members.java
 create mode 100644 src/main/java/com/xinli/xinli/websocket/bean/Operating.java
 create mode 100644 src/main/java/com/xinli/xinli/websocket/bean/Room.java
 create mode 100644 src/main/java/com/xinli/xinli/websocket/bean/request/WebsocketRequestMsg.java
 create mode 100644 src/main/resources/WebSocketServer.java
 create mode 100644 src/main/resources/application.properties
 create mode 100644 src/test/java/com/xinli/xinli/XinliApplicationTests.java
>>>>>>> 7cad11a70bdf5eaf8151280acf93ff968197a7ba
