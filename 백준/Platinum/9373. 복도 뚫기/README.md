# [Platinum II] 복도 뚫기 - 9373 

[문제 링크](https://www.acmicpc.net/problem/9373) 

### 성능 요약

메모리: 359504 KB, 시간: 3532 ms

### 분류

그래프 이론, 기하학, 최소 스패닝 트리

### 제출 일자

2025년 7월 20일 14:55:10

### 문제 설명

<p>승현의 방은 출입 보안이 철저하다. 승현의 방에 들어가려면 많은 센서가 부착된 복도를 지나가야 한다. 센서는 일정 범위에 사람이나 물체가 감지되면 경보를 울린다.</p>

<p>현석은 매우 민첩한 스파이다. 그는 승현의 방에 있는 어떤 기밀문서를 훔쳐와 달라는 의뢰를 받았고, 실행하기에 앞서 현석은 복도 설계도를 입수했다. 현석은 이 설계도를 보고 자신이 직접 들어갈지, 그게 안 된다면 어느 정도의 로봇을 들여보낼 지 결정해야 한다.</p>

<p>현석은 복도를 2차원적으로 해석하기로 했다. 복도의 좌우 벽은 직선으로, 센서와 센서의 범위는 각각 원의 중심과 그 내부로 대응시켰다. 센서는 복도의 벽에 붙어있거나 복도 중간에 위치해 있으며 그 범위는 복도 양 끝 사이에 적절히 위치해 있다. 현석은 또한 센서 사이를 지나가는 물체를 원으로 가정했다.</p>

<p>센서들의 배치도가 주어져 있을 때, 이 원(현석 혹은 로봇)이 센서에 걸리지 않고 복도를 지나갈 수 있게 하기 위한 원의 최대 반지름을 구하자.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/through.png"></p>

<p>예제 입력을 시각화한 것이다.</p>

### 입력 

 <p>첫째 줄에는 테스트 케이스의 개수 T가 주어진다. (1 ≤ T ≤ 100) 그리고,</p>

<ul>
	<li>그 다음 줄에 복도의 너비, 정수 w가 주어진다. (1 ≤ w ≤ 100 000) 복도의 양 벽은 직선 x = 0 과 x = w 로 해석한다.</li>
	<li>그 다음 줄에 센서의 개수, 정수 n이 주어진다. (0 ≤ n ≤ 1 000)</li>
	<li>그 다음 각 n개의 줄에 센서의 위치, 반지름을 나타내는 정수 x, y, r 이 주어진다. (0 ≤ x ≤ w, -100 000 ≤ y ≤ 100 000 and 1 ≤ r ≤ 100 000)</li>
</ul>

<p>복도의 양 끝은 y = -∞, y = ∞ 이다. 쉽게 말해 센서들의 범위에서 한참 벗어나있다.</p>

### 출력 

 <p>각 테스트 케이스마다 센서에 감지되지 않고 복도를 지나갈 수 있는 원형 물체의 최대 반지름을 부동소수점 실수로 한 줄에 출력한다. 물체는 매우 정밀하게 움직일 수 있다고 가정한다. 만약 들키지 않고 지나가는 게 불가능하다면 0을 출력한다. 답은 소수점 아래 6번째 자리까지 정확해야 한다.</p>

