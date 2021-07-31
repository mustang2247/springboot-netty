# Author: Mustang
# 基础镜像使用java,alpines表示最小镜像的Linux系统 docker pull openjdk:11.0.12-jdk-oracle
FROM openjdk:11.0.12-jdk-oracle

# 作者
MAINTAINER Mustang <mustang2247@gmail.com>

ARG procname
ARG packagefile
#ARG exposeport

#ENV PORT_TO_EXPOSE=${exposeport}
ENV PROC_NAME=${procname}

WORKDIR /opt/${procname}
#ADD $packagefile /opt/${procname}/
#RUN mkdir -p /opt/${procname}/conf
VOLUME ["/opt/$PROC_NAME"]

ARG JAR_FILE=target/*.jar
# 将jar包添加到容器中并更名为app.jar
COPY ${JAR_FILE} app.jar

# 暴露多个端口
EXPOSE 8888 9999

#设置镜像的时区,避免出现8小时的误差
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#定义jvm参数变量
ENV JAVA_OPTS=""
#ENV JAVA_OPTS="--spring.profiles.active=prod"

# 运行jar包
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar --spring.profiles.active=prod" ]
#ENTRYPOINT ["java", "$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=dev"]
#CMD ["-Xms512m", "-Xmx2500m"]
