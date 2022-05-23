# ddd exercise

# title: 가상 CMP (infra shop)

# flow
- cart -> order-box -> order -> job

# language
- 장바구니(cart)
- 주문(order)
  - 주문자(orderer)
- 주문내역([order-line](https://en.termwiki.com/EN/order_line))
- 주문함(order-box)
- 결재함(order-approval-box) (생략)
- 결재(approval)
- 결제(payment)
- 업무(job)
- 작업(task)
  - 작업자(worker) <- member
- 작업처리(process) : 작업으로 이름 지을 경우 업무의 task 와 중복이 혼동이 심할듯
- 카테고리(category) : VM 이나, DB, CPU 등의 자원 그룹
- 자원(asset) : resource 라고 하지 않은 이유는? 
- 고객(user): asset 을 요청하는 사람
- 작업자(member): asset 을 관리하고 업무를 처리하는 사람
- ID(id:identifier): db generate number 
- 인덱스(idx:index): 순서를 보장해야 하는 index
- 식별자(no:number): UUID 와 같이 string type 식별자

# domain
- asset
  - category: 서비스 타입별 그룹
  - resource: 가용 자원 항목 제공
- user
- order
  - cart
  - order
  - approval
- member
- work
  - priorJob: 결재라인 등록, asset 준비 
  - job: job 과 task 의 상태 관리(승인, 반려 포함)
  - process: task 실행 및 상태관리

# build
- 