<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="adminHead.jsp"%>
	<title>하루 질문 관리</title>
</head>
<body>
	<div class="adminLayout">
<%@ include file="adminNavi.jsp"%>
		
		<div class="adminContent">
			<div>
				<div class="questionListText">질문 목록</div>
				<div style="text-align: center;">
				<table class="table table-striped table-hover dataTable" id="dataTable">
				    <thead>
				      <tr>
						<th class="chkBoxWidth"><input type="checkbox"></th>
				        <th class="seqWidth">글번호</th>
				        <th class="wirterWidth">작성자</th>
				        <th>내용</th>
				        <th class="statusWidth">상태</th>
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
		  
		  $("#navi-questionManagement").addClass("navi-selected")
		});
		
		$('.navi-questionList').html('>  질문 목록');
	
		
		
		
		
		
	</script>
	
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
			          + '<td class="table-p chkBoxWidth"><input type="checkbox"></td>'
			          + '<td class="table-p seqWidth">' + question.dailyQuestionSeq + '</td>'
			          + '<td class="table-p wirterWidth">' + question.writer + '</td>'
			          + '<td class="table-p" style="text-align: left;">' + question.question + '</td>'
			          + '<td class="table-p statusWidth">' + question.visible + '</td>'
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
	

	</script>
	
	
</body>
</html>