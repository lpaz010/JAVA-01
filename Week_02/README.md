

#### 学习笔记
 
##### sb参数说明 https://www.cnblogs.com/yyfh/p/12447263.html

##### 运行参数 sb -u http://localhost:8088/api/hello -c 50 -N 60

###### java -Xmx256m -Xms256m -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.demo.log GCLogAnalysis

###### java -Xmx512m -Xms512m -Xloggc:D:\Repositories\geekbang\JAVA-01\Week_02\src\main\java\gc\ParallelGC_512m.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar

###### java -Xmx1g -Xms1g -Xloggc:D:\Repositories\geekbang\JAVA-01\Week_02\src\main\java\gc\ParallelGC_1g.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar

###### java -Xmx2g -Xms2g -Xloggc:D:\Repositories\geekbang\JAVA-01\Week_02\src\main\java\gc\ParallelGC_2g.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar

###### java -Xmx4g -Xms4g -Xloggc:D:\Repositories\geekbang\JAVA-01\Week_02\src\main\java\gc\ParallelGC_4g.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar

###### java -Xmx8g -Xms8g -Xloggc:D:\Repositories\geekbang\JAVA-01\Week_02\src\main\java\gc\ParallelGC_8g.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar

###### java -Xmx16g -Xms16g -Xloggc:D:\Repositories\geekbang\JAVA-01\Week_02\src\main\java\gc\ParallelGC_16g.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar