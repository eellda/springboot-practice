# springboot-practice


### IDE
- IntelliJ

### New Project
- Spring Initiallizr
- Java
- Gradle-Groovy
- JDK - 17
- JAR
- SpringBoot - 3.1.0
- Lombok
- Spring Configuration Processer
- Spring Web

### Tools
- PostMan


### Spring Boot REST API
- REST
- 자원의 이름으로 구분해서 해당 자원의 상태를 교환
- server 와 client의 통신 방식중 하나
- HTTP URI 를 통해 자원을 명시하고 HTTP Method를 통해 자원을 교환 (CRUD)
- API - Application Progmramming Interface
- 응용 프로그램에서 사용할 수 있도록 다른 응용 프로그램을 제어할 수 있게 만든 인터페이스
- 인터페이스 = 어떤 당치간 정보를 교환하기 위한 수단이나 방밥

#### 특징
- Server - Client 구조 / 독립적 분리
- Stateless / client의 정보는 server 에 저장되지 않음
- Cacheable / HTTP의 특징인 캐싱 기능 적용
- Layered System / 서버의 구성과 상관없이 REST API 서버로 요청
- Code on Demand / request를 받으면 서버에서 클라이언트로 코드 or 스크립트를 전달하여 클라이언트 기능 확장
- Uniform Interface / 정보가 표준 형식으로 전송되기 위해 구성 요소간 통합 인터페이스 제공

#### 장점
- HTTP 표준 protocol를 사용하는 모든 플랫폼에서 호환
- 역할을 명확하게 분리
- 서비스 설계에서 생길 수 있는 문제를 최소화

#### 규칙
- Web 기반 REST API를 설계할 경우 URI 를 통해 resource 를 표현해야함
  - ex) https://naver.com/test/123
- resource 에 대한 조작은 HTTP Method 를 통해 표현해야 함
  - URI에 행위가 들어가면 안됨
- message를 통한 resource를 조작
  - HEADER를 통해 content-type를 지정하여 data 전달
  - HTML, XML, JSON 등

#### 설계 규칙
- URI 에는 대문자 사용 X
- Resource 의 이름이나 URI가 길어질 경우 - 를 사용하여 가동성 높임
- _ 사용 X
- 파일 확장자 표현 X

#### 설정 library
- Spring Boot Starter Parent
  - 라이브러리 간의 버전 충돌 문제가 발생하는걸 방지
- Spring Boot Starter Web
  - Spring MVC를 사용한 REST 서비스 개발에 사용
- Spring Boot Starter Test
  - JUnit, Hamcrest, Mockito 를 포함한 Spring Application Test의 기능


#### MVC Pattern
- Model, View, Controller 의 줄임말로 application을 구성할 때 구성요소를 3개의 역할로 구분한 패턴

#### Controller
- Model 과 View 사이에서 브릿지 역할을 수행함
  - app의 user로부터 입력에 대한 응답으로 model 및 view 를 업데이트하는 로직을 포함함
  - user의 요청은 모두 controller를 통해서 진행되야 함
  - 들어온 요청은 어떻게 처리할지 결정한 후 model로 전달

#### Model
- 데이터를 처리하는 영역
  - DAO와 DO로 구성 (무조건 따라해야 하는건 아님)

#### View
- 데이터를 보여주는 화면 자체의 영역
  - UI 요소들이 포함되며 데이터를 각 요소에 배치함
  - 별도의 데이터를 보관하지 않음

#### 특징
- application의 역할을 세 구간으로 나눔으로써 서로간의 의존성이 낮아짐
- 각 영역이 독립적으로 구성되어 분업 및 협업이 원활해짐
- 한 영역을 업데이트 하더라도 다런 곳에 영향 X

#### @RestController
- Spring Framework 4버전부터 사용 가능한 어노테이션
- @Controller + @ResponseBody
- 컨트롤러 class 하위 method에 @ResponseBody를 달지 않아도 문자열과 JSON등 전송 가능
- View 를 거치지 않고 HTTP ResponseBody 에 직접 Return 값을 담아 보냄

