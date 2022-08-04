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
- [ ]  Chap 4. TDD 기능 명세서 설계
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

<aside>
💡 src/test/java 소스 폴더는 배포 대상이 아니므로 완성 되지 않은 코드가 배포 되지 않는다. 완성된 코드를 src/main/java 폴더로 옮기면 비로소 구현이 끝난다.

</aside>

첫번째 테스트를 잘 선택해야만 이후 진행과정이 순탄하게 흘러간다. 첫 번째 테스트는 가장 쉽거나 가장 예외적인 상황을 선택해야 한다. 이후 점차 상황에 따른 코드를 작성하면 된다.

~~~
💡 메소드 이름으로 구현한 기능을 바로 알아볼 수 있게 작성해야 하는데 협업 개발자중에 한글을 모르는 사람이 없다면 테스트 코드 메소드는 한글로 작성해도 된다.
~~~

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


