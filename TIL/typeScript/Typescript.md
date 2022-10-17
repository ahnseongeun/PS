# 타입 스크립트

## 타입 스트크립가 존재하는 이유
- 타입 안정성
  - 런타임 에러 감소 -> 생산성 증가
- EX
```javascript
    function divide(a, b) {
        return a / b
    }
    divide("input data")
    
    => result : NaN
    여기서 자바스크립트의 문제점은 함수의 parameter가 a, b로 두가지가 있는데 argument가 하나인데도 검사를 하지 않는다는 점이다.
```

## 타입 스크립트의 작동 방식
- 타입스크립트의 경우에는 작성한 코드가 자바스크립트로 변환된다.
- 타입스크립트가 먼저 코드를 확인 후 변환 전에 에러를 찾아낸다.
- 브라우저는 타입스크립트가 아닌 자바스크립트를 인식한다.

## 2.0 How Typescript Works

```javascript
const nico = {
    nickname: "nick"
}
nico.hello()
`=> javascript는 런타임 중에 발견하지만 typescript는 문법적인 에러를 표시한다.
```

```javascript
const add = [1,2,3,4] + false;
`javascript는 에러없이 1,2,3,4false를 출력하지만 typescript는 숫자 배열에 boolean을 더할 수 없다는 에러 표시. 또한, 컴파일 조차 안된다.`
```

## 2.1 Implicit Types vs Explicit Types
```javascript
let a = "hello"
a = 1;
`=> javascript는 에러가 없지만 typescript는 에러가 존재한다.`

let b : boolean = "x"
`=> typescript에서는 에러가 난다. b가 boolean이기 때문
이다.`

let c = [1, 2, 3]
c.push("1")
`=> javascript는 [ 1, 2, 3, '1' ]의 결과를 return 하지만 typescript는 문법적인 에러를 표시한다.`
```