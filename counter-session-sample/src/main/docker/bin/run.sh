#!/bin/sh

echo "### Custom script run.sh is used..."

args="$*"

echo "### Prepare JGroups required System properties."

NODE_ID=$(cat /etc/hostname)
BIND_ADDR=$(getent ahosts $NODE_ID | head -1 | awk '{print $1}')

export JAVA_OPTIONS="$JAVA_OPTIONS -Dswarm.node.id=$NODE_ID"
export JAVA_OPTIONS="$JAVA_OPTIONS -Dswarm.bind.address=$BIND_ADDR"
export JAVA_OPTIONS="$JAVA_OPTIONS -Djava.net.preferIPv4Stack=true"

echo "### JAVA_OPTIONS=${JAVA_OPTIONS}"

exec /opt/run-java/run-java.sh $args

