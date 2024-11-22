# Spring @Async strange behavior demo

Demonstrates strange behavior when using `@Async`, and `@Value` together in Spring Boot framework.

```bash
% ./gradlew bootRun
```

then open http://localhost:8080, you will see below in the log.

```
non-async non-final: demo
non-async final: demo
async non-final: demo
async final: null
```
