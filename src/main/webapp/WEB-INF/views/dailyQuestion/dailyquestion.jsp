<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잇다-생각을</title>
</head>
<body>
    <h1>오늘의 생각</h1>
    <div id="question-container">
        <p>불러오는 중입니다...</p>
    </div>
    
    <script>
        $(document).ready(function() {
            fetchDailyQuestion();
        });

        function fetchDailyQuestion() {
            $.ajax({
                url: "/dailyquestion",
                method: "GET",
                success: function(data) {
                    if (data) {
                        $("#question-container").html("<p>" + data.question + "</p>");
                    } else {
                        $("#question-container").html("<p>사용할 수 있는 질문이 없습니다.</p>");
                    }
                },
                error: function() {
                    $("#question-container").html("<p>질문을 불러오는 중에 오류가 발생했습니다.</p>");
                }
            });
        }
    </script>

</body>
</html>