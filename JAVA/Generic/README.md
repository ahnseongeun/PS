- Generic은 Promotion과 Casting을 획기적으로 줄여준다.
    - Promotion(자동형 변환)이 많이 발생할수록 손실되는 데이터도 많다.
    - Promotion을 하면 데이터의 범위가 줄고 Casting을 해야하는 데이터의 범위가 늘어난다.
  
- Generic은 타입 파라미터로 모든 클래스를 넣어줄 수 있다. 모든 타입이 가능하다는 말은
프로그램에 있어서 좋은 말은 아니다. 그래서 상한선, 하한선을 통해 '제약'을 걸어 줄 수 있다.
  1. 타입 파라미터 <T> 이용 (extends(상한선))
  2. 와일드 카드 <?> 이용 (extends(상한선), super(하한선))

- <T extends 상위 타입>은 주로 제네릭 클레스나 제네릭 메소드 생성시, 타입의 상한선을
지정해주기 위해 주로 사용된다.
  - <T extends Number>를 통해 타입에 상한선을 둘 수 있다.
    
- <? extends 상위 타입 or 하위 타입>은 주로 특정 메소드에 접근시, 타입의 상한선과 하한선을
지정해주기 위해 주로 사용된다.
  - public <T> void register(Course<? extends Person> course, T t)
  - course 객체가 register 메소드 매개변수에 접근하려면 course 객체의 타입 파라미터가
Person의 하위 클래스여야 한다.
    
- (와일드 카드)를 이용하여 상한선, 하한선을 설정
  - <?> : 전체 => 전체 타입 가능
  - <? extends 상위타입 A> : 상한선 => A 자식클래스까지만 가능
  - <? super 하위타입 B> : 하한선 => B 조상클래스만 가능