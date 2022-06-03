# ddd exercise

# title: 가상 CMP (infra shop)

# senario flow
- `cart` -> `order-box` -> `order` -> `requirement`, `job`, `task`

# Architecture
## Hexagonal architecture
- layer
  - adapter
  - port(in/out)
  - application(use case, service)
  - domain(entity)
  - ![Image](https://reflectoring.io/images/gyhdoca/dependencies_hua91b81f85a48092a6683e264647eb9e1_110079_638x0_resize_box_3.png)
  - ![Image](https://reflectoring.io/images/posts/spring-hexagonal/hexagonal-architecture_hu6764515d7030d45af6f7f498c79e292b_50897_956x0_resize_box_3.png)
- 후보 architecture 
  - [DDD-Lite](https://github.com/domain-driven-design/ddd-lite-example)
    - [DDD-Lite@Spring](https://www.youtube.com/watch?v=TdyOH1xZpT8)
    - domain 과 adapter 가 분리되어 있는 구조가 usecase 와 aggregate 개수가 많아길 경우 불편한듯  
  - [ddd-start2](https://github.com/madvirus/ddd-start2)
    - 초반에는 좋아보였으나, 한 package 다양한 성격(service, model, exception 등) 의 file 이 섞이고,
    - sub-domain 내에 다수 aggregate 를 넣는 방식이 너무 번거스러워 보임 (책 내용 자체는 좋음)
    - CQRS idea 는 여전히 괜찮아 보임
- boilerplate code 가 많아질 수 있으나, work-management 의 역할이 많고 복잡하여 domain 별로 구성요소를 분리하는 방법이 적합하다고 판단함
- 특히 controller 에서 받은 data 와 domain 에서 처리하는 data 및 저장 data 가 서로 달라야 하는 경우들이 존재함
  - ex) 
- 참고도서
  - [만들면서 배우는 클린 아키텍처](http://www.yes24.com/Product/Goods/105138479), [GitHub](https://github.com/wikibook/clean-architecture)
  - 원제 [Get Your Hands Dirty on Clean Architecture](https://www.amazon.com/Hands-Dirty-Clean-Architecture-hands/dp/1839211962), [GitHub](https://github.com/thombergs/buckpal)
  - [도메인 주도 설계 핵심](http://www.yes24.com/Product/Goods/48577718)
## 기본 구조
- 의존관계
  - `[adapter.in]` -> `[application.port.in]` ᐊ- `[application.service]` → `[application.port.out]` ᐊ- `[adapter.out]` → `[adapter.out]`           
  - xxxController → (xxxUsecase / xxxQuery) ᐊ- xxxService → xxxPort ᐊ- xxxAdapter → xxxRepository
- domain model 은 service 에서 제공 
- port.in 은 필요해지기 전까지 생략
- port.out 은 최대한 한가지 기능만 하는 interface 로 구분
- usecase 가 단순 CRUD 형태라면 port.out 에 JpaRepository 를 상속하는 interface 사용 
- [domain event](https://docs.microsoft.com/ko-kr/dotnet/architecture/microservices/microservice-ddd-cqrs-patterns/domain-events-design-implementation)
  - event-handler 는 application 계층에서 처리함. 이 경우, 같은 service package 에서 의존관계가 형성됨 
  - 자연스럽게 event-handler 는 다음과 같은 구조의 의존관계가 형성됨
    - xxxEventHandler -> xxxService -> xxxPort ᐊ- xxxAdapter : `[application.handler]` -> `[application.service]` -> ...
    - xxxEventHandler -> xxxRequestPort ᐊ- xxxRequestAdapter : `[application.handler]` -> `[application.port.out]` ᐊ- ...
  - event-handler 위치 및 이름
    - 이벤트가 너무 많아지지 않는다면 
- query 와 command 는 package 보다는 name 으로 구분
  - ex) CreateOrderService, QueryOrderService
- model 
  - model 은 각 usecase 마다 별도의 class 사용 권장 (create 와 edit 가 동일한 model 을 사용하는 우연(?)을 중복으로 생각하지 않기)
  - 한 package 에 파일 개수가 너무 많아질 경우 model package 를 추가하는 방식 보다는 기능 별로 구분 하고, 사용 모델은 기능과 함께 위치
    - ex) `service`, `service.model` -->  `service.create`, `service.edit`, `service.get`
- 도메인 서비스 (아직 예제 코드는 없음)
  - 응용 서비스와 구분되고, 상태가 없도록 유지
  - 도메인 로직을 구현하면서 하나의 aggregate 에 종속되지 않는 서비스
  - 가능하면 도메인 서비스 대신 aggregate 에서 도메인 로직을 사용을 권장함
  - 위치는 domain 패키지 내에 둠

## 모델의 매핑 전략
- 주로 양방향 매핑 사용
  - request, domain model, persistence model 분리
- 단순한 경우 매핑 생략
  - domain entity 로 jpa entity 사용
  - request 가 완전히 동일할 경우 domain entity 그대로 사용

# Ubiquitous Language
- 장바구니(cart)
- 주문(order)
  - 주문자(orderer)
- 주문내역(order-item) ([order-line](https://en.termwiki.com/EN/order_line) 이 더 명확하나 order-item 이 더 익숙함)
- 주문함(order-box)
- 결재함(order-approval-box) (생략)
- 결재(approval)
- 결제(payment)
- 업무(job)
- 요청사항(requirement) : 결재된 주문 단위의 고객 요청 사항 뭉탱이
  - requirement 1:N job(=order) 1:N task 
  - (work 로 할까 생각해 봤으나, 작업의 관점 보다는 요구사항에 대해 부각하는게 더 좋을듯 함) 
- 업무(job) : order 단위의 업무
- 작업(task) : orderItem 단위의 작업
  - 작업자(worker) <- member
- 작업처리(process) : 작업으로 이름 지을 경우 업무의 task 와 중복이 혼동이 심할듯
- 자원(asset) : resource 라고 하지 않은 이유는?
  - 카테고리(category) : VM 이나, DB, CPU 등의 자원 그룹
  - 리소스(resource) : 세부 자원 정보
- 고객(client): asset 을 요청하는 사람
- 작업자(member): asset 을 관리하고 업무를 처리하는 사람
- ID(id:identifier): auto-generate number 
- 인덱스(idx:index): 순서를 보장하는 index
- 식별자(no:number): UUID 와 같이 string type 의 식별자

# Domain Entity
- asset
  - category: 서비스 타입별 그룹
  - resource: 가용 자원 항목 제공
- client
- cart
- order
  - order-item
- (approval)
- member
- requirement
  - prior-job: 결재라인 등록, asset 준비
  - job 과 task 생성
  - job: job 과 task 의 상태 관리(승인, 반려 포함)
  - task: task 실행 및 상태관리
- task-history : 

# build
- 