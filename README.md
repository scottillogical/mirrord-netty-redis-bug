This is an example app intended to reproduce issues talking to redis in kids using redisson/netty via mirrord


Setup
1. Install java 1.8
   https://docs.oracle.com/javase/8/docs/technotes/guides/install/mac_jdk.html

Use gradle 6.6.1

Deploy redis

     kubectl create namespace scott-mirrord-zipcar
     helm -n scott-mirrord-zipcar install cheetah-redis  oci://registry-1.docker.io/bitnamicharts/redi
