Сервер запущен так:
mvn clean package
mvn spring-boot:run

Листинг с curl запросами к сервису:
Задание на оценку 3 листинг команд:

C:\Users\Xiaomi>curl.exe -i -X PUT -H "Content-Type: text/plain" -d "New text" "http://localhost:8080/messages/0"
HTTP/1.1 202
Content-Length: 0
Date: Mon, 01 Dec 2025 21:28:33 GMT


C:\Users\Xiaomi>curl.exe -i -X POST -H "Content-Type: text/plain" -d "Hello world" "http://localhost:8080/messages"
HTTP/1.1 202
Content-Length: 0
Date: Mon, 01 Dec 2025 21:30:04 GMT


C:\Users\Xiaomi>curl.exe -i "http://localhost:8080/messages"
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 01 Dec 2025 21:30:55 GMT

["New text","Hello world"]
C:\Users\Xiaomi>curl.exe -i "http://localhost:8080/messages/0"
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 8
Date: Mon, 01 Dec 2025 21:31:24 GMT

New text
C:\Users\Xiaomi>curl.exe -i -X DELETE "http://localhost:8080/messages/1"
HTTP/1.1 204
Date: Mon, 01 Dec 2025 21:31:33 GMT


C:\Users\Xiaomi>curl.exe -i "http://localhost:8080/messages"
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 01 Dec 2025 21:31:36 GMT

["New text"]
C:\Users\Xiaomi>curl.exe -i -X PUT -H "Content-Type: text/plain" -d "New text" "http://localhost:8080/messages/0"
HTTP/1.1 202
Content-Length: 0
Date: Mon, 01 Dec 2025 21:31:47 GMT


C:\Users\Xiaomi>curl.exe -i "http://localhost:8080/messages"
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 01 Dec 2025 21:31:52 GMT



Задание на оценку 4 листинг команд:

["New text"]
C:\Users\Xiaomi>curl.exe -i "http://localhost:8080/messages/search/Hello"
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 01 Dec 2025 21:32:07 GMT

-1
C:\Users\Xiaomi>



Задание на оценку 5 листинг команд:
C:\Users\Xiaomi>curl.exe -i -X POST -H "Content-Type: application/json" -d "{\"name\":\"Ivan\",\"age\":25}" "http://localhost:8080/users"
HTTP/1.1 202
Content-Length: 0
Date: Mon, 01 Dec 2025 21:34:41 GMT


C:\Users\Xiaomi>curl.exe -i "http://localhost:8080/users"
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 01 Dec 2025 21:34:55 GMT

[{"name":"Ivan","age":25}]
C:\Users\Xiaomi>
C:\Users\Xiaomi>
C:\Users\Xiaomi>curl.exe -i "http://localhost:8080/users/0"
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 01 Dec 2025 21:35:06 GMT

{"name":"Ivan","age":25}
C:\Users\Xiaomi>
C:\Users\Xiaomi>
C:\Users\Xiaomi>
C:\Users\Xiaomi>curl.exe -i -X PUT -H "Content-Type: application/json" -d "30" "http://localhost:8080/users/0/age"
HTTP/1.1 202
Content-Length: 0
Date: Mon, 01 Dec 2025 21:35:15 GMT


C:\Users\Xiaomi>
C:\Users\Xiaomi>
C:\Users\Xiaomi>
C:\Users\Xiaomi>curl.exe -i -X DELETE "http://localhost:8080/users/0"
HTTP/1.1 204
Date: Mon, 01 Dec 2025 21:35:22 GMT
C:\Users\Xiaomi>






