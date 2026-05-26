# [level 2] 진료과별 총 예약 횟수 출력하기 - 132202 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/132202) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 05월 26일 14:33:40

### 문제 설명

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">다음은 종합병원의 진료 예약정보를 담은 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APPOINTMENT</code> 테이블 입니다.<br>
<code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APPOINTMENT</code> 테이블은 다음과 같으며 <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_YMD</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_NO</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT_NO</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">MCDP_CD</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">MDDR_ID</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_CNCL_YN</code>, <code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_CNCL_YMD</code>는 각각 진료예약일시, 진료예약번호, 환자번호, 진료과코드, 의사ID, 예약취소여부, 예약취소날짜를 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Column name</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Type</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_YMD</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TIMESTAMP</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_NO</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NUMBER(5)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT_NO</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(10)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">MCDP_CD</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(6)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">MDDR_ID</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(10)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FALSE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_CNCL_YN</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">VARCHAR(1)</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TRUE</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_CNCL_YMD</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DATE</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">TRUE</td>
</tr>
</tbody>
      </table>
<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">문제</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;"><code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APPOINTMENT</code> 테이블에서 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문을 작성해주세요. 이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정해주시고 결과는 진료과별 예약한 환자 수를 기준으로 오름차순 정렬하고, 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬해주세요.</p>

<hr>

<h5 style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">예시</h5>

<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;"><code style="font-family: D2Coding; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APPOINTMENT</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_YMD</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_NO</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT_NO</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">MCDP_CD</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">MDDR_ID</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_CNCL_YN</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">APNT_CNCL_YMD</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-04-14 09:30:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">47</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000064</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">GS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20170123</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-04-15 10:30:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">48</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000065</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">OB</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20100231</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-05-15 17:30:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">49</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000086</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">OB</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20100231</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-05-18 10:30:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">52</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000019</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">GS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20100039</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-05-19 12:00:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">53</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000020</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FM</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20010112</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-05-22 08:30:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">54</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000021</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">GS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20100039</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-05-04 10:30:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">56</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000023</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FM</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20090112</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-05-14 15:30:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">57</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000074</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">CS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20200012</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-05-24 15:30:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">58</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000085</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">CS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20200012</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2022-05-28 10:00:00.000000</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">60</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">PT22000092</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">OS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">DR20100031</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">N</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">NULL</td>
</tr>
</tbody>
      </table>
<p style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">진료과코드</th>
<th style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">5월예약건수</th>
</tr>
</thead>
        <tbody><tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">OB</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">OS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">1</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">CS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">FM</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2</td>
</tr>
<tr>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">GS</td>
<td style="font-family: Pretendard; font-variant-ligatures: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">2</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges