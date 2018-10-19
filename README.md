# Thorntail Session Clustering Example

# Prerequisites

You must install two custom fractions, infinispan and jgroups, in your local registry.

```bash
$ mvn clean install -f jgroups/pom.xml
$ mvn clean install -f infinispan/pom.xml
```

# Run Sample Code

## Local Environment

```bash
$ mvn clean package -f counter-session-sample/pom.xml
$ java -Dswarm.bind.address=localhost \
	-Dswarm.node.id=node1 \
	-Djava.net.preferIPv4Stack=true \
	-jar counter-session-sample/target/counter-session-sample-thorntail.jar
$ java -Dswarm.port.offset=100 \
	-Dswarm.bind.address=localhost \
	-Dswarm.node.id=node2 \
	-Djava.net.preferIPv4Stack=true \
	-jar counter-session-sample/target/counter-session-sample-thorntail.jar

```
## OpenShift Environment

```bash
$ oc login
$ oc new-project <your-project>

$ mvn clean fabric8:deploy -Popenshift -f counter-session-sample/pom.xml
```