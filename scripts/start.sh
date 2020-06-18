#!/bin/bash
#CPU_COUNT=`cat /proc/cpuinfo | grep processor | wc -l`

MEM_OPTS="-server -XX:+UseG1GC -Xms2g -Xmx2g -Dfile.encoding=utf-8 -XX:MetaspaceSize=512M -XX:MaxMetaspaceSize=512M"


echo "classpath: "$CLASSPATH
echo "内存参数: "$MEM_OPTS

# 打印到startup.log
if [ ! -d logs ]; then  mkdir logs  ; fi
java $MEM_OPTS -Dlogging.config=file:config/log4j2.xml -jar lib/wanxin-anbo-proxy-1.0.0-SNAPSHOT.jar >> logs/start.out 2>&1 &
pid=$!
echo $pid>.pid
echo "ad-web 启动成功"