#### @RequestMapping
- MVC의 Handler Mapping 을 위해서 DefaultAnnotationHandlerMapping 사용
- DefaultAnnotationHandlerMapping 매핑정보로 @RequestMapping 를 활용
- Class 와 method의 RequestMapping을 통해 URL를 mapping하여 경로를 설정해 해당 method에서 처리
  - value - url
  - method - GET, POST, DELETE, PUT 등

- Spring 4.3 부터 간단한 어노테이션 사용 가능
  - @GetMapping
  - @PutMapping
  - @PostMapping
  - @DeleteMapping

#### DB 연결

- https://mariadb.com/downloads/
  - use UTF-8 check
- 설치 후 환경변수 - path - 편집 - mariadb 폴더의 bin 추가

#### @RequestMapping
- value 와 method 로 정의하여 API를 개발하는 방식
- 현재는 고전적인 방식

#### @GetMapping(value)
- 별도의 param 없이 GET API를 호출

#### @PathVariable
- GET 형식의 요청에서 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법
  - @GetMapping("/hello/{world}")
  - method(@PathVariable String world)
- @GetMapping 에서 사용된 {변수}의 이름과 메서드의 매개변수를 다를 경우 사용
  - @GetMapping("/hello/{world}")
  - method(@PathVariable("world") String nice)

#### @RequestParam
- GET 형식의 요청에서 쿼리 문자열을 전달하기 위해 사용
- ?를 기준으로 키=값형태로 전달 / 복수는 &를 사용
- 어떤 요청 값이 들어올지 모를 경우 Map<>을 사용함

#### DTO 사용
- GET 형식의 요청에서 쿼리 문자열을 전달하기 위해 사용
- key와 value 가 정해져있으나 받아야할 파라미터가 많을 경우에 DTO 객체를 사용
- getRequest(Member member) {}


#### POST API
- resource를 추가하기 위해 사용되는 API
- @PostMapping
  - @RequestMapping + POST Method
- 일반적으로 추가하고자 하는 resource를 HTTP body에 추가해 서버에 요청
  - @RequestBody를 이용하여 body에 담겨있는 값을 받아야함
- DTO 객체 사용 가능

### Swagger
---
- 협업을 위해 필요한 library
- 서버로 요청되는 API list 를 HTML 화면으로 문서화 하여 테스트를 할 수 있는 library
- 서버가 가동 되면서 @RestController 를 읽어 API를 분석하여 HTML문서를 작성함
- 필요한 이유
  - REST API의 스펙을 문서화 하는것은 매우 중요하기 때문임

#### Swagger 설정 방법
- @Configuration - IoC Container 에게 해당 class를 Bean 구성 class임을 알려줌
- @Bean - 개발자가 직접 제어 불가능한 외부 library등을 Bean으로 만들 경우 사용
- https://mvnrepository.com/

#### gradle
```java
implementation 'io.springfox:springfox-swagger2:2.9.2'
implementation 'io.springfox:springfox-swagger-ui:2.9.2'
```

#### maven
```java
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger2</artifactId>
  <version>2.9.2</version>
</dependency>

<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger-ui</artifactId>
  <version>2.9.2</version>
</dependency>
```

---
### 에러 발생
```java
ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'apiDocumentationScanner' defined in URL ~~~
같은 에러 발생
```

> 구글링을 해본 결과 spring context와 관련된 설정이 중복되어 발생한 문제라고 해서 @Configuration 어노테이션을 지웠더니 스프링부트 실행 됨

### 두번쩨 에러 발생
```java
http://localhost:8080/swagger-ui/index.html 에 접속했더니
Swagger ERROR : Unable to infer base url. This is common when using dynamic servlet registration or when the API is behind an API Gateway. The base url is the root of where all the swagger resources are served.
에러 발생
```

> 구글링을 해보면 Config 에 @Configuration 가 붙어있는걸 보아 얘는 달아놔야 되는걸 인식
> 그래서 다시 달고 빌드 후 실행함

### 세번쩨 에러 발생
```java
빌드 후 실행 해보니
error starting applicationcontext. to display the condition evaluation report re-run your application with 'debug' enabled.
과 함께 jar파일을 찾을수 없다는 등의 에러가 발생
```

> maven repository에서 가져온 의존성이라 build.gradle 의 repository에 maven url을 추가해줘야 되나 하고 추가해봤으나 어림없음
> 그래서 swagger 의 버전을 3.0.0 도 해보고 2.10.5도 해봤으나 안됨

