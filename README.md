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

