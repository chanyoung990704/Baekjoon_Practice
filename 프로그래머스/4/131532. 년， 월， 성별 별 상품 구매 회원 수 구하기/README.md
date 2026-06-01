# [level 4] 년, 월, 성별 별 상품 구매 회원 수 구하기 - 131532 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131532) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 06월 01일 11:58:55

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none;">다음은 어느 의류 쇼핑몰에 가입한 회원 정보를 담은 <code style="font-family: D2Coding; font-variant-ligatures: none;">USER_INFO</code> 테이블과 온라인 상품 판매 정보를 담은 <code style="font-family: D2Coding; font-variant-ligatures: none;">ONLINE_SALE</code> 테이블 입니다.<code style="font-family: D2Coding; font-variant-ligatures: none;">USER_INFO</code> 테이블은 아래와 같은 구조로 되어있으며 <code style="font-family: D2Coding; font-variant-ligatures: none;">USER_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">GENDER</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">AGE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">JOINED</code>는 각각 회원 ID, 성별, 나이, 가입일을 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">USER_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">GENDER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TINYINT(1)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">AGE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">JOINED</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">GENDER</code> 컬럼은 비어있거나 0 또는 1의 값을 가지며 0인 경우 남자를, 1인 경우는 여자를 나타냅니다.</p>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">ONLINE_SALE</code> 테이블은 아래와 같은 구조로 되어있으며, <code style="font-family: D2Coding; font-variant-ligatures: none;">ONLINE_SALE_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">USER_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">PRODUCT_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">SALES_AMOUNT</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">SALES_DATE</code>는 각각 온라인 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일을 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">ONLINE_SALE_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">USER_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">PRODUCT_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">SALES_AMOUNT</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">SALES_DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">동일한 날짜, 회원 ID, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재합니다.</p>

<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">문제</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">USER_INFO</code> 테이블과 <code style="font-family: D2Coding; font-variant-ligatures: none;">ONLINE_SALE</code> 테이블에서 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문을 작성해주세요. 결과는 년, 월, 성별을 기준으로 오름차순 정렬해주세요. 이때, 성별 정보가 없는 경우 결과에서 제외해주세요.</p>

<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;">예를 들어 <code style="font-family: D2Coding; font-variant-ligatures: none;">USER_INFO</code> 테이블이 다음과 같고</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">USER_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">GENDER</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">AGE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">JOINED</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">26</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021-06-01</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NULL</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NULL</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021-06-25</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NULL</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021-06-30</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">4</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">31</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021-07-03</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">5</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">25</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021-07-09</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">6</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">33</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021-07-14</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">ONLINE_SALE</code> 테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">ONLINE_SALE_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">USER_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">PRODUCT_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">SALES_AMOUNT</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">SALES_DATE</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">54</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-01</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-25</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">4</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">34</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-01-30</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">4</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">6</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">253</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-02-03</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">5</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">31</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-02-09</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">6</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">5</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">35</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-02-14</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">7</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">5</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">57</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022-02-18</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">2022년 1월에 상품을 구매한 회원은 <code style="font-family: D2Coding; font-variant-ligatures: none;">USER_ID</code> 가 1(<code style="font-family: D2Coding; font-variant-ligatures: none;">GENDER</code>=1), 4(<code style="font-family: D2Coding; font-variant-ligatures: none;">GENDER</code>=0)인 회원들이고,<br>
2022년 2월에 상품을 구매한 회원은 <code style="font-family: D2Coding; font-variant-ligatures: none;">USER_ID</code> 가 2(<code style="font-family: D2Coding; font-variant-ligatures: none;">GENDER</code>=NULL), 5(<code style="font-family: D2Coding; font-variant-ligatures: none;">GENDER</code>=1), 6(<code style="font-family: D2Coding; font-variant-ligatures: none;">GENDER</code>=1)인 회원들 이므로,</p>

<p style="font-family: Pretendard; font-variant-ligatures: none;">년, 월, 성별 별로 상품을 구매한 회원수를 집계하고, 년, 월, 성별을 기준으로 오름차순 정렬하면 다음과 같은 결과가 나와야 합니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">YEAR</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">MONTH</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">GENDER</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">USERS</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges