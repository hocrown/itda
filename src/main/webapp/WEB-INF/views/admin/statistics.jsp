<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="adminHead.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/admin/statistics.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="adminLayout">
	<%@ include file="adminNavi.jsp"%>
		<div class="adminContent">
			
			<div class="visit-chart-box">
				<div class="visit-canvas-box">
					<canvas id="weeklyVisitorsChart" class="canvas-visitor"></canvas>
				</div>
				<div class="stat-info-box">
					<div class="info-box total-text">
						<span><strong>합계</strong><br> ${total}</span>
					</div>
					<div class="info-box today-text">
						<span><strong>오늘</strong> <br> ${today}</span>
					</div>
				</div>
			</div>
			
			<div class="join-chart-box">
				<div class="join-canvas-box">
				    <canvas id="monthlyJoinedMembersChart" class="canvas-join"></canvas>
				</div>
				<div class="join-stat-info-box">
					<div class="info-box join-total-text">
						<span><strong>합계</strong><br> ${joinTotal}</span>
					</div>
					<div class="info-box join-aver-text">
						<span><strong>평균</strong> <br> ${joinAverage}</span>
					</div>
					<div class="info-box join-this-text">
						<span><strong>이번달</strong> <br> ${joinThisMonth}</span>
					</div>					
				</div>			
			</div>
			
		</div>
	</div>
	
	<script>
	$(document).ready(function () {
		  // 네비게이션 바의 각 항목에 대한 마우스 호버 이벤트 처리
		  $(".navi-hover").on("mouseenter", function () {
		    // 컨텐츠 배경색 가져오기

		    // 현재 항목의 배경색을 컨텐츠 배경색과 동일하게 설정
		    $(this).css("background-color", "#F3F3F3");
		  });

		  // 네비게이션 바의 각 항목에 대한 마우스 아웃 이벤트 처리
		  $(".navi-hover").on("mouseleave", function () {
		    // 배경색을 원래대로 되돌리기
		    $(this).css("background-color", "");
		  });
		  
		  $("#navi-statistics").addClass("navi-selected");
	});
	</script>
	
<script>
	var joinCounts = JSON.parse('${joinCountsJson}');
	
	//현재 날짜에서 1년 전의 날짜를 구합니다.
	var oneYearAgo = moment().subtract(1, 'years');
	
	//최근 1년간의 데이터만 필터링합니다.
	var filteredJoinCounts = joinCounts.filter(data => moment(data.joinYearMonth, "YYYY-MM").isSameOrAfter(oneYearAgo));
	
	var chartData2 = {
	 labels: filteredJoinCounts.map(data => moment(data.joinYearMonth, "YYYY-MM").format("YY.MM")),
	 datasets: [{
	     label: '월별 가입자 추이',
	     data: filteredJoinCounts.map(data => data.numOfMembers),
	     backgroundColor: 'rgba(75, 192, 192, 0.2)', // 막대 색상 설정
	     borderColor: 'rgba(0, 0, 0, 0)', // 테두리 색상 설정
	     borderWidth: 0 // borderWidth를 0으로 설정하여 테두리가 없음
	 }]
	};
	
	var chartOptions2 = {
	 scales: {
	     y: {
	         beginAtZero: true,
	         grid: {
	             color: 'rgba(200, 200, 200, 0.1)', // Y축 선들이 희미하게 보이게 설정
	         }
	     },
	     x: {
	         grid: {
	             color: 'rgba(200, 200, 200, 0.1)', // X축 선들이 희미하게 보이게 설정
	         }
	     }
	 }
	};
	
	var monthlyJoinedMembersChart = new Chart(document.getElementById('monthlyJoinedMembersChart'), {
	 type: 'bar',
	 data: chartData2,
	 options: chartOptions2
	});

//--------------------------------------주간 접속자 수 차트------------------------------------------------------
// 데이터를 가져온 후, Chart.js를 사용하여 그래프를 그립니다
var weeklyVisitorData = JSON.parse('${weeklyVisitorData}');

// 데이터를 가공합니다
var chartData = {
	labels: weeklyVisitorData.map(data => moment(data.VISITDATE).format('MM.DD')),
	datasets: [{
		label: '주간 접속자 현황',
		data: weeklyVisitorData.map(data => data.COUNT != null ? data.COUNT : 0),
		backgroundColor: 'rgba(242, 237, 228, 0.6)',
		tension: 0.3, 
		borderColor: 'rgba(217, 205, 191, 1)',
		borderWidth: 2, // 변경된 선 굵기
		fill: 'origin',
		pointBackgroundColor: 'rgba(255, 99, 132, 1)', // 변경된 포인트 배경색
		pointBorderColor: 'rgba(217, 205, 191, 1)', // 변경된 포인트 테두리 색상
		pointRadius: 2, // 변경된 포인트 크기
		pointStyle: 'rect' // 변경된 포인트 모양 (사각형)
	}]
};

var chartOptions = {
	scales: {
		y: {
			beginAtZero: true
		},
		x: {
			grid: {
				color: 'rgba(200, 200, 200, 0.1)', // 변경된 x축 그리드 색상
				lineWidth: 1, // 변경된 x축 그리드 굵기
				drawBorder: false // 변경된 x축 경계선 그리기 여부
			}
		},
		y: {
			grid: {
				color: 'rgba(200, 200, 200, 0.1)', // 변경된 y축 그리드 색상
				lineWidth: 1, // 변경된 y축 그리드 굵기
				drawBorder: false // 변경된 y축 경계선 그리기 여부
			}
		}
	},
	plugins: {
		tooltip: {
			backgroundColor: 'rgba(0, 0, 0, 0.8)', // 변경된 툴팁 배경색
			titleFont: { size: 18, weight: 'bold', family: 'Arial' }, // 변경된 툴팁 제목 글꼴
			bodyFont: { size: 14, family: 'Arial' }, // 변경된 툴팁 본문 글꼴
			displayColors: false, // 변경된 툴팁에 데이터 색상 표시 여부
			callbacks: {
				title: function(tooltipItem) {
					return '날짜: ' + tooltipItem[0].label;
				},
				label: function(tooltipItem) {
					return '접속자: ' + tooltipItem.parsed.y;
				}
			}
		}
	}
		};
		
		var weeklyVisitorsChart = new Chart(document.getElementById('weeklyVisitorsChart'), {
			type: 'line', // 영역 그래프로 변경하기 위한 설정
			data: chartData,
			options: chartOptions
		});
//--------------------------------------------------------------------------------------------
	</script>
</body>
</html>