# Test Driven Devlopment

📝테스트 주도 개발 시작 정리 


<p align="center">
<img src="https://user-images.githubusercontent.com/77061558/182617349-66d81900-d787-4773-a599-55949db5e924.png" width="50%" heigth="50%"/>
</p>

스프링으로 프로젝트 진행하고 나서 테스트의 중요성을 깨달았다. 예외사항을 하나씩 전부 톰캣을 실행하여 확인하는 작업이 비효율적이라 시간을 많이 뺏겼다. 인프런 강의를 들으면서 JUnit의 사용법만 살짝 알고있는 상태라 이번 기회에 TDD에 대해 공부해보려고 한다.

목차

- [x]  Chap 1. TDD 개발준비
- [x]  Chap 2. TDD 시작
- [x]  Chap 3. 테스트 코드 작성 순서
- [x]  Chap 4. TDD 기능 명세서 설계
- [ ]  Chap 5. JUnit5 기초
- [ ]  Chap 6. 테스트 코드의 구성
- [ ]  Chap 7. 대역
- [ ]  Chap 8. 테스트 가능한 설계
- [ ]  Chap 9. 테스트 범위와 종류
- [ ]  Chap 10. 테스트 코드와 유지보수
- [ ]  Chap 11 마치며

## 2. TDD 시작

챕터 1은 설정 부분이므로 생략…

TDD란, Test Driven Development의 약자로 구현을 먼저 하는게 아니라 테스트를 하고 그 다음에 구현하는 개방 방법을 뜻한다. 기능 검증을 하는 테스트 코드를 먼저 작성하고 테스트를 통과시키기 위해 개발을 진행한다.

- @Test: JUnit에서 제공하는 어노테이션으로 @Test가 붙은 메소드는 테스트 메소드로 인식한다.
- Assertions.assertEquals(a, b): a와 b의 값이 일치하는지 확인하는 메소드로 a는 기대값, b는 실제 값으로 사용
    - 주의할 점은 `org.junit.jupiter.api.Assertions` 을 사용해야함

테스트 코드를 작성하는 과정에서 테스트의 대상이 되는 클래스 이름, 변수 이름, 메소드 이름, 메소드의 파라미터 갯수와 타입, 리턴 타입등을 고민하는 과정은 실제 코드를 설계하는 과정과 유사하다.

> 💡 src/test/java 소스 폴더는 배포 대상이 아니므로 완성 되지 않은 코드가 배포 되지 않는다. 완성된 코드를 src/main/java 폴더로 옮기면 비로소 구현이 끝난다.  

첫번째 테스트를 잘 선택해야만 이후 진행과정이 순탄하게 흘러간다. 첫 번째 테스트는 가장 쉽거나 가장 예외적인 상황을 선택해야 한다. 이후 점차 상황에 따른 코드를 작성하면 된다.  

> 💡 메소드 이름으로 구현한 기능을 바로 알아볼 수 있게 작성해야 하는데 협업 개발자중에 한글을 모르는 사람이 없다면 테스트 코드 메소드는 한글로 작성해도 된다.  
  
테스트 코드도 코드이기 때문에 유지보수 대상이다. 메소드 안에서 발생하는 중복 코드를 제거하거나 의미가 잘 드러나게 코드를 수정할 필요가 있는데 무턱대고 중복을 제거 했다간 오히려 가독성이 떨어지고 수정이 힘들수 도 있게된다. 

만약 중복을 제거 했는데 테스트 코드 관리가 어렵다면 제거 했던 중복을 되돌려야 한다.

<p align="center">
<img width="50%" alt="스크린샷 2022-08-03 오후 11 45 08" src="https://user-images.githubusercontent.com/77061558/182637645-6958a872-c275-4882-916e-da8138c15855.png">
</p>

1. 기능을 검증하는 테스트 작성
2. 작성한 테스트가 통과할 만큼 코드 작성
3. 개선할 부분이 보이면 리팩토링
4. 테스트를 재실행하여 기존 기능이 잘 작동하는지 확인

1~4의 과정을 반복하면서 점진적으로 기능을 완성해 나가는 것, 이것이 전형적인 **TDD 흐름**이다.

> TDD 사이클은 `레드-그린-리팩터`로 부르기도 한다.
> 레드는 실패, 그린은 성공, 리팩터는 리팩토링 과정을 의미

테스트가 개발을 주도한다. 이 말의 의미는 해당 기능이 올바르게 동작하는지 검증할 수 있는 테스트 코드를 만들고 통과하면 다음 경우를 생각해서 테스트 코드를 작성하고 구현하다 보면 점차 테스트 코드가 추가 될 것이고  검증하는 범위가 넓어질수록 구현이 완성되어가는 것이다.

리팩토링할 대상이 눈에 들오면 리팩토링 생각나지 않으면 다음 테스트 진행한다. 개발 과정에서 지속적으로 코드 정리를 하므로 코드 품질이 급격히 나빠지는 걸 막을 수 있고 향후 유지보수에도 효과 있다.  
TDD가 주는 이점은 코드 수정에 대한 피드백이 빨라 잘못된 코드가 배포되는 것을 방지한다.

## 3.  테스트 코드 작성 순서

- 쉬운 경우에서 어려운 경우로 진행
- 예외적인 경우에서 정상적인 경우로 진행

### 구현 하기 쉬운 테스트부터 시작하기

한번에 완벽한 코드를 만드는 것은 정말 어렵다. 한번에 많은 코드를 작성하다 보면 생각하지 못한 버그나 예외사항이 생겨 테스트 통과까지 시간이 오래 걸린다.

쉬운 테스트부터 시작하면 구현 하는 시간이 짧아 코드의 내용을 개발자 머리속에 들어있어 디버깅에 유리하다.

### 예외 상황을 먼저 테스트

