#!/bin/bash
#CPU_COUNT=`cat /proc/cpuinfo | grep processor | wc -l`

MEM_OPTS="-server -XX:+UseG1GC -Xms2g -Xmx2g -Dfile.encoding=utf-8 -XX:MetaspaceSize=512M -XX:MaxMetaspaceSize=512M"


echo "classpath: "$CLASSPATH
echo "内存参数: "$MEM_OPTS


nohup java $MEM_OPTS -jar lib/wanxin-anbo-proxy-1.0.0-SNAPSHOT.jar --spring.profiles.active=dev > /dev/null 2>&1 &
pid=$!
echo $pid>.pid
echo "wanxin-anbo-proxy 启动成功"
