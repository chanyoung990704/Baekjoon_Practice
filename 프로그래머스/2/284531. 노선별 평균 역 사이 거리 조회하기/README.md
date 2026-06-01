# [level 2] 노선별 평균 역 사이 거리 조회하기 - 284531 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284531) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 06월 01일 12:32:33

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">SUBWAY_DISTANCE</code> 테이블은 서울지하철 2호선의 역 간 거리 정보를 담은 테이블입니다. <code style="font-family: D2Coding; font-variant-ligatures: none;">SUBWAY_DISTANCE</code> 테이블의 구조는 다음과 같으며 <code style="font-family: D2Coding; font-variant-ligatures: none;">LINE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">NO</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">ROUTE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">STATION_NAME</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">D_BETWEEN_DIST</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">D_CUMULATIVE</code>는 각각 호선, 순번, 노선, 역 이름, 역 사이 거리, 노선별 누계 거리를 의미합니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">LINE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(10)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NO</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NUMBER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">ROUTE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(50)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">STATION_NAME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(100)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FLASE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">D_BETWEEN_DIST</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NUMBER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FLASE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">D_CUMULATIVE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NUMBER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FLASE</td>
</tr>
</tbody>
      </table>
<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">문제</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">SUBWAY_DISTANCE</code> 테이블에서 노선별로 노선, 총 누계 거리, 평균 역 사이 거리를 노선별로 조회하는 SQL문을 작성해주세요.</p>

<p style="font-family: Pretendard; font-variant-ligatures: none;">총 누계거리는 테이블 내 존재하는 역들의 <code style="font-family: D2Coding; font-variant-ligatures: none;">역 사이 거리</code>의 총 합을 뜻합니다. 총 누계 거리와 평균 역 사이 거리의 컬럼명은 각각 <code style="font-family: D2Coding; font-variant-ligatures: none;">TOTAL_DISTANCE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">AVERAGE_DISTANCE</code>로 해주시고, 총 누계거리는 소수 둘째자리에서, 평균 역 사이 거리는 소수 셋째 자리에서 반올림 한 뒤 단위(km)를 함께 출력해주세요.<br>
결과는 총 누계 거리를 기준으로 내림차순 정렬해주세요.</p>

<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">SUBWAY_DISTANCE</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">LINE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">NO</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">ROUTE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">STATION_NAME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">D_BETWEEN_DIST</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">D_CUMULATIVE</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2호선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">45</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">성수지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">용답</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2.3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">51.1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2호선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">46</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">성수지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">신답</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">52.1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2호선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">47</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">성수지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">용두(동대문구청)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0.9</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">53</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2호선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">48</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">성수지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">신설동</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1.2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">54.2</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2호선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">49</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">신정지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">도림천</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">55.2</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2호선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">50</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">신정지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">양천구청</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1.7</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">56.9</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2호선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">51</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">신정지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">신정네거리</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1.9</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">58.8</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2호선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">52</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">신정지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">까치산</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1.4</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">60.2</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">ROUTE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">TOTAL_DISTANCE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">AVERAGE_DISTANCE</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">신정지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">6km</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1.5km</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">성수지선</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">5.4km</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1.35km</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges