# SingleTon이란 
- 단 하나의 객체만을 생성할 수 있는 패턴, 이미 생성되었다면 생성된 것을 반환
- static과는 달리 확장과 인터페이스 구현이 가능
- 인스턴스의 생성 시점을 조정 가능
- 객체이기 때문에 힙에 저장되고 쓰레드간 공유가 가능하다.
- 클래스 객체이기 때문에 직렬화 가능


## Static과 SingleTon
### static
- 어플리케이션이 메모리에 로드 될 때 정적 스택에 바로 초기화
- static stack에 저장되기 때문에 스레드 관리가 어렵다.

### 차이점
- 싱글톤은 분리 가능한 의존성을 지니고 있만 Static은 아니다.
- 싱글톤은 내부에 선언된 static 객체를 교체해서 변경 가능


