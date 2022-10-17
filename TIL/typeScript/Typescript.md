# 타입 스크립트

## 타입 스트크립가 존재하는 이유
- 타입 안정성
    - 런타임 에러 감소 -> 생산성 증가
```javascript
    function divide(a, b) {
        return a / b
    }
    divide("input data");
    
    => result : NaN
    `여기서 자바스크립트의 문제점은 함수의 parameter가 a, b로 두가지가 있는데 argument가 하나인데도 검사를 하지 않는다는 점이다.`
```