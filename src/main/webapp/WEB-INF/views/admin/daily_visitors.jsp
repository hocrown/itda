<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Daily Visitors</title>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<div id="dailyVisitorsChart"></div>

<script>
    // 서버로부터 dailyVisitorData를 가져옵니다. 이 데이터는 컨트롤러에서 Model에 추가한 데이터입니다.
    // 이 부분은 서버에서 데이터를 가져오는 방식에 따라 수정할 수 있습니다.
    const dailyVisitorData = ${dailyVisitorData};

    // 데이터 포맷 변환: Chart.js에서 사용할 수 있는 형태로 dailyVisitorData를 변환합니다.
    const chartLabels = [];
    const chartData = [];
    for (const dataPoint of dailyVisitorData) {
        chartLabels.push(dataPoint.visitDate);
        chartData.push(dataPoint.count);
    }

    // 차트 생성: 캔버스 요소를 참조한 후, Chart.js를 사용하여 차트를 생성합니다.
    const ctx = document.getElementById("dailyVisitorsChart").getContext("2d");
    const dailyVisitorsChart = new Chart(ctx, {
        type: "line",
        data: {
            labels: chartLabels,
            datasets: [{
                label: "일별 방문자 수",
                data: chartData,
                borderColor: "rgba(75, 192, 192, 1)",
                backgroundColor: "rgba(75, 192, 192, 0.2)",
                tension: 0.1
            }]
        },
        options: {
            scales: {
                x: {
                    type: "time",
                    time: {
                        unit: "day",
                        displayFormats: {
                            day: "MMM DD"
                        }
                    },
                    title: {
                        display: true,
                        text: "날짜"
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: "방문자 수"
                    }
                }
            }
        }
    });
</script>
</body>
</html>