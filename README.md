# :deciduous_tree: Camp With Us :deciduous_tree:
* Spring Framework를 사용한 Java Project
## :memo: 프로젝트 소개
* 고캠핑 API를 이용한 캠핑장 검색 및 예약 웹 사이트입니다.

## :gear: 전체 기능
* 캠핑장 검색기능(고캠핑 Api이용)
* 캠핑장 예약 및 결제
* 회원 가입 및 로그인 기능(일반 및 소셜(구글, 네이버, 카카오)) - 일반회원, 관리자 회원
* 회원정보 수정, 탈퇴
* 게시글 작성, 수정, 삭제(여행지 추천 게시판, 캠핑 나눔 게시판, 자유게시판, 공지사항, 문의사항)
* 리뷰 작성, 수정, 삭제
* 캠핑장 정보조회(상세정보, 지도/위치, 날씨, 리뷰)
* 캠핑장 예약정보 작성 페이지(달력, 인원선택, 예약자 정보작성)
* 캠핑장 예약 결제(무통장, 카드결제 선택)
* 캠핑장 예약확인(예약, 예약대기, 취소)
* 추천 캠핑장

## :pushpin: 내가 맡은 기능 - 게시판
### :white_heart: 게시글 작성, 수정, 삭제(CRUD) :white_heart:
  * 게시글 작성 에디터 API - summernote (AJAX를 통해 서버로 이미지 업로드)
  * 게시판 이미지 업로드 - 용량, 개수 제한 설정 (JavaScript 사용)
  * 게시판 슬라이드 - slick-slider (jQuery 슬라이더 라이브러리)
  * 페이스북 위젯 - 페이스북 소셜 플러그인
  * 게시글 댓글, 대댓글 작성(CRUD)

## :computer: 게시판 구현 화면
<p align="center">
	<img src="https://github.com/user-attachments/assets/90ca1ece-c014-454a-8f53-3fe2e3fccff2" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/0b4d93a1-2f5b-43d0-8d43-052942dbe99b" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/272a0c44-5d25-431f-977b-e7df412c4dec" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/1461da83-2d61-43e9-b0f3-47b4e777caa7" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/68593868-fe0e-410d-9d4d-195dc55ea2c2" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/e64af0c8-01c7-474b-a1e6-df01f0524850" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/23d1a51e-19db-40e4-b944-121a6057ca6b" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/39545713-b792-44e7-91aa-12aaf47a0efd" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/b49cd5a5-7791-42b4-b98c-4ca7f8c4be26" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/951139a6-3ba9-41e7-8912-f7709ea4889e" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/748eb393-1b5e-442e-9e8a-13b737ede30f" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/da74ff0f-91f5-42e1-b1bb-125cd15b238f" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/429b1e77-4a5a-41ca-a019-c7a69a44a29f" width="90%" height="90%"/>
	<img src="https://github.com/user-attachments/assets/5726482e-5655-4f4f-8894-b50d84881e85" width="90%" height="90%"/>
</p>
 
## :dart: 트러블 슈팅
### :boom: 게시글 썸네일 이미지
#### :interrobang: 문제와 원인
```
게시글을 List로 불러올 때
게시글에 포함된 첫 번째 이미지를 썸네일로 사용하려 했으나 불러와지지 않았다.
DB에 전달되는 이미지 파일 중 첫 번째 이미지(썸네일)만 저장하는 테이블을 만들어
저장하고 불러오려 했으나 이미지가 불러와지지 않았다.
```
#### :100: 해결 방법
```
게시글에 사진을 첨부할 때 첫 번째 이미지를 thumbnail 로,
나머지를 file 이라는 이름으로 컬렉션에 저장 후 AJAX로 넘겨주었다.
게시글이 저장되는 VO에 thumbnailImg 을 추가하고
게시글 목록을 불러올 때 Service 단에서 정규식을 통해 이미지 태그 중 첫 번째 이미지 태그의
src 만 걸러내 게시글 목록 VO의 thumbnailImg 에 저장해줌으로써 해결할 수 있었다.
```

### :boom: 게시글 이미지 업로드
#### :interrobang: 문제와 원인
<p align="center">
<img width="80%" src="https://github.com/juuuo/git_test/assets/125864004/1bf49e29-ea32-46b6-9bfa-3c09fa6216aa"/>
<img width="80%" src="https://github.com/juuuo/git_test/assets/125864004/37eb2e77-527d-40ef-8f47-65f8f5aabd1d"/>
</p>

```
summernote API에 이미지 업로드시
업로드 된 3장의 이미지 저장 경로를 imgPath에 모두 담아 AJAX에 전송하려는데
항상 마지막 이미지 저장 경로만 전송되었다.
```
#### :100: 해결 방법
#### ☑ 원래 사용하던 방식
<p align="center">
<img width="80%" src="https://github.com/juuuo/git_test/assets/125864004/66d1445f-e449-4ac3-9cf6-f4db48244103"/>
</p>

#### ✅ 수정한 방식
<p align="center">
<img width="80%" src="https://github.com/juuuo/git_test/assets/125864004/b8ec30d4-32ec-49b5-89ae-f7c3731f99c2"/>
<img width="80%" src="https://github.com/juuuo/git_test/assets/125864004/016ea44d-50bd-42cf-943f-2c9f5804c780"/>
</p>

```
처음에는 jsonArray에 jsonObject를 담아서 AJAX에 보내는 방식으로 진행했다.
매번 추가된 이미지 전부가 아닌 마지막 이미지 저장 경로만 AJAX에 전송되어
그 원인을 찾아본 결과

jsonObject 는 key:value 값으로 저장되며 동일한 key값을 사용할 수 없는데
jsonObject.addProperty를 사용해서 계속 같은 key(url)에
다른 value인 이미지 저장 경로들을 담으니까
제일 마지막에 add된 이미지 저장 경로만 남게됬던 것이였다.

따라서 처음 올라가는 이미지 저장 경로를
ArrayList(ajaxImgPaths)에 담아서 AJAX로 값을 전달했다.
```

<br>

***
<div align="center">
    <div align="center">
    Tech Stack<br>
</div>
	<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white" />
	<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white" />
	<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white" />
	<img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat&logo=javascript&logoColor=white" />
  <img src="https://img.shields.io/badge/Oracle SQL-F80000?style=flat&logo=oracle&logoColor=white" />
  <img src="https://img.shields.io/badge/jQuery-0769AD?style=flat&logo=jquery&logoColor=white" />
</div>
<br>
<div align="center">
    <div align="center">
    Tools & WAS <br>
</div>
<div align="center">
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white" />
    <img src="https://img.shields.io/badge/eclipseIDE-2C2255?style=flat&logo=eclipseide&logoColor=white" />
    <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat&logo=visualstudiocode&logoColor=white" />
    <img src="https://img.shields.io/badge/Apache&nbsp;Tomcat-F8DC75?style=flat&logo=apachetomcat&logoColor=black" />
</div>
<br>
<div align="center">
  <div align="center">
  Collaborations<br>
</div>
<div align="center">
    <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white" />
    <img src="https://img.shields.io/badge/amazon AWS-232F3E?style=flat&logo=amazonaws&logoColor=white" />
    <img src="https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white" />
</div>
  
***
