# CSS Flex( Flexible Box ) 완벽 가이드


## 1. CSS3 Flexible Box
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