예외 사항은 `else-if`  블록을 동반하는 경우가 많아 중간에 예외사항을 처리하려면 코드의 구조를 건드려야하는 상황이 발생하기 때문에 초반에 예외사항을 테스트 하면 이런 가능성을 줄일 수 있다.

### 완급 조절

한 번에 얼마만큼의 코드를 작성할 것인가는 TDD로 구현할 때 어려운 점이다. 

1. 정해진 값을 리턴
2. 값 비교를 이용해서 정해진 값을 리턴
3. 다양한 테스트를 추가하면서 구현을 일반화

이러한 과정을 연습하다 보면 만들어야할 코드가 잘 떠오르지않을때 점진적으로 구현을 진행할 수 있는 밑거름이 된다.

### 지속적인 리팩토링

매번 리팩토링을 해야하는 것은 아니지만 리팩토링으로 코드의 가독성이 높아지면 빠른 코드 분석이 가능해 유지보수에 도움이 된다. 

소프트웨어의 생존시간이 길어질수록 지속적인 개선이 필요하다. 리팩토링을 통해 코드를 쉬운 구조로 변경하기 쉽게 만든다.

> 💡 상수를 변수로 변수나 메소드 명 변경같은 작은 리팩토링은 바로 실행하고 메소드 추출과 같은 구조에 영향을 주는 리팩토링은 큰 틀에서 구현 흐름이 눈에 들어오기 시작한 뒤에 진행

> 메소드의 파라미터가 새개 이상이면 객체로 변환하는 것을 고려

### 테스트할 목록 정리

테스트할 목록을 정리하면 어떤 테스트가 쉬울지, 예외적인지 생각해 볼 수 있기 때문에 테스트를 선택할 때 도움이 된다. 또한 테스트 과정에서 새로운 사례를 발견하면 즉시 목록에 추가해야한다.

테스트 목록에 있는 테스트를 다 작성하면 코드가 많아져 리팩토링에 대한 심리적 저항이 생긴다.

하나의 테스트 코드를 만들고 통과시키고 리팩토링하면 다루는 범위가 작고 개발 주기도 짧아 집중력에 도움이 된다.

범위가 큰 리팩토링 대상은 목록에 적어두고 우선 테스트 통과에 집중하고 그 뒤에 진행한다.

> Git과 같은 버전 관리 시스템을 사용하여 리팩토링 실패시 원본 복구가 가능하다.
> 

## 4. TDD 기능 명세 설계

### 기능 명세

설계는 기능 명세로 부터 시작한다. 다양한 형태(스토리보드, 문장, 구두..)의 요구사항 문서를 이용하여 기능 명세를 구체화 한다. 기능 명세의 내용을 코드에 반영하는 과정에서 기능의 이름, 라마미터, 리턴 타입 등이 결정되기 때문에 기능에 대한 `설계 과정`과 연결된다.

### 설계 과정을 지원하는 TDD

TDD는 테스트를 만드는 것부터 시작한다. 테스트 코드를 먼저 만들기 위해 다음 두 가지가 중요하다.

- 테스트할 기능 실행
- 실행 결과 검증

실행과 검증을 하기 위해 클래스, 메소드의 이름, 타입, 파라미터 등을 고민하는데 이 과정이 곧 설계 행위다. 

TDD자체가 설계는 아니지만 테스트 코드를 작성하는 과정에서 일부 설계를 진행하게 된다 .

> 이름은 설계에서 매우 중요하다. 잘못된 이름으로 여러 개발자가 협업할 경우 잘못된 기능을 구현할 수도 있고 코드 분석하는 시간이 늘어나 코드 수정이을 어렵게 만드는 원인이 된다.`시간이 걸리더라도 알맞은 이름을 찾아야 한다`
> 

### 필요한 만큼 설계하기

필요할 것으로 예측해서 미리 코드를 만들지 않는다. 요구사항은 언제든지 변경되기 때문에 처음에 설계 요소가 구현에서 필요 없을 수도 있고 예상하지 못한 설계 요소가 추가 될 수 있기때문에 미리 코드를 만들지 않으면 불필요한 구성 요소를 덜 만들게 된다.

### 기능 명세 구체화

테스트 코드를 작성하기 위해 개발가는 기능 명세를 정리해야 한다. 보통 개발자가 전달 받은 문서는 개발자 입장에서 생략된 부분이 많기 때문에 애매한 점을 발견하면 기획자난 실무자와 얘기해서 구체적으로 정리해야 한다.

모호한 상황을 구체적인 예로 테스트하면 이 코드는 구체적인 명세가 된다. 

> 개발자는 최대한 예외적인 상황이나 복잡한 상황에 해당하는 `구체적인 예` 를 끄집어 내야한다. 담당자와 대화가 없다면 올바른 결과물을 개발하지 못할 것이다.

## 5. JUnit5 기초

### JUnit5 모듈 구성

- JUnit 플랫폼: 테스팅 프레임워크를 구동하기 위한 런처와 테스트 엔진을 위한 API 제공
- JUnit 주피터: JUnit5를 위한 테스트 API와 실행 엔진 제공
- JUnit 빈티지: JUnit3,4로 작성된  테스트를 JUnit5 플랫폼에서 실행하기 위한 모듈 제공

<p align="center">
<img width="50%" src="https://user-images.githubusercontent.com/77061558/183238317-ea061fb0-1986-45e4-8716-5dc814adc021.png">
</p>

<p align="center">
주요 모듈 구조
</p>

### @Test 어노테이션과 테스트 메소드

테스트로 사용할 클래스를 만들고 메소드에 `@Test`  어노테이션만 붙이면 된다.

테스트를 작성하는 특별한 규칙은 없지만 **private**로 선언하면 안된다.

### 주요 단언 메소드
