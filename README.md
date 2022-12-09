# Sea Turtle Soup

<img width="1260" alt="스크린샷_20221209_055659" src="https://user-images.githubusercontent.com/105546220/206731098-0dea2a3b-add4-4ad3-a30c-77361df2cde1.png">

## 1. 프로젝트의 목적 및 용도

### 이 프로젝트는 무엇을 위한 것인가
'바다거북스프 Sea Turtle Soup'는 유저들끼리 대화하며 문제에 대한 정답을 찾는 추리게임임
클라이언트-서버 모델과 TCP/IP 통신 방식을 이용하여 개발한 채팅 프로그램임

### 어떤 문제를 해결할 수 있는가?
IP 하나만으로 모아진 유저들과 함께 바다거북스프를 플레이 할 수 있음

### 어떤 사람들이 이 프로젝트를 사용하면 좋은가
바다거북스프를 플레이 하고자 하는 사람
바다거북스프 게임 개발에 힘쓰고 싶은 오픈소스 참여자

## 2. 프로그램 구동 환경

### 실행 방법
Windows, TCP/IP 통신

### 개발 환경
Eclipse IDE 통합개발환경, JAVA Swing, SQLite

### 프로그램을 사용하기 위해 설치해야 할 것
JAVA Swing 코드를 작성 및 실행 할 수 있는 IDE 통합개발환경

### Contributor를 위한 안내서
- 프로그램 기본 설명
Sea Turtle Soup는 '바다거북스프'를 채팅 게임으로 구현하기 위한 프로그램
Server code 와 Client Chat code로 구성되어있지만 GitHub에는 Client Chat code만 업로드함
Server code는 SSD팀 외의 인원은 수정 불가

- Contributing 규칙
ide 통합개발환경을 설치하여 코드를 변경하여 바다거북스프 요소를 추가함으로써 프로젝트를 변경함

### Contributor를 위한 명령어 가이드
#### 1. 정해진 브랜치 형식에 맞게 브랜치를 생성
```
$ git branch feat/`이슈번호`/`목차이름` 
```
- ex) git branch feat/#6/문자
#### 2. 브랜치 목록 확인
```
$ git branch // 현재 로컬의 브랜치의 목록 출력 
or
$ git branch -r // 원격 레포지토리의 브랜치 목록 출력
```
#### 3. 브랜치 변경
```
$ git checkout feat/`이슈번호`/`목차이름`
or
$ git switch feat/`이슈번호`/`목차이름`
```
checkout과 switch은 둘 다 브랜치를 변경하는데 사용되지만 
 - checkout은 완료된 작업의 커밋 대상 지정에 중점
 - switch 분기 간의 개발 및 전환에 중점

#### 4. 스테이징, 커밋, 푸쉬
##### 스테이징
```
$ git status // 파일 상태 확인 
```
##### 커밋
```
$ git add feat/`이슈번호`/`기능이름`  // Stage Area에 추가
$ git commit -m `메세지`              // Stage Area에 추가된 파일들을 Commit 
```
- add가 필요한 이유 : Working Directory에 있는 파일을 Stage Area에 추가하기 위하여
- commit의 의미 : Stage Area에 있는 파일들을 로컬 Repository에 적용
##### 푸쉬
```
$ git push origin feat/`이슈번호`/`문자` // 로컬 Repository의 파일들을 원격 저장소에 적용
```
#### 5. Pull Requests 
##### 의미 : 작업한 코드가 있으니 이 코드를 검토 후 병합을 요청
##### 필요한 이유 : 
 - 오픈 소스 프로젝트에 기여할 때
 - 다른 사람의 프로젝트를 사용할 때
 - 협업 시 다른 사람들의 코드 리뷰를 위해
##### 장점 :
 - Merge 전에 코드를 확인하고 각 코드별로 코멘트를 작성 가능
 - 코드 안정성을 높임
##### 사용방법 :
- 다른 사람의 레포지토리를 Fork하고 자신의 로컬에 Clone 후 수정
- 브랜치를 생성하고 add, commit, push 명령어 실행
- Pull Reqeust 작성
- 레포지토리의 주인은 요청받은 수정본이 문제가 없으면 Merge

