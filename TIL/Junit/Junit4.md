# Junit 4
- ### Assertions for testing expred results
- ### Test fixtures for sharing common test data

---

## Fixture
- ### A test fixture는 테스트를 위한 기반으로 사용되는 고정된 집합이다.

### Examples of fixtures
> - input data는 setup/ creation of fake 이나 mock objects를 활용한다.
> - 데이터 집합으로 데이터 베이스 로딩
> - test fixture를 생성하는 특정 파일 세트를 복사하면 특정 상태로 초기화된 객체 집합 생성
- ### Junit 4에는 setup, teardown 대신 before와 after annotation이 존재하는데 @Before와 @After를 사용해서 setup과 teardown 메소드를 커스텀해서 만들수 있다.


## Before, BeforeClass, BeforeEach, BeforeAll 차이
> ### @Before (Junit 4), @BeforeEach (Junit5)
> - 클래스 내에 존재하는 각각의 @Test를 실행하기 전에 매번 실행
> ### @BeforeClass (Junit 4), @BeforeAll (Junit 5)
> - 모든 테스트를 실행하기 전에 딱 한 번만 실행
> - static으로 선언해야 한다.