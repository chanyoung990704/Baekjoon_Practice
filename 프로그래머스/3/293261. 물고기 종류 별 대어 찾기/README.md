# [level 3] 물고기 종류 별 대어 찾기 - 293261 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/293261) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > SUM， MAX， MIN

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 06월 02일 15:07:06

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none;">낚시앱에서 사용하는 <code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_INFO</code> 테이블은 잡은 물고기들의 정보를 담고 있습니다. <code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_INFO</code> 테이블의 구조는 다음과 같으며 <code style="font-family: D2Coding; font-variant-ligatures: none;">ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_TYPE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">LENGTH</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">TIME</code>은 각각 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜를 나타냅니다. </p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FISH_TYPE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">LENGTH</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FLOAT</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">TIME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">단, 잡은 물고기의 길이가 10cm 이하일 경우에는 <code style="font-family: D2Coding; font-variant-ligatures: none;">LENGTH</code> 가 NULL 이며, <code style="font-family: D2Coding; font-variant-ligatures: none;">LENGTH</code> 에 NULL 만 있는 경우는 없습니다.</p>

<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_NAME_INFO</code> 테이블은 물고기의 이름에 대한 정보를 담고 있습니다. <code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_NAME_INFO</code> 테이블의 구조는 다음과 같으며, <code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_TYPE</code>, <code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_NAME</code> 은 각각 물고기의 종류(숫자), 물고기의 이름(문자) 입니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FISH_TYPE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">INTEGER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FISH_NAME</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">VARCHAR</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">FALSE</td>
</tr>
</tbody>
      </table>
<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">문제</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;">물고기 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이를 출력하는 SQL 문을 작성해주세요.</p>

<p style="font-family: Pretendard; font-variant-ligatures: none;">물고기의 ID 컬럼명은 <code style="font-family: D2Coding; font-variant-ligatures: none;">ID</code>, 이름 컬럼명은 <code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_NAME</code>, 길이 컬럼명은 <code style="font-family: D2Coding; font-variant-ligatures: none;">LENGTH</code>로 해주세요.<br>
결과는 물고기의 ID에 대해 오름차순 정렬해주세요.<br>
단, 물고기 종류별 가장 큰 물고기는 1마리만 있으며 10cm 이하의 물고기가 가장 큰 경우는 없습니다.</p>

<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none;">예를 들어 <code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_INFO</code> 테이블이 다음과 같고</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">FISH_TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">LENGTH</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">TIME</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">30</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021/12/04</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">50</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2020/03/07</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">40</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2020/03/07</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">3</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">20</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022/03/09</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">4</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">NULL</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022/04/08</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">5</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">13</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021/04/28</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">6</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">60</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021/07/27</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">7</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">55</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021/01/18</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">8</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">73</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2020/01/28</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">9</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">73</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2021/04/08</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">10</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">22</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2020/06/28</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">11</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">17</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2022/12/23</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;"><code style="font-family: D2Coding; font-variant-ligatures: none;">FISH_NAME_INFO</code>  테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">FISH_TYPE</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">FISH_NAME</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">0</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">BASS</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">1</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">SNAPPER</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">2</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">ANCHOVY</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none;">'BASS' 중 가장 큰 물고기는 60cm 로 물고기 ID 가 6이고, 'SNAPPER' 중 가장 큰 물고기는 73cm 로 물고기 ID가 9입니다. 'ANCHOVY' 중 가장 큰 물고기는 73cm 로 물고기 ID가 8입니다. 따라서 물고기 ID(ID) 에 대해 오름차순 정렬한다면 결과는 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none;">ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">FISH_NAME</th>
<th style="font-family: Pretendard; font-variant-ligatures: none;">LENGTH</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">6</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">BASS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">60</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">8</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">ANCHOVY</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">73</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none;">9</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">SNAPPER</td>
<td style="font-family: Pretendard; font-variant-ligatures: none;">73</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges