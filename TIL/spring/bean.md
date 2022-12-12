# Bean
- Bean이란 Spring IOC 컨테이너가 관리하는 자바 객체이며, 
method level에서 사용하는 어노테이션   

- Spring에서 기본적으로 Bean을 등록할 때 proxy를 사용한다. 하지만 Lite Mode는 실제 인스턴스를
생성하기 때문에 proxy가 필요한 Spring 기능들을 사용할 수 없다. (AOP 등)

```java
/**
 * Component에서 Bean을 사용하는 상황 (Lite Mode)
 */
@Component 
public class ComponentBean {
    @Bean 
    public TestBean testBean() {
        return new TestBean();
    }
}
```


--- 

## Bean을 등록하는 2가지 방법
### 1. Component
- 개발자가 직접 작성한 클래스를 bean으로 등록하고자 하는 경우 사용  ( class level)


### 2. Configuration
- 내부적으로 @Component가 정의되어 있으며 라이브러리 혹은 내장 클래스 등 개발자가 직접 제어가
불가능한 클래스인 경우 @Configuration + @Bean을 사용해서 Bean으로 등록


