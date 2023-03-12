
# Spring Boot Rest API application




![Logo](https://weirdocourses.com/wp-content/uploads/2022/04/WeirdOCourses__2___1_-removebg-preview.png)




![YouTube Channel Subscribers](https://img.shields.io/youtube/channel/subscribers/UCaLWjfwq-Spe4L31KIG_1Eg?style=social)
![Twitter Follow](https://img.shields.io/twitter/follow/weirdocourses?style=social)
![Discord](https://img.shields.io/discord/1004842692645232680)
![GitHub](https://img.shields.io/github/license/WeirdOCourses/SpringBootRestAPI)


## API Reference

#### Get all Candidates

```http
  GET /api/v1/candidates
```

#### Get Candidates by their Name

```http
  GET /api/v1/candidates
```

| QUERY Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `candidateName`      | `string` | **Required**. Candidate Name to fetch |

#### Get Candidates by their Id

```http
  GET /api/v1/candidates/{id}
```

| URI Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Candidate Id to fetch |

#### Post one candidate

```http
  POST /api/v1/candidates
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `candidateName`      | `String` | **Required**|
| `candidate_score`      | `double` | **Required**|
| `is_successful`      | `boolean` | **Required**|

#### Post many candidates at once

```http
  POST /api/v1/allcandidates
```
Using Array
| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `candidateName`      | `String` | **Required**|
| `candidate_score`      | `double` | **Required**|
| `is_successful`      | `boolean` | **Required**|

#### Update candidates by their name

```http
  PUT /api/v1/candidates
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `candidateName`      | `String` | **Required**|
| `candidate_score`      | `double` | **Required**|
| `is_successful`      | `boolean` | **Required**|

| QUERY Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `candidateName`      | `string` | **Required**. Candidate Name to fetch |

#### Update candidates by their id

```http
  PUT /api/v1/candidates/{id}
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `candidateName`      | `String` | **Required**|
| `candidate_score`      | `double` | **Required**|
| `is_successful`      | `boolean` | **Required**|

| URI Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Candidate Id to fetch |

#### Delete candidates by their id

```http
  Delete /api/v1/candidates/{id}
```
| URI Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Candidate Id to fetch |












## Tools Used

- Spring Tool Suite (STS) IDE
- Java
- Maven
- Postman
- MySQL Workbench & MySQL Server


## Libraries /Dependencies Used

- Spring Web

- Spring Data JPA

- MySQL Driver

- Spring Boot DevTools


## Authors

- [@WeirdOCourses](https://www.weirdocourses.com)


## Video

[Youtube Video Link](https://youtu.be/tX8_wdA-DqY)


## Feedback

If you have any feedback, please reach out to us at weirdo.courses@gmail.com

