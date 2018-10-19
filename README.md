# Thorntail Session Clustering Example

# Prerequisites

You must install two custom fraction, infinispan and jgroups, in your local registry.

```bash
$ mvn clean install -f jgroups/pom.xml
$ mvn clean install -f infinispan/pom.xml
```

# Run Sample Code

```bash
$ oc login
$ oc new-project <your-project>

$ mvn clean fabric8:deploy -f counter-session-sample/pom.xml
```