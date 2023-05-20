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

#### Swagger
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