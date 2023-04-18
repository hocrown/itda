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
			<div class="questionListContainer">
				<div class="questionListText">질문 목록</div>
				<table class="table table-striped table-hover dataTable" id="dataTable">
				    <thead>
				      <tr>
						<th class="chkBoxWidth"><input type="checkbox" style="visibility: hidden"></th>
				        <th class="seqWidth">글번호</th>
				        <th class="wirterWidth">작성자</th>
				        <th>내용</th>
				        <th class="statusWidth">상태</th>
				        <th class="typeWidth">유형</th>
				      </tr>
				    </thead>
				    <tbody id="tableContent">
						
				    </tbody>
				</table>
				<div>
					<div style="display: inline-block;" id="pagination"></div>
				</div>
				<input type="text" id="searchInput" placeholder="검색어를 입력하세요"> <button id="searchButton">검색</button>
					<button class="btn btn-primary question-insert-btn">추가</button>
					<button class="btn btn-danger question-delete-btn">삭제</button>
				
			</div>
			
			<div class="modal-black"></div>
			
				<div class="insert-question-modal">
					<form action="/insertQuestion" method="post">
						<div class="modal-box">
							<div class="insert-question-text">추가할 질문 내용</div>
							<div><input required="required" name="question" type="text" class="insert-question-input"></div>
							<div class="modal-btn-group">
								<button type="button" class="btn btn-danger question-modal-cancel-btn">취소</button>
								<button type="submit" class="btn btn-primary question-modal-insert-btn">등록</button>								
							</div>
						</div>
					</form>	
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
		  
		  $(".question-insert-btn").on('click', function(){
			$('.insert-question-modal').css("display", "block");
			$('.modal-black').css("display", "block");
		  });
		  
		  // 모달창 활성화 시 배경 누를 때 창이 닫히도록
		  $(".modal-black, .question-modal-cancel-btn").on('click', function(){
			 $(".modal-black").css("display", "none");
			 $('.insert-question-modal').css("display", "none");
		  });
		  
		  $("#navi-questionManagement").addClass("navi-selected");
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
			function displayPage(page, dataToDisplay) {
				const tableContent = $("#tableContent");
				tableContent.empty(); // 기존 테이블 내용 삭제
				const dataToUse = dataToDisplay || data; // 검색 기능에서 필터링된 데이터를 사용하거나, 기본 데이터를 사용합니다.
				const startIndex = (page - 1) * itemsPerPage;
				const endIndex = Math.min(startIndex + itemsPerPage, data.length);

				for (let i = startIndex; i < endIndex; i++) {
					const question = dataToUse[i];
					const statusText = question.visible === 1 ? "활성화" : "비활성화";
					const row = '<tr>'
						+ '<td class="table-p chkBoxWidth"><input type="checkbox"></td>'
						+ '<td class="table-p seqWidth">' + question.dailyQuestionSeq + '</td>'
						+ '<td class="table-p wirterWidth">' + question.writer + '</td>'
						+ '<td class="table-p" style="text-align: left;">' + question.question + '<img src="../image/textEditBtnImg.png" class="questionEditBtn"> </td>'
						+ '<td class="table-p statusWidth">' + statusText + '<img src="../image/textEditBtnImg.png" class="statusEditBtn"> </td>'
						+ '<td class="table-p typeWidth">' + question.type + '</td>'
						+ '</tr>';


					tableContent.append(row);

					$('.questionEditBtn').last().on('click', function editButtonClickHandler() {
						const currentCell = $(this).parent();

						// 현재 셀의 텍스트를 가져옵니다.
						const currentText = currentCell.text();

						// 새로운 입력 요소를 생성하고 원래의 텍스트 값을 설정합니다.
						const inputElement = $('<input type="text" class="edit-input">');
						inputElement.val(currentText);

						// 현재 셀의 내용을 새로운 입력 요소로 바꿉니다.
						currentCell.empty().append(inputElement);

						inputElement.on('blur', function () {
							// 입력 요소의 새로운 값을 가져옵니다.
							const newText = $(this).val();

							// 새로운 값을 서버에 전송하고 데이터를 업데이트하는 코드를 여기에 작성하세요.
							$.ajax({
								url: "/updateQuestion", // 서버에서 제공하는 업데이트 처리 URL
								type: "POST",
								data: {
									dailyQuestionSeq: question.dailyQuestionSeq, // 수정할 질문의 Seq
									question: newText // 새로운 질문 텍스트
								},
								success: function (response) {
									// 서버에서 변경 사항이 성공적으로 처리된 경우
									// 이 부분에서 클라이언트 측의 UI를 업데이트할 수 있습니다.
									console.log("Question updated successfully.");
								},
								error: function (error) {
									// 서버에서 에러가 발생한 경우
									console.log("Error updating question: ", error);
								}
							});
							// 입력 요소를 새로운 텍스트로 바꿉니다.
							const newTextElement = $('<span>' + newText + '</span>');
							const newQuestionEditBtn = $('<img src="../image/textEditBtnImg.png" class="questionEditBtn">');
							currentCell.empty().append(newTextElement).append(newQuestionEditBtn);

							// 새로 생성된 edit 버튼에 이벤트 핸들러를 바인딩합니다.
							newQuestionEditBtn.on('click', editButtonClickHandler);
						});

						inputElement.on('keydown', function (event) {
							// 엔터 키를 누르면 입력 요소에서 포커스를 제거합니다.
							if (event.key === 'Enter') {
								$(this).blur();
							}
						});
					});

					$('.statusEditBtn').last().on('click', function statusEditButtonClickHandler() {
						const currentCell = $(this).parent();

						// 현재 셀의 텍스트를 가져옵니다.
						const currentStatus = currentCell.text();

						// 새로운 select 요소를 생성하고 현재 상태에 맞는 옵션을 선택합니다.
						const selectElement = $('<select class="statusSelect">'
							+ '<option value="1">활성화</option>'
							+ '<option value="0">비활성화</option>'
							+ '</select>');
						selectElement.val(currentStatus === '활성화' ? 1 : 0);

						// 현재 셀의 내용을 새로운 select 요소로 바꿉니다.
						currentCell.empty().append(selectElement);



						function updateStatus(newStatus) {
							// 새로운 상태 값을 서버에 전송하고 데이터를 업데이트하는 코드를 여기에 작성하세요.
							$.ajax({
								url: "/updateStatus", // 서버에서 제공하는 업데이트 처리 URL
								type: "POST",
								data: {
									dailyQuestionSeq: question.dailyQuestionSeq, // 수정할 질문의 Seq
									visible: newStatus // 새로운 상태 값 (1: 활성화, 0: 비활성화)
								},
								success: function (response) {
									// 서버에서 변경 사항이 성공적으로 처리된 경우
									// 이 부분에서 클라이언트 측의 UI를 업데이트할 수 있습니다.
									console.log("Status updated successfully.");
								},
								error: function (error) {
									// 서버에서 에러가 발생한 경우
									console.log("Error updating status: ", error);
								}
							});
						}

						selectElement.on('change', function () {
							// 선택한 옵션의 값을 가져옵니다.
							const newStatus = $(this).val();

							// AJAX 요청을 처리합니다.
							updateStatus(newStatus);

							// select 요소를 새로운 텍스트로 바꿉니다.
							const newStatusText = newStatus == 1 ? '활성화' : '비활성화';
							const newTextElement = $('<span>' + newStatusText + '</span>');
							const newStatusEditBtn = $('<img src="../image/textEditBtnImg.png" class="statusEditBtn">');
							currentCell.empty().append(newTextElement).append(newStatusEditBtn);

							// 새로 생성된 edit 버튼에 이벤트 핸들러를 바인딩합니다.
							newStatusEditBtn.on('click', statusEditButtonClickHandler);
						});

						selectElement.on('blur', function () {
							// 현재 선택된 옵션의 값을 가져옵니다.
							const newStatus = $(this).val();

							// AJAX 요청을 처리합니다.
							updateStatus(newStatus);

							// select 요소를 새로운 텍스트로 바꿉니다.
							const newStatusText = newStatus == 1 ? '활성화' : '비활성화';
							const newTextElement = $('<span>' + newStatusText + '</span>');
							const newStatusEditBtn = $('<img src="../image/textEditBtnImg.png" class="statusEditBtn">');
							currentCell.empty().append(newTextElement).append(newStatusEditBtn);

							// 새로 생성된 edit 버튼에 이벤트 핸들러를 바인딩합니다.
							newStatusEditBtn.on('click', statusEditButtonClickHandler);
						});


					});


				}
			}



			// 페이지 이동 버튼을 처리하는 함수
			function setupPagination(dataToDisplay) {
				const dataToUse = dataToDisplay || data; // 검색 기능에서 필터링된 데이터를 사용하거나, 기본 데이터를 사용합니다.
				const totalPages = Math.ceil(dataToUse.length / itemsPerPage);
				const pagination = $("#pagination");
				const pagesPerGroup = 10;
				
				let currentGroup = 1;

				function displayPaginationGroup(group) {
					pagination.empty();

					// 이전 그룹 버튼 생성
					if (group > 1) {
						const prevGroupButton = $('<a class="prevGroupBtn">&laquo;</a>');
						prevGroupButton.on('click', function () {
							currentGroup--;
							displayPaginationGroup(currentGroup);
						});
						pagination.append(prevGroupButton);
					}

					const startPage = (group - 1) * pagesPerGroup + 1;
					const endPage = Math.min(group * pagesPerGroup, totalPages);

					for (let i = startPage; i <= endPage; i++) {
						const pageButton = $('<a class="pageBtn">' + i + '</a>');
						pageButton.on('click', function () {
							currentPage = i;
							displayPage(currentPage);
							$('.pageBtn').css("font-weight", "normal");
							$(this).css("font-weight", "bold");
						});

						pagination.append(pageButton);
					}

					// 다음 그룹 버튼 생성
					if (endPage < totalPages) {
						const nextGroupButton = $('<a class="nextGroupBtn">&raquo;</a>');
						nextGroupButton.on('click', function () {
							currentGroup++;
							displayPaginationGroup(currentGroup);
						});
						pagination.append(nextGroupButton);
					}
				}

				// 초기 페이징 설정 및 첫 페이지 표시
				displayPaginationGroup(currentGroup);
			}

				function searchQuestions() {
				  const searchInput = $("#searchInput");
				  const searchKeyword = searchInput.val().toLowerCase().trim();

				  const filteredData = data.filter(function (question) {
				    const questionText = question.question.toLowerCase();
				    const writerText = question.writer.toLowerCase();
				    const statusText = question.visible === 1 ? "활성화" : "비활성화";
				    const typeText = question.type.toLowerCase();

				    return questionText.includes(searchKeyword) ||
				           writerText.includes(searchKeyword) ||
				           statusText.includes(searchKeyword) ||
				           typeText.includes(searchKeyword);
				  });

				  // 초기 페이징 설정 및 첫 페이지 표시
				  setupPagination(filteredData);
				  displayPage(1, filteredData);
				}
			setupPagination(data);
			displayPage(1);
			$("#searchButton").on("click", searchQuestions);
		},
		error: function (xhr, status, error) {
			console.error("Error fetching data:", xhr);
		},
	});



	$(".question-delete-btn").on("click", function () {
		const checkedRows = $("#tableContent tr").filter(":has(:checkbox:checked)");

		const dailyQuestionSeqsToDelete = checkedRows.map(function () {
			return $(this).find(".seqWidth").text();
		}).get();

		// 서버에 삭제 요청
		$.ajax({
			url: "/deleteQuestions",
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify(dailyQuestionSeqsToDelete),
			success: function (response) {
				// 삭제가 성공적으로 처리된 경우
				// 이 부분에서 클라이언트 측의 UI를 업데이트할 수 있습니다.
				console.log("Questions deleted successfully.");

				// 선택된 행 삭제
				checkedRows.remove();

				// 페이지를 다시 로드하여 변경 사항을 반영
				location.reload();
			},
			error: function (error) {
				// 서버에서 에러가 발생한 경우
				console.log("Error deleting questions: ", error);
			}
		});
	});

	</script>
	
	
</body>
</html>