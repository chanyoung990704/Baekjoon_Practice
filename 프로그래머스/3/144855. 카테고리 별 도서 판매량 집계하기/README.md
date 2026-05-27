# [level 3] 카테고리 별 도서 판매량 집계하기 - 144855 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/144855) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 05월 27일 16:07:39

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none;">다음은 어느 한 서점에서 판매중인 도서들의 도서 정보(<code style="font-family: D2Coding; font-variant-ligatures: none;">BOOK</code>), 판매 정보(<code style="font-family: D2Coding; font-variant-ligatures: none;">BOOK_SALES</code>) 테이블입니다.</p>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">BOOK</code> 테이블은 각 도서의 정보를 담은 테이블로 아래와 같은 구조로 되어있습니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Nullable</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Description</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">BOOK_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">도서 ID</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">CATEGORY</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">카테고리 (경제, 인문, 소설, 생활, 기술)</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">AUTHOR_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">저자 ID</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">PRICE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">판매가 (원)</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">PUBLISHED_DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">출판일</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">BOOK_SALES</code> 테이블은 각 도서의 날짜 별 판매량 정보를 담은 테이블로 아래와 같은 구조로 되어있습니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Nullable</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Description</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">BOOK_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">도서 ID</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">SALES_DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">판매일</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">SALES</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">판매량</td>
</tr>
</tbody>
      </table>
<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">문제</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">2022년 1월</code>의 카테고리 별 도서 판매량을 합산하고, 카테고리(<code style="font-family: D2Coding; font-variant-ligatures: none;">CATEGORY</code>), 총 판매량(<code style="font-family: D2Coding; font-variant-ligatures: none;">TOTAL_SALES</code>) 리스트를 출력하는 SQL문을 작성해주세요. <br>
결과는 카테고리명을 기준으로 오름차순 정렬해주세요.</p>

<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;">예를 들어 <code style="font-family: D2Coding; font-variant-ligatures: none;">BOOK</code> 테이블과 <code style="font-family: D2Coding; font-variant-ligatures: none;">BOOK_SALES</code> 테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">BOOK_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">CATEGORY</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">AUTHOR_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">PRICE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">PUBLISHED_DATE</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">인문</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">10000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2020-01-01</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">경제</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">9000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021-02-05</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">경제</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">9000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021-03-11</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">BOOK_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">SALES_DATE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">SALES</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-01</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-02</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-05</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-20</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">5</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-21</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">6</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-22</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-02-11</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">2022년 1월의 도서 별 총 판매량은 도서 ID 가 1 인 도서가 총 3권, 도서 ID 가 2 인 도서가 총 14권 이고, 도서 ID 가 3 인 도서가 총 2권 입니다.</p>

<p style="font-family: Pretendard; font-variant-ligatures: none;">카테고리 별로 판매량을 집계한 결과는 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">CATEGORY</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">TOTAL_SALES</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">인문</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">경제</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">16</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">카테고리명을 오름차순으로 정렬하면 다음과 같이 나와야 합니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">CATEGORY</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">TOTAL_SALES</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">경제</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">16</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">인문</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges