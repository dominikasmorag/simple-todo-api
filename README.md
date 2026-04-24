# To Do App (Spring Boot + Docker)
### Tech Stack:
* Java 21
* Spring Boot
* PostgreSQL
* Maven
* Docker

***

### Run the app

`.\mvnw.cmd clean package -DskipTests`

`docker compose up -d --build`

App will be available on port 8080

`http://localhost:8080`

---

### API endpoints
Get all tasks

`GET /tasks`

Get task by id

`GET /tasks/{id}`

Get not done tasks

`GET /tasks/not-done`

Add new task

`POST /tasks 
  Content-Type: application/json { "name": "Learn Docker", "done": false }`

Delete task

`DELETE /tasks/{id}`
