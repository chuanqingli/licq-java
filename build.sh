#!/bin/bash

<<'COMMENT'
知识点：
COMMENT

source ../shell-func/build-basic.sh
#覆盖source文件里的方法
set-build-libs(){
    BUILDLIBS='

jsdk-24

    slf4j-api-1.6.4
slf4j-log4j12-1.6.4

log4j-1.2.15
commons-lang-2.5

commons-logging-1.1.1

jackson-core-asl-1.9.13
jackson-mapper-asl-1.9.13


junit


org.springframework.beans-3.1.1.RELEASE
org.springframework.context-3.1.1.RELEASE
org.springframework.core-3.1.1.RELEASE
org.springframework.asm-3.1.1.RELEASE
org.springframework.expression-3.1.1.RELEASE

'
<<'COMMENT'


json-lib-2.4-jdk15

org.springframework.aop-3.1.1.RELEASE
org.springframework.aspects-3.1.1.RELEASE
org.springframework.jdbc-3.1.1.RELEASE
org.springframework.transaction-3.1.1.RELEASE
org.springframework.web-3.1.1.RELEASE
org.springframework.web.servlet-3.1.1.RELEASE
COMMENT

}

$@
# $1
