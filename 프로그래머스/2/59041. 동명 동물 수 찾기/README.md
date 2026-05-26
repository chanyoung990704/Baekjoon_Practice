# [level 2] 동명 동물 수 찾기 - 59041 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/59041) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 05월 26일 13:52:43

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;"><code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_INS</code> 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_INS</code> 테이블 구조는 다음과 같으며, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_TYPE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DATETIME</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INTAKE_CONDITION</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NAME</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">SEX_UPON_INTAKE</code>는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NAME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULLABLE</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_TYPE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DATETIME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DATETIME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INTAKE_CONDITION</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NAME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">SEX_UPON_INTAKE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">동물 보호소에 들어온 동물 이름 중 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회하는 SQL문을 작성해주세요. 이때 결과는 이름이 없는 동물은 집계에서 제외하며, 결과는 이름 순으로 조회해주세요. </p>

<h5 style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">예를 들어 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_INS</code> 테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ANIMAL_TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DATETIME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">INTAKE_CONDITION</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NAME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">SEX_UPON_INTAKE</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">A396810</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Dog</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2016-08-22 16:13:00</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Injured</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Raven</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Spayed Female</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">A377750</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Dog</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2017-10-25 17:17:00</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Normal</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Lucy</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Spayed Female</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">A355688</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Dog</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2014-01-26 13:48:00</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Normal</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Shadow</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Neutered Male</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">A399421</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Dog</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2015-08-25 14:08:00</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Normal</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Lucy</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Spayed Female</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">A400680</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Dog</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2017-06-17 13:29:00</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Normal</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Lucy</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Spayed Female</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">A410668</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Cat</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2015-11-19 13:41:00</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Normal</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Raven</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Spayed Female</td>
</tr>
</tbody>
      </table>
<ul>
<li style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Raven 이름은 2번 쓰였습니다.</li>
<li style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Lucy 이름은 3번 쓰였습니다</li>
<li style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Shadow 이름은 1번 쓰였습니다.</li>
</ul>

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">따라서 SQL문을 실행하면 다음과 같이 나와야 합니다. </p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NAME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">COUNT</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Lucy</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">3</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Raven</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2</td>
</tr>
</tbody>
      </table>
<hr>

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">본 문제는 <a href="https://www.kaggle.com/aaronschlegel/austin-animal-center-shelter-intakes-and-outcomes" target="_blank" rel="noopener" style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Kaggle의 "Austin Animal Center Shelter Intakes and Outcomes"</a>에서 제공하는 데이터를 사용하였으며 <a href="https://opendatacommons.org/licenses/odbl/1.0/" target="_blank" rel="noopener" style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">ODbL</a>의 적용을 받습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges