# Spring @Async strange behavior demo

Demonstrates strange behavior when using `@Async`, and `@Value` together in Spring Boot framework.

## code

```java
@Service
public class AsyncService {

	@Value("${spring.application.name}")
	private String value;

	@Async
	public void async() {
		// just declared, never called
	}

	public final void _final() {
		// becomes null
		System.out.println("async final: " + value);
	}

	public void nonFinal() {
		// becomes "demo"
		System.out.println("async non-final: " + value);
	}

}
```

```java
@Service
public class NonAsyncService {

	@Value("${spring.application.name}")
	private String value;

	public final void _final() {
		// becomes "demo"
		System.out.println("non-async final: " + value);
	}

	public void nonFinal() {
		// becomes "demo"
		System.out.println("non-async non-final: " + value);
	}

}

```

## run

```bash
% ./gradlew bootRun
```

then open http://localhost:8080, you will see below in the log.

```
async final: null
async non-final: demo
non-async final: demo
non-async non-final: demo
```
