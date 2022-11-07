# CSS Flex( Flexible Box ) 완벽 가이드


## CSS3 Flexible Box
#### Flex는 요소의 크기가 불분명하거나 동적인 경우에도, 각 요소를 정렬할 수 있는 효율적인 방법을 제공한다.
___
__1. Containter__
> Items를 감싸는 부모 요소, Item 정렬을 위한 박스 
> display, flex-flow(flex-direction, flex-wrap), justify-content, align-items 등의 속성을 사용

__2. Items__
> order, flex(flex-grow, flex-shrink, flex-basis), align-self 등의 속성

__Example )__ Item들의 수평 요소를 구성하고 싶을 때

```HTML
<div class="box-container">
    <div class="box"></div>
    <div class="box"></div>
    <div class="box"></div>
</div>

.box-container {
    display: flex;
}
```

## Flex Container
|속성|의미|
|---|---|
|display| Flex Container를 정의|
|flex-flow| flex-direction과 flex-wrap이 단축 속성|
|flex-direction| Flex Items의 주 축(main-axis)을 설정|
|flex-wrap| Flex Items의 여러 줄 묶음(줄 바꿈) 설정|
|justify-content| 주 축의 정렬 방법을 설정|
|align-content| 교차 축의 정렬 방법을 설정(2줄 이상)|
|align-items| 교차 축에서 Items의 정렬 방법을 설정(1줄)|
___

#### display
- display: flex
  - container가 수직 쌓음을 갖는다.
- display: inline-flex
  - container가 수평 쌓음을 갖는다.
___    

#### flex-flow
- flex-direction, flex-wrap 순서
```css
.flex-container {
    flex-flow: row-reverse wrap
}
```
___

#### flex-direction
|값|의미|  
|---|---|
|row| Items를 수평축으로 표시 왼 => 오|
|row-reverse| Items를 수평축으로 표시 오 => 왼|
|column| Items를 수직축으로 표시 위 => 아래|
|column-reverse| Items를 수평축으로 표시 아래 => 위|
___

#### flex-wrap
- Items는 한 줄에서만 표시되고 줄 바꿈은 되지 않습니다.
이는 지정된 크기(주 축에 따라 width나 height)를 무시하고 한 줄 안에서만 변한다.
Items를 줄 바꿈 하려면 값으로 wrap을 사용해아한다.  

|값|의미|  
|---|---|
|nowrap| 모든 Items를 여러 줄로 묶지 않음 (한 줄에 표시)|
|wrap| Items를 여러 줄로 묶음|
|wrap-reverse| Items wrap의 역방향으로 여러 줄로 묶음|
___

#### justify-content
|값|의미|  
|---|---|
|flex-start|Items를 시작점(flex-start)으로 정렬|
|flex-end|Items를 끝점(flex-end)으로 정렬|
|center|Items를 가운데 정렬|
|space-between|시작 Item은 시작점에, 마지막 Item은 끝점에 정렬되고 나머지 Items는 사이에 고르게 정렬됨|
|space-around|Items 균등한 여백을 포함하여 정렬|
___

#### align-content
- 교차 축의 정렬 방법을 설정, flex-wrap 속성을 통해 Items가 여러 줄이고 여백이 있을 경우만 사용 가능

|값|의미|  
|---|---|
|stretch|Container의 교차 축을 채우기 위해 Items를 늘림|
|flex-start|Items를 시작점(flex-start)으로 정렬|
|flex-end|Items를 끝점(flex-end)으로 정렬|
|center|Items를 가운데 정렬|
|space-between|시작 Item은 시작점에, 마지막 Item은 끝점에 정렬되고 나머지 Items는 사이에 고르게 정렬됨|
|space-around|Items를 균등한 여백을 포함하여 정렬|
___

#### align-items
- 교차 축에서 Items의 정렬 방법을 설정, Items가 한 줄일 경우 많이 사용한다. 
- Items가 flex-wrap을 통해 여러 줄일 경우에는 align-content 속성이 우선, align-items를 사용하려면
align-content 속성을 기본값으로 설정 해아한다.

|값|의미|  
|---|---|
|stretch|Container의 교차 축을 채우기 위해 Items를 늘림|
|flex-start|Items를 시작점(flex-start)으로 정렬|
|flex-end|Items를 끝점(flex-end)으로 정렬|
|center|Items를 가운데 정렬|
|space-between|시작 Item은 시작점에, 마지막 Item은 끝점에 정렬되고 나머지 Items는 사이에 고르게 정렬됨|
|space-around|Items를 균등한 여백을 포함하여 정렬|
___

## Flex-items
|속성|의미|  
|---|---|
|order|Flex Item의 순서를 결정|
|flex|flex-grow, flex-shrink, flex-basis의 단축 속성|
|flex-grow|Flex Item의 증가 너비 비율을 설정|
|flex-shrink|Flex Item의 감소 너비 비율을 설정|
|flex-basis|Flex Item의 기본 너미 설정|
|align-self|교차 축에서 Item의 정렬 방법을 설정|
___

#### Order
- Item의 순서를 설정, Item에 숫자를 지정하고 숫자가 클수록 순서가 밀린다.

#### flex
- flex-grow는 Item의 증가 너비 비율을 설정
- flex-shrink Item의 감소 너비 비율을 설정
- flex-basis Item의 기본 너비 설정

#### align-self
- align-items는 Container 내 모든 Items의 정렬 방법을 설정하지만
일부 Item만 정렬 방법을 변경하려고 할 경우 align-self를 사용한다.

|속성|의미|  
|---|---|
|auto|Container의 align-items 속성을 상속 받음|
|stretch|Container의 교차 축을 채우기 위해 Item을 늘림|
|flex-start|Item을 각 줄의 시작점으로 정렬|
|flex-end|Item을 각 줄의 끝점으로 정렬|
|center|Item을 가운데 정렬|
|baseline|Item을 문자 기준선에 정렬|
___
  

#### 참조 링크
- https://heropy.blog/2018/11/24/css-flexible-box/    




