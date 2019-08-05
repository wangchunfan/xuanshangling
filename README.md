# xuanshangling
发布悬赏，号召更多人帮你搞事情！！

# 服务器端部署

- Redis
- JDK8
- tomcat
- zookeeper

## 安装JDK

1. 解压JDK文件 `tar -zxvf jdk-8u221-linux-x64.tar.gz`
2. 新建目录 `mkdir /usr/java`
3. copy文件： `cp jdk1.8.0_221/  /usr/java/ -rf` 
4. 配置环境变量：`vim /etc/profile` 在文件的最末尾添加
```
export JAVA_HOME=/usr/local/jdk1.8.0_221;
export PATH=$PATH:$JAVA_HOME/bin;
export CLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/jre/lib/rt.jar
```
5. 刷新环境变量：`source /etc/profile`
6. 验证： `java -version`

## 安装Tomcat

- 解压：`tar -zxvf jdk-8u101-linux-x64.tar.gz`
- 创建文件夹：`mkdir /usr/local/java`
- 移动：`mv jdk-8u101-linux-x64/* /usr/local/java`
- 启动： `cd /usr/local/tomcat/bin` `./startup.sh`
- 关闭：`shutdown.sh`
- 添加应用：`cd /usr/local/tomcat/webapps`,将war包放入重启

## 安装redis

- 解压
- 需要gcc环境 `yum install gcc-c++`
- 编译
- 安装 `make install PREFIX=/usr/local/redois`

## 配置https

- 在Tomcat的`conf`目录下：`keytool -genkey -alias 别名 -keyalg RSA -validity 2000 -keystore 名字.keystore`
- 口令密码需要输入，最有一步填写`Y`
- genkey 在用户主目录中创建一个默认文件”.keystore”,还会产生一个mykey的别名，mykey中包含用户的公钥、私钥和证书(在没有指定生成位置的情况下,keystore会存在用户系统默认目录)
- alias 产生别名 每个keystore都关联这一个独一无二的alias，这个alias通常不区分大小写
- keyalg 指定密钥的算法 (如 RSA DSA，默认值为：DSA)
- validity 指定创建的证书有效期多少天(默认 90)
- keystore 指定密钥库的名称(产生的各类信息将不在.keystore文件中)
- 修改`conf/server.xml`文件
```
<Connector port="8080" protocol="HTTP/1.1" SSLEnabled="true"
       maxThreads="150" scheme="https" secure="true"
       clientAuth="false" sslProtocol="TLS" 
       keystoreFile="conf/名字.keystore" keystorePass="密码"/>
```
- 重启Tomcat 使用https访问