### 해결
> 버전이 달라서 그런가?
> 내 스프링부트 버전은 3.1.0
> 적용하고자 했던 swagger 버전은 2.9.2
> 참고 링크 https://velog.io/@kjgi73k/Springboot3%EC%97%90-Swagger3%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
> dependencies 에 implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4'로 변경

#### springdoc-openapi v2.1.0
This library supports:
- OpenAPI 3
- Spring-boot v3 (Java 17 & Jakarta EE 9)
- JSR-303, specifically for @NotNull, @Min, @Max, and @Size.
- Swagger-ui
- OAuth 2
- GraalVM native images
![2023-05-20 195319](https://github.com/eellda/springboot-practice/assets/111367394/ad49004b-29af-46aa-9da6-1587f6083912)

#### 명세서를 추가하기 위해
```java
@OpenAPIDefinition(
        info = @Info(
                title = "spring Boot API Test",
                description = "API 명세서",
                version = "1.0.0",
                contact = @Contact(
                        name = "sm",
                        email = "test@test.co.kr"
                )
        )
)
추가
```

#### PUT API
- 해당 resource 가 존재하면 갱신하고, resource 가 없을 경우에는 새로 생성해주는 API
- Update를 위한 method
- 기본 방식은 Post API와 동일함

#### DELETE API
- 서버를 통해 resource 를 삭제하기 위해 사용하는 API
- 일반적으로 @PathVariable을 통해 resource id 등을 받아서 처리

#### ResponseEntity
- Spring Framework에서 제공하는 class 중 HttpEntity class를 inheritance 받아 사용하는 class
- 사용자의 HttpRequest에 대한 response data를 포함
  - HttpStatus
  - HttpHeaders
  - HttpBody

### Lombok
---
- 반복되는 method를 Annotation을 사용하여 자동으로 작성해주는 library
- 일반적으로 VO, DTO, Model, Entity 등의 Data class에서 주로 사용

#### 대표적 Annotation
```java
@Getter
@Setter
@NoArgConstructor
@AllArgConstructor
@Data
@ToString
```

- @NoArgConstructor - parameter가없는 constructor 를 생성
- @AllArgConstructor - 모든 필드값을 parameter로 갖는 constructor를 생성
- @RequiredArgsConstructor - 필드값중 final이나 @NotNull 인 값을 갖는 constructor 생성
- @EqualsAndHashCode - equals와 hashcode 메서드를 자동으로 생성
  - equals - 내용이 같은지
  - hashcode - 같은 객체인지
  - callsuper - true 면 부모 클래스 필드 값들도 동일한지 체크
- @Data
  - @Getter / @Setter / @RequiredArgsConstructor / @ToString / @EqualsAndHashCode 를 한번에 추가

### DTO / DAO / Repository / Entity
---
> Spring Boot Service 구조
![화면 캡처 2023-05-20 225207](https://github.com/eellda/springboot-practice/assets/111367394/5b9d4d82-4b65-4ef8-8efc-576733f6ca06)

#### Entity (Domain)
- databas에 쓰일 column 과 여러 entity 간의 연관관계를 정의
- database의 테이블을 하나의 entity로 생각해도 무방
- database의 테이블과 1:1 mapping
- 이 class의 field 는 각 테이블 내부의 column을 의미

#### Repository
- Entity에 의해 생성된 database에 접근하는 method를 사용하기 위한 interface
- service와 db를 연결하는 고리 역할
- database에 적용하고자 하는 CRUD를 정의

#### DAO (Data Access Object)
- databas에 접근하는 Object를 의미
- service가 db에 연결할 수 있게 해주는 역할
- db를 사용하여 data를 조회하거나 조작하는 기능

#### DAO (Data Transfer Object)
- VO 라고도 불리며 계층간 data 교환을 위한 Object를 의미
- VO 의 경우 RO의 개념을 가짐


### ORM & JPA
---
#### ORM (Ojbect Relational Mapping)
- 어플리케이션의 객체와 관계성 데이터베이스를 자동으로 mapping 해주는 것을 의미
- 객체지향 프로그래밍과 관계성 데이터베이스의 차이로 발생하는 제약사항을 해결해주는 역할을 수행
  - JPA, Hibernate 등
> 구조
![화면 캡처 2023-05-21 005934](https://github.com/eellda/springboot-practice/assets/111367394/7578f6b8-8f47-4b03-aaea-f0eabdceac46)

- SQL 쿼리가 아닌 직관적인 코드로 데이터를 조작 가능
- 재사용 및 유지보수 편리
- DBMS에 대한 종속이 줄어듬

#### 그러나
- 복잡성이 커질 경우 ORM 만으로 구현하기 어려워짐
- 잘못 구현할 경우 속도 저하 발생
- 대형 쿼리는 별도의 튜닝이 필요할 수 있음

#### JPA (Java Persistance API)
- ORM 과 관련된 interface 모음
- Java 진영에서 표준 ORM 으로 채택 되어 있음
- ORM 이 큰 개념이라고 하면, JPA 는 더 구체화 시킨 스펙을 포함함

#### Hibernate
- ORM Framework 중 하나
- JPA 의 실제 구현체중 하나이며 가장 많이 사용됨

#### Spring Data JPA
- Spring Framework에서 JPA를 편리하게 사용할 수 있게 지원하는 library
- CRUD 처리용 interface 제공
- 데이터 접근 계층 개발시 인터페이스만 작성해도 ok
- Hibernate 에서 자주 사용되는 기능을 조금 더 쉽게 사용할 수 있게 구현
> 구현도
![화면 캡처 2023-05-21 010843](https://github.com/eellda/springboot-practice/assets/111367394/6685ff0c-d9dd-4456-b5cd-63a15786213a)


### Database 연결 설정
```java
#h2 database setting
spring.h2.console.enabled=true

# MariaDB database setting
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/database 이름
spring.datasource.username=
spring.datasource.password=

#JPA setting
spring.jpa.hibernate.ddl-auto=
spring.jpa.show-sql=
```

의존성 설정
```java
// 가장 최신 버전 사용
implementation 'org.mariadb.jdbc:mariadb-java-client:3.1.4'
```

####  결과
---
repository에 설정된 table 생성
![화면 캡처 2023-05-21 022359](https://github.com/eellda/springboot-practice/assets/111367394/eb844a1c-096d-48d0-9738-448ec5413a5c)
![화면 캡처 2023-05-21 022533](https://github.com/eellda/springboot-practice/assets/111367394/86dd95a2-68e5-47d7-852b-07f025184393)

Post 동작
![화면 캡처 2023-05-21 022741](https://github.com/eellda/springboot-practice/assets/111367394/bd236326-f4f8-445a-bc11-dca4ea7bb4ab)

Get 동작
![화면 캡처 2023-05-21 023844](https://github.com/eellda/springboot-practice/assets/111367394/79dbeed8-5467-4822-9464-577ec69d9e75)

### Logback
---
- Log4J를 기반으로 개발된 Logging library
- log4j 에 비해 10뱆정도 빠른 퍼포먼스, 메모리 효율성 증대
  - 순서 log4j - logback - log4j2

#### 특징
- log에 특정 레벨 설정 가능 (Trace - Debug - Info - Warn - Error)
- 실운영과 테스트 상황에서 각각 다른 출력 레벨을 설정하여 로그 확인 가능
- 출력 방식에 대해 설정 가능
- 설정 파일을 일정 시간마다 스캔하여 application 중단 없이 설정 변경 가능
- 별도의 프로그램 없이 자체적으로 로그 압축 지원
- 로그 보관 기간 설정 가능
> 구조
![logback](https://github.com/eellda/springboot-practice/assets/111367394/15f09e40-78e7-4622-a7e4-7f69780e8d64)

#### 설정
- 일반적으로 classpath에 있는 logback 설정 파일을 참조함
- java legacy, spring = logback.xml
- spring boot = logback-spring.xml

#### appender
- log의 형태 및 어디에 출력할지 설정하기 위한 영역
  - 대표적으로 
  - ConsoleAppender - 콘솔에 로그 출력
  - FileAppender - 파일에 로그 저장
  - RollingFileAppender - 여러개의 파일을 순회하여 로그 저장
  - STMPAppender - 로그를 메일로 보냄
  - DBAppender - 데이터베이스에 로그 저장

#### encoder
- Appender 내에 포함되는 항목이며, pattern을 사용하여 원하는 형식으로 로그를 표현함

#### root
- 설정한 Appender를 참조하여 로그의 레벨을 설정함
- 전역 설정 - root / 지역 설정 - logger


#### log level
1. ERROR - 로직 수행 중에 오류가 발생한 경우, 시스템적으로 심각한 문제가 발생하여 작동이 불가한 경우
2. WARN - 시스템 에러의 윈인이 될 수 있는 경고 레벨, 처리 가능한 사항
3. INFO - 상태 변경과 같은 정보성 메세지
4. DEBUG - 어플리케이션의 디버깅을 위한 메세지 레벨
5. TRACE - DEBUG 레벨보다 더 디테일한 메세지를 표현하기 위한 레벨

#### pattern
> %logger: 패키지 포함 클래스 정보
> %logger{0}: 패키지를 제외한 클래스 이름만 출력  
> %logger{length}: Logger name을 축약할 수 있음. {length}는 최대 자리 수, ex)logger{35}
> %-5level: 로그 레벨, -5는 출력의 고정폭 값(5글자), 로깅레벨이i nfo일 경우 빈칸 하나 추가
> ${PID:-}: 프로세스 아이디
> %d: 로그 기록시간 출력
> %p: 로깅 레벨 출력
> %F: 로깅이 발생한 프로그램 파일명 출력
> %M: 로깅일 발생한 메소드의 명 출력
> %line: 로깅이 발생한 호출지의 라인
> %L: 로깅이 발생한 호출지의 라인
> %thread: 현재 Thread 명
> %t: 로깅이 발생한 Thread 명
> %c: 로깅이 발생한 카테고리
> %C: 로깅이 발생한 클래스 명 (%C{2}는 somePackage.SomeClass 가 출력됨)
> %m: 로그 메시지
> %msg: - 로그 메시지 (=%message)
> %n: 줄바꿈(new line)
> %%: %를 출력
> %r : 애플리케이션 시작 이후부터 로깅이 발생한 시점까지의 시간(ms)
> %d{yyyy-MM-dd-HH:mm:ss:sss}: %d는 date를 의미하며 중괄호에 들어간 문자열은 dateformat을 의미
> %-4relative: %relative는 초 아래 단위 시간(밀리초)을 나타냄. -4를하면 4칸의 출력폼을 고정으로 가지고 출력


### 유효성 검사
---
- 서비스의 로직이 올바르게 동작하기 위해 사용되는 데이터에 대한 사전 검증하는 작업이 필요함
- validation이라고 부름
- 데이터의 검증은 여러 계층에서 발생하는 흔한 작업
- 들어오는 데이터에 대해 의도한 형식의 값이 제대로 들어오는지 체크하는 과정을 뜻

#### 일반적인 validation의 문제점
- 어플리케이션 전체적으로 분산되어 존재
- 코드의 중복이 심함
- 비즈니스 로직에 섞여 있어 검사 로직 추적이 어려움

> 위 문제점들을 해결하기 위해
- Bean Validation / Hibernate Validator 를 제공
- Bean Validation
  - Java 에서 2009년부터 제공하는 데이터 유효성 검사 Framework
  - 어노테이션을 통해 다양한 데이터 검증을 할 수 있게 기능 제공
- Hibernate Validator
  - Bean Validation 명세에 대한 구현체
- Spring Boot 유효성 검사 표준은 Hibernate Validator
  - 단, 2.3v 부터는 starter-validation을 추가해야함

#### 관련 어노테이션
> @Size
> @NotNull
> @NotEmpty
> @NotBlank
> @Past
> @PastOrPresent
> @Future
> @FutureOrPresent
> @Pattern
> @Max
> @Min
> @AssertTrue
> @AssertFalse
> @Value


### Exception
---
- 스프링 부트의 예외 처리 방식은 크게 2가지
  - @ControllerAdvice를 통한 모든 Controller에서 발생할 수 있는 예외 처리
  - @ExceptionHandler를 통한 특정 Controller의 예외 처리
  - @ControllerAdvice로 모든 Controller에서 발생할 Exception을 정의하고
    - @ExceptionHandler를 통해 발생하는 Exception 마다 처리할 method를 정의

#### 예외 클래스
- 모든 예외 클래스는 Throwable 클래스를 extends 함
- Exception 은 수많은 자식 클래스가 있으며, RuntimeException 은 Unchecked Exception이며, 그 외 Exception은 Checked Exception으로 볼 수 있다

- @ControllerAdvice / @RestControllerAdvice
  - Spring에서 제공하는 어노테이션
  - @Controller나 @RestController에서 발생하는 예외를 한 곳에서 관리하고 처리할 수 있게 하는 어노테이션
  - 설정을 통해 범위 지정 가능 / Default 값으로 모든 Controller에 대해서 예외처리를 관리함
  - 예외 발생시 json의 형태로 결과를 반환하기 위해선 @RestControllerAdvice를 사용

- @ExceptionHandler
  - 예외 처리 상황이 발생하면 Handler로 처리하겠다고 명시하는 어노테이션
  - 뒤에 괄호를 붙임으로써 어떤 ExceptionClass를 처리할지 설정 가능
  - Exception.class는 최상위 클래스로 하위 세부 예외 처리 클래스로 설정한 핸들러가 존재할 경우 그 핸들러가 우선처리 하게 되며, 처리 하지 못하는 예외 처리에 대해 ExceptionClass에서 핸들링함
  - @ControllerAdvice 로 설정된 클래스 내에서 메서드로 정의할 수 있으며 각 Controller 안에 설정도 가능
  - 전역설정(ControllerAdvice)보다 지역설정(Controller)으로 정의한 Handler가 우선순위를 가지게 됨

#### Custom Exception
- error type, error code, message를 응답함으로써 client 에 정확히 어떤 에러가 발생했는지 공유하는게 목적
- error type - HttpStatus reasonPhrase
- error code - HttpStatus value
- message - 상황별 메세지

#### HttpStatus
- Enum 클래스로써 서로 관련 있는 상수들을 모아서 심볼릭한 명칙의 집합으로 정의한 것으로 클래스처럼 보이게 하는 상수


### Rest Template
---
- 스프링에서 제공하는 HTTP 통신 기능을 쉽게 사용할 수 있게 설계되어 있는 템플릿
- HTTP 서버와의 통신을 단순화하고 RESTful 원칙을 지킴
- 동기 방식이며 비동기 방식으로는 AsyncRestTemplate가 있음
- RestTemplate 클래스는 REST 서비스를 호출하도록 설계되어 HTTP protocol의 method에 맞게 여러 method 를 제공함
- method들
  - getForObject
  - getForEntity
  - postForObject
  - postForEntity
  - delete
  - put
  - patchForObject
  - exchange

- server project 하나 더 필요

### JUnit
---
- TDD
  - 테스트 주도 개발이라는 의미를 가짐
  - 테스트를 먼저 설계 및 구축 후 테스트를 통과할 수 있는 코드 작성
  - 코드 작성 후 테스트를 진행하는 지금까지 사용된 일반적인 방식과 다소 차이 있음
  - 애자일 개발 방식중 하나
    - 코드 설계시 원하는 단계적 목표에 대해 설정하여 진행하고자 하는 것에 대한 결정 방향의 갭을 줄이는 것
    - 최초 폭표에 맞춘 테스트를 구축하여 그에 맞게 코드를 설계하기 때문에 보다 적은 의견 충돌을 기대함

- 코드의 안정석을 높임
  - side-effect를 줄일 수 있음
  - 해당 코드가 작성된 목적을 명확하게 표현함

- JUnit
  - Java 진역의 대표적 Test Framework
  - 단위 테스트를 위한 도구 제공
  - 어노테이션 기반으로 테스트 지원
  - 단정문으로 테스트 케이스의 기대값에 대해 수행 결과를 확인 할 수 있음
  - spring boot 2.2 부터 JUnit 5 버전 사용
    - 크게 Jupiter, Platform, Vintage 모듈로 구성

- Jupiter
  - TestEngine API 구현체로 JUnit 5를 구현함
  - 테스트의 실제 구현체를 별도 모듈 역할을 수행하며 그 모듈중 하나가 jupiter-Engine
  - Jupiter-API를 사용하여 작성한 테스트 코드를 발견하고 실행하는 역할을 수행
  - 테스트 코드를 작성할 때 사용

- Platform
  - Test를 실행하기 위한 뼈대
  - Test를 발견하고 테스트 계획을 생성하는 TestEngine interface를 가지고 있음
  - TestEngine을 통해 Test를 발견하고, 수행 및 결과를 보고
  - 각종 IDE 연동을 보조하는 역할을 수행

- Vintage
  - TestEngine API 구현체로 JUnit 3, 4를 구현함
  - 기존 3, 4 버전으로 작성된 테스트 코드를 실행할 때 사용됨
  - Vintage-Engine 모듈을 포함함

#### JUnit LifeCycle Annotation
- @Test - 테스트용 메서드 표현
- @BeforeEach - 각 테스트 메서드가 시작되기 전에 실행되어야 하는 메서드 표현
- @AfterEach - 각 테스트 메서드가 시작된 후 실행되어야 하는 메서드 표현
- @BeforeAll - 테스트 시작 전에 실행되어야 하는 메서드 표현 (static 처리 필요)
- @AfterAll - 테스트 시작 후 실행되어야 하는 메서드 표현 (static 처리 필요)

> Main Annotation
- @SpringBootTest
  - 통합 테스트 용도
  - @SpringBootAllpication을 찾아가 하위의 모든 Bean을 스캔하여 로드
  - 이후 Test용 Application Context를 만들어 Bean 추가, MockBean을 찾아 교체
- @ExtendWith
  - JUnit4에서 @RunWith로 사용되던 어노테이션이 ExtendWith로 변경
  - 메인으로 실행될 class를 지정할 수 있음
  - @SpringBootTest는 기본적으로 @ExtendWith가 추가되어 있음
- @WebMVCTest(exam.class)
  - ()에 작성된 클래스만 실제로 로드하여 테스트를 진행함
  - 매개변수를 지정하지 않으면 @Controller, @RestController등 컨트롤러와 연관된 Bean이 모두 로드됨
  - 스프링의 모든 Bean을 로드하는 @SpringBootTest 대신 컨트롤러 관련 코드만 테스트할 경우에 사용
- @Autowired about Mockbean
  - Controller의 API를 테스트하는 용도인 MockMVC 객체를 주입받음
  - perform() 메서드를 활용하여 컨트롤러의 동작을 확인할 수 있음
  - .andExpect(), andDo(), andReturn() 등의 메서드를 같이 사용
- @MockBean
  - 테스트할 클래스에서 주입 받고 있는 객체에 대해 가짜 객체를 생성해주는 어노테이션
  - 해당 객체는 실제 행위를 하지 않음
  - given() 메서드를 활용하여 가짜 객체의 동작에 대해 정의하여 사용함
@AutoConfigureMockMvc
- spring.test.mockmvc 의 설정을 로드하면서 MockMvc의 의존성을 자동으로 주입
- MockMvc 클래스는 REST API 테스트를 할 수 있는 클래스
@Import
- 필요한 class들을 Configureation으로 만들어 사용할 수 있음
- Configuration Component 클래스도 의존성 설정할 수 있음
- Import된 클래스는 주입으로 사용 가능

> 통합 테스트
- 여러 기능을 조합해서 전체 비즈니스 로직이 제대로 동작하는지 확인하는 것을 의미
- @SpringBootTest를 사용하여 진행
- @SpringBootApplication을 찾아가서 모든 Bean을 로드하기 때문에 매번 무거운 작업을 수행해야 함

> 단위 테스트
- 프로젝트에 필요한 모든 기능에 대한 테스트를 각각 진행하는 것을 의미

> F.I.R.S.T 윈칙
- Fast - 테스트 코드의 실행은 빠르게 진행되어야 한다
- Independent - 독립적인 테스트가 가능해야 한다
- Repeatable - 테스트는 매번 같은 결과를 만들어야 한다
- Self-Validation - 테스트는 그 자체로 실행하여 결과를 확인할 수 있어야 한다
- Timely - 단위 테스트는 비즈니스 코드가 완성되기 전에 구성하고 테스트가 가능해야 한다 (TDD의 원칙을 담고 있음)

