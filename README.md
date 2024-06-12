This is an example app intended to reproduce issues talking to redis in k8s using redisson/netty via mirrord

update: the issue was that I needed to run "telepresence quit" first to avoid dns conflicts 
Prereqs
K8s
IntelliJ

Setup
1. Install java 1.8
   1. Install jenv [Manage your Java environment](https://www.jenv.be/)
   2. Download java 8
   3. https://docs.oracle.com/javase/8/docs/technotes/guides/install/mac_jdk.html
   4. jenv add /System/Library/Java/JavaVirtualMachines/$JAVA_VERSION/Contents/Home
2. install grade 6.1
   1. install sdkman [Installation - SDKMAN! the Software Development Kit Manager](https://sdkman.io/install)
   2. sdk install grade 6.1
   3. sdk use grade 6.1
3. Deploy redis
   1. kubectl create namespace scott-mirrord-zipcar
   2. helm -n scott-mirrord-test install cheetah-redis  oci://registry-1.docker.io/bitnamicharts/redis --set auth.enabled=false
   3. Confirm you can connect to redid using mirrord
      1. echo "KEYS *" | mirrord exec -a scott-mirrord-test redis-cli -- -h cheetah-redis-master.scott-mirrord-test.svc.cluster.local

Start app in IntelliJ (it did not work via cli either in my testing, but I coudlnt get this sample app to boot using gradle run)
1. Import app into IntelliJ as a gradle project
2. Specify gradle version
   1. Open gradle toolbar
   2. Select wrench icon - gradle settings
   3. Select “specified location” in “Use gradle from” dropdown
   4. Enter /Users/$USERNAME/.sdkman/candidates/gradle/current in textbox
   5. In gradle jvm section, select oracle 1.8
3. Open boostrap.java
4. Enable mirrord
4. Click the green arrow to start project
5. Select targetless

Expected: no errors, key written successfully
```
echo "KEYS *" | mirrord exec -a scott-mirrord-test redis-cli -- -h cheetah-redis-master.scott-mirrord-test.svc.cluster.local

