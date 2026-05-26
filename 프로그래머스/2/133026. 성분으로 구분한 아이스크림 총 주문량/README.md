# [level 2] 성분으로 구분한 아이스크림 총 주문량 - 133026 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/133026) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 05월 26일 14:38:31

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">다음은 아이스크림 가게의 상반기 주문 정보를 담은 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FIRST_HALF</code> 테이블과 아이스크림 성분에 대한 정보를 담은 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ICECREAM_INFO</code> 테이블입니다. <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FIRST_HALF</code> 테이블 구조는 다음과 같으며, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">SHIPMENT_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TOTAL_ORDER</code> 는 각각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량을 나타냅니다. <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FIRST_HALF</code> 테이블의 기본 키는 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</code>입니다.</p>
<table class="table">
        <thead><tr>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NAME</th>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULLABLE</th>
</tr>
</thead>
        <tbody><tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">SHIPMENT_ID</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INT(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TOTAL_ORDER</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INT(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;"><code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ICECREAM_INFO</code> 테이블 구조는 다음과 같으며, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INGREDITENT_TYPE</code> 은 각각 아이스크림 맛, 아이스크림의 성분 타입을 나타냅니다. <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INGREDIENT_TYPE</code>에는 아이스크림의 주 성분이 설탕이면 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">sugar_based</code>라고 입력되고, 아이스크림의 주 성분이 과일이면 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</code>라고 입력됩니다. <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ICECREAM_INFO</code>의 기본 키는 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</code>입니다. <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ICECREAM_INFO</code>테이블의 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</code>는 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FIRST_HALF</code> 테이블의  <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</code>의 외래 키입니다.</p>
<table class="table">
        <thead><tr>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NAME</th>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULLABLE</th>
</tr>
</thead>
        <tbody><tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INGREDIENT_TYPE</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
</tbody>
      </table>
<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">문제</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회하는 SQL 문을 작성해주세요. 이때 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정해주세요.</p>

<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">예를 들어 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FIRST_HALF</code> 테이블이 다음과 같고</p>
<table class="table">
        <thead><tr>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">SHIPMENT_ID</th>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TOTAL_ORDER</th>
</tr>
</thead>
        <tbody><tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">101</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">chocolate</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">3200</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">102</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">vanilla</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2800</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">103</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">mint_chocolate</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">1700</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">104</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">caramel</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2600</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">105</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">white_chocolate</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">3100</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">106</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">peach</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2450</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">107</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">watermelon</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2150</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">108</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">mango</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2900</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">109</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">strawberry</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">3100</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">110</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">melon</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">3150</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">111</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">orange</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2900</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">112</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">pineapple</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2900</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;"><code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ICECREAM_INFO</code> 테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FLAVOR</th>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INGREDIENT_TYPE</th>
</tr>
</thead>
        <tbody><tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">chocolate</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">sugar_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">vanilla</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">sugar_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">mint_chocolate</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">sugar_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">caramel</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">sugar_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">white_chocolate</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">sugar_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">peach</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">watermelon</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">mango</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">strawberry</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">melon</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">orange</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">pineapple</td>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">상반기에 아이스크림의 주 성분이 설탕인 아이스크림들에 대한 총주문량을 구하면 3,200 + 2,800 + 1,700 + 2,600 + 3,100 = 13,400입니다.  아이스크림의 주 성분이 과일인 아이스크림들에 대한 총주문량을 구하면 3,100 + 2,450 + 2,150 + 2,900 + 3,150 + 2,900 + 2,900 = 19,550입니다. 따라서 총주문량이 작은 순서대로 조회하는 SQL 문을 실행하면 다음과 같이 나와야 합니다. </p>
<table class="table">
        <thead><tr>
<th style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INGREDIENT_TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TOTAL_ORDER</th>
</tr>
</thead>
        <tbody><tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">sugar_based</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">13400</td>
</tr>
<tr>
<td style="text-align: left; font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">fruit_based</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">19550</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges