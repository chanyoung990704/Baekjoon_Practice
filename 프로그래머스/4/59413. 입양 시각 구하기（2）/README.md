# [level 4] 입양 시각 구하기(2) - 59413 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/59413) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 06월 01일 12:23:10

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">ANIMAL_OUTS</code> 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. <code style="font-family: D2Coding; font-variant-ligatures: none;">ANIMAL_OUTS</code> 테이블 구조는 다음과 같으며, <code style="font-family: D2Coding; font-variant-ligatures: none;">ANIMAL_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">ANIMAL_TYPE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">DATETIME</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">NAME</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">SEX_UPON_OUTCOME</code>는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">NAME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">NULLABLE</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">ANIMAL_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">ANIMAL_TYPE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">DATETIME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">DATETIME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NAME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">SEX_UPON_OUTCOME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR(N)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.</p>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;">SQL문을 실행하면 다음과 같이 나와야 합니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">HOUR</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">COUNT</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">4</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">5</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">6</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">7</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">8</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">9</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">10</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">11</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">13</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">12</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">10</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">13</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">14</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">14</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">9</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">15</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">7</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">16</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">10</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">17</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">12</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">18</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">16</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">19</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">20</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">21</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">22</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">23</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
</tr>
</tbody>
      </table>
<hr>

<p style="font-family: Pretendard; font-variant-ligatures: none;">본 문제는 <a href="https://www.kaggle.com/aaronschlegel/austin-animal-center-shelter-intakes-and-outcomes" target="_blank" rel="noopener" style="font-family: Pretendard; font-variant-ligatures: none;">Kaggle의 "Austin Animal Center Shelter Intakes and Outcomes"</a>에서 제공하는 데이터를 사용하였으며 <a href="https://opendatacommons.org/licenses/odbl/1.0/" target="_blank" rel="noopener" style="font-family: Pretendard; font-variant-ligatures: none;">ODbL</a>의 적용을 받습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges