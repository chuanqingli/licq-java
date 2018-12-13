#!/bin/bash

<<'COMMENT'
知识点：
COMMENT

source ../build-basic/build-basic.sh
#覆盖source文件里的方法
set-build-libs(){
    BUILDLIBS='

jsdk-24

    slf4j-api-1.6.4
slf4j-log4j12-1.6.4

log4j-1.2.15
jackson-core-asl-1.9.13
jackson-mapper-asl-1.9.13


json-lib-2.4-jdk15
commons-lang-2.5

junit

'
}


$1
