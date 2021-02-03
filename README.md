# SpringAsync


### 서로 다른 ThreadPool을 사용해서 불규칙적인 순서로 로그를 찍는것을 확인 할 수 있다.
GET http://localhost:8080/thread/test1

### 동기로 작동하는 잘못된 Async 사용 사례
GET http://localhost:8080/thread/test2

### ListenableFutere 성공 테스트 (5초 후 문자열 반환)
GET http://localhost:8080/thread/test?name="박동현" 

### ListenableFuter Exception 테스트 (5초 후 Exception 반환)
GET http://localhost:8080/thread/test/exception
