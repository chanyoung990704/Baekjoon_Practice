# [level 3] 즐겨찾기가 가장 많은 식당 정보 출력하기 - 131123 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131123) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 05월 27일 15:58:29

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none;">다음은 식당의 정보를 담은 <code style="font-family: D2Coding; font-variant-ligatures: none;">REST_INFO</code> 테이블입니다. <code style="font-family: D2Coding; font-variant-ligatures: none;">REST_INFO</code> 테이블은 다음과 같으며 <code style="font-family: D2Coding; font-variant-ligatures: none;">REST_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">REST_NAME</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">FOOD_TYPE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">VIEWS</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">FAVORITES</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">PARKING_LOT</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">ADDRESS</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">TEL</code>은 식당 ID, 식당 이름, 음식 종류, 조회수, 즐겨찾기수, 주차장 유무, 주소, 전화번호를 의미합니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">REST_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(5)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">REST_NAME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(50)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FOOD_TYPE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(20)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VIEWS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NUMBER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FAVORITES</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NUMBER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">PARKING_LOT</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(1)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">ADDRESS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(100)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TEL</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(100)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
</tbody>
      </table>
<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">문제</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">REST_INFO</code> 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문을 작성해주세요. 이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.</p>

<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">REST_INFO</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">REST_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">REST_NAME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">FOOD_TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">VIEWS</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">FAVORITES</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">PARKING_LOT</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">ADDRESS</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">TEL</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">00001</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">은돼지식당</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">한식</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1150345</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">734</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">서울특별시 중구 다산로 149</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">010-4484-8751</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">00002</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">하이가쯔네</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">일식</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">120034</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">112</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">서울시 중구 신당동 375-21</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">00003</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">따띠따띠뜨</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">양식</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1234023</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">102</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">서울시 강남구 신사동 627-3 1F</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">02-6397-1023</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">00004</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">스시사카우스</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">일식</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1522074</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">230</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">서울시 서울시 강남구 신사동 627-27</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">010-9394-2554</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">00005</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">코슌스</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">일식</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">15301</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">123</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">서울특별시 강남구 언주로153길</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">010-1315-8729</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">FOOD_TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">REST_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">REST_NAME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">FAVORITES</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">한식</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">00001</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">은돼지식당</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">734</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">일식</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">00004</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">스시사카우스</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">230</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">양식</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">00003</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">따띠따띠뜨</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">102</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges