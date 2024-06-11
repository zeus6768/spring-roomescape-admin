# 기능 요구사항

## 1단계 - 홈 화면

- `localhost:8080/admin` 요청 시 어드민 메인 페이지가 응답할 수 있도록 구현
- `templates/admin/index.html` 파일 이용

<br>

- [x] `/admin`으로 접속하면 `admin/index.html` 페이지로 연결한다.

## 2단계 - 예약 조회

- `/admin/reservation` 요청 시 예약 관리 페이지가 응답할 수 있도록 구현
- `templates/admin/reservation-legacy.html` 파일 이용
- 아래의 API 명세를 따라 예약 관리 페이지 로드 시 호출되는 예약 목록 조회 API도 함께 구현하세요.

<br>

- [x] `/admin/reservation`으로 접속하면 `admin/reservation-legacy.html` 페이지로 연결한다.
- [x] 예약 목록 전체를 조회할 수 있다. 

### API 명세

#### 예약 조회 API

##### Request

```http request
GET /reservations HTTP/1.1
```

##### Response

```http request
HTTP/1.1 200 
Content-Type: application/json

[
    {
        "id": 1,
        "name": "브라운",
        "date": "2023-01-01",
        "time": "10:00"
    },
    {
        "id": 2,
        "name": "브라운",
        "date": "2023-01-02",
        "time": "11:00"
    }
]
```
