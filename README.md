Day 27: Testing
단위 테스트에 대한 문제
첫번째 클래스인 TestDataEmptyArray
- 배열이 비었는지 확인하는 기능
두번째 클래스인 TestDataUniqueValues는
- 배열의 원소가 2개 이상인지 확인하는 기능
- 모든 배열의 원소가  unique한지 확인하는 기능
- 최소값의 인덱스가 예상한 인덱스가 맞는지 확인하는 기능 
세번째 클래스인  TestWithExactlyTwoDifferentMinimums는
- 배열의 언소가 2개 이상인지 확인하는 기능
- 배열을 정렬하고 최소값이 2개가 맞는 확인하는 기능
- 최소값의 인덱스가 예상한 인덱스가 맞는지 확인하는 기능


해결 과정
첫번째 클래스에서 minimum_index에서 배열의 크기가 0보다 크다면 예외 처리가 발생하지 않아서
```
throw new AssertionError("Exception wasn't thrown as expected");가 실행되서 에러가 난다.
```

두번째 클래스에서 배열의 원소가 다르게 최소 2개 이상 테스트 케이스를 넣고  minimum_index를 이용해서
그 중 가장 작은 값의 인덱스와 같은지 비교하도록 테스트 케이스를 작성한다.

세번째 클래스에서 배열의 원소에서 최소값이 될 값을 2개 이상으로 테스트 케이스를 작성하고  
나머지는 최소값 보다 큰 값으로 채운다.
최소값이 두개인지 확인하고 최소값의 인덱스가 0이 맞는지 확인하는 테스트 케이스를 작성한다.