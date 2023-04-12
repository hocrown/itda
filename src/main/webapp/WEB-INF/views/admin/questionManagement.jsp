<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../css/admin/admin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="//code.jquery.com/ui/1.13.0/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<title>하루 질문 관리</title>
</head>
<body>
	<div class="adminLayout">
		<div class="adminNaviBox">
			<div style="border-bottom: solid 1px;">
				<div class="navi-item adminSmallLogo"><img style="width: 7em; margin-right: 0.3em;" src="../image/itdaLogo.png"></div>
			</div>
			<div style="border-bottom: solid 1px;">
				<div class="navi-item item-text">하루 질문 관리<img class="adminVector" src="../image/vector.png"></div>
				<div class="detailItemText">요청 질문</div>
				<div class="detailItemText">질문 목록</div>
			</div>
			<div style="border-bottom: solid 1px;">
				<div class="navi-item item-text">잇다 질문통<img class="adminVector" src="../image/vector.png"></div>
			</div>
			<div style="border-bottom: solid 1px;">
				<div class="navi-item item-text">잇다소식 관리<img class="adminVector" src="../image/vector.png"></div>
			</div>
			<div style="border-bottom: solid 1px;">
				<div class="navi-item item-text">통계 관리<img class="adminVector" src="../image/vector.png"></div>
			</div>
		</div>
		
		<div class="top-bar"><span style="margin-right: 5%;">안녕하세요! admin1234 님</span></div>
		
		<div class="adminContent">
			<div>
				<div class="questionListText">질문 목록</div>
				<div style="text-align: center;">
				<table class="table table-striped table-hover dataTable" id="dataTable">
				    <thead>
				      <tr>
						<th><input type="checkbox"></th>
				        <th>글번호</th>
				        <th>작성자</th>
				        <th>내용</th>
				        <th>상태</th>
				      </tr>
				    </thead>
				    <tbody id="tableContent">
						
				    </tbody>
				</table>
				<div id="pagination"></div>
				<div style="text-align: right">
				<button class="btn btn-primary" style="margin-right: 1em;">추가하기</button>
				<button class="btn btn-danger question-delete-btn" style="margin-right: 12.5em;">삭제</button>
				
				</div>
				</div>
				
			</div>
		
		</div>
		
		
	</div>
	
	<script>

		
			$.ajax({
			  url: "/getQuestions",
			  type: "GET",
			  dataType: "json",
			  success: function (data) {
			    const itemsPerPage = 10; // 페이지당 10개씩 출력
			    let currentPage = 1; // 현재 페이지는 1로 설정

			    // 페이징 처리 함수
			    function displayPage(page) {
			      const tableContent = $("#tableContent");
			      tableContent.empty(); // 기존 테이블 내용 삭제

			      const startIndex = (page - 1) * itemsPerPage;
			      const endIndex = Math.min(startIndex + itemsPerPage, data.length);

			      for (let i = startIndex; i < endIndex; i++) {
			        const question = data[i];
			        const row = '<tr>'
			          + '<td class="table-p"><input type="checkbox"></td>'
			          + '<td class="table-p t-border">' + question.dailyQuestionSeq + '</td>'
			          + '<td class="table-p">' + question.writer + '</td>'
			          + '<td class="table-p" style="text-align: left;">' + question.question + '</td>'
			          + '<td class="table-p">' + question.visible + '</td>'
			          + '</tr>';
			          
			        tableContent.append(row);
			      }
			    }

			    // 페이지 이동 버튼을 처리하는 함수
			    function setupPagination() {
			      const totalPages = Math.ceil(data.length / itemsPerPage);
			      const pagination = $("#pagination");

			      for (let i = 1; i <= totalPages; i++) {
			        const pageButton = $('<a class="pageBtn">' + i + '</a>');
			        pageButton.on('click', function () {
			          currentPage = i;
			          displayPage(currentPage);
			        });

			        pagination.append(pageButton);
			      }
			    }

			    // 초기 페이징 설정 및 첫 페이지 표시
			    setupPagination();
			    displayPage(currentPage);
			  },
			  error: function (xhr, status, error) {
			    console.error("Error fetching data:", xhr);
			  },
			});
	
	
		/* const serverData = [
	      <c:forEach var="question" items="${questions}" varStatus="status">
	        {
	        	// 서버에서 받은 데이터를 JavaScript 객체로 변환
	        	"dailyQuestionSeq": `${fn:escapeXml(question.dailyQuestionSeq)}`,
	        	"writer": `${fn:escapeXml(question.writer)}`,
	        	"question": `${fn:escapeXml(question.question)}`,
	        	"visible": `${fn:escapeXml(question.visible)}`
	         
	        }
	        <c:if test="${not status.last}">,</c:if>
	      </c:forEach>
	    ];
		
		console.log(serverData); */
	</script>
	
	
</body>
</html>