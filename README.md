# SpringAsync

Config설정
 * @Async 어노테이션을 사용해 메서드를 비동기로 호출할경우
 * ThreadPool을 명시적으로 선언하지 않으면 기본적으로 SimpleAyncTaskExecutor를 사용하는데
 * 각 비동기 호출마다 계속 새로운 쓰레드를 생성하므로 비효율적일 수 있다.
 * 비동기 호출 빈도에 따라서 설정을 하느냐 마느냐 할것같다.
 * SpringBoot 2.0 이상이라면 Config를 작성하던지, yml을 수정하던지 둘 중 하나만 해도 적용된다.
 
 
<br>

## API Test
### 서로 다른 ThreadPool을 사용해서 불규칙적인 순서로 로그를 찍는것을 확인 할 수 있다.
GET http://localhost:8080/thread/test1

### 동기로 작동하는 잘못된 Async 사용 사례
GET http://localhost:8080/thread/test2

### ListenableFutere 성공 테스트 (5초 후 문자열 반환)
GET http://localhost:8080/thread/test?name=박동현

### ListenableFuter Exception 테스트 (5초 후 Exception 반환)
GET http://localhost:8080/thread/test/exception
