<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/timeline/postContent.css">
<script type="text/javascript" src="/js/timeline/postContent.js"></script>

</head>
<body>
<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="gobackbtn">
			<img src="../image/ellipsis.png" class="timeLineEllipsis">
		</div>
		<div class="postLayout">
				<div class="postInfo">
			 		<img src="../image/timeline/profile.png" class="profileImg">
			 		<div class="writter">${timeline.userName}</div>
			 		<div class="createDate">등록일 <fmt:formatDate value="${timeline.createDate}" pattern="yyyy년 MM월 dd일"/></div>
				</div>
				<div class="postContent">
					<img src="..${timeline.filepath}" style="width:100%; min-height: 250px;">
					<div class="postContentText">${timeline.content}</div>
						
					<div class="replyCountBox">
					<img src="../image/bucket/replyCountImg.png" class="replyCountImg">
					<span class="replyCountText">${timeline.replyCount}</span>
				</div>
		</div>
</div>

<div class="layout">
			
		       	
				<c:set var="loopCount" value="0" />
		       	
		        
			        <c:forEach items="${reply}" var="reply" varStatus="status">
				        <div>
				        	<div style="position: relative; padding-bottom: 20px; border-bottom: solid 1px; border-color: #ADADAD;">
					        		<img src="../image/timeline/profile.png" style="position: absolute; top:20px; left:10px;">
						        <div class="replyTextBox">
						        	<img src="../image/bucket/replyEllipsis.png" class="replyEllipsis replyEachEllipsis${status.index }">
						        	<div class="replyModal replyEachModal${status.index }">
						        		<div class="replyModalBtn reMoBtn" id="replyModifyBtnz${status.index }">수정</div>
						        		<form action="/bucket/deletereplyaction" id="deleteReplyForm${status.index }" method="post">
						        			<input type="hidden" name="replySeq" value="${reply.replyseq }">
						        			<input type="hidden" name="postSeq" value="${reply.posttSeq }">
						        			
							        		<div onclick="document.getElementById('deleteReplyForm${status.index }').submit();" class="replyModalBtn" style="color: #E16646;">삭제</div>
						        		</form>
						        	</div>
							        <div class="userNameText">${reply.userName }</div>
							        <div class="replyContentsText replyContentsTextz${status.index }">${reply.replyContents }</div>
							        
							        <form action="/bucket/modifyreplyaction" method="post" id="modifyReplyForm${status.index }" class="editReplyForm modifyReplyFormz${status.index }">
							        	<input class="replyInput" type="text" name="replyContents" value="${reply.replyContents }" spellcheck="false">
							        	<div class="bottom-border"></div>
							        	<input type="hidden" name="bucketSeq" value="${reply.bucketSeq }">
							        	<input type="hidden" name="bucketReplySeq" value="${reply.bucketReplySeq }">
							        	<div class="modifyReplyBtnBox">
								        	<button type="button" class="modifyReplyCancelBtn modifyReplyCancelBtnz${status.index }">취소</button>
								        	<input class="modifyReplyModifyBtn" value="수정" type="button" alt="수정" onclick="document.getElementById('modifyReplyForm${status.index }').submit();">
							        	</div>
							        </form>
							        
							        <div class="replyRegDateText"><fmt:formatDate value="${reply.regDate}" pattern="yyyy.MM.dd a hh:mm"/></div>
							        <div style="height: 8px;"></div>
							        
				        		</div>
					        </div>
					    </div>
					    <c:if test="${status.last}">
						  <c:set var="loopCount" value="${status.index + 1}" />
						</c:if>
			        </c:forEach>
		        
		        <div class="modalBox detailDisNone"> 		       	
			        <div class="btnBox"><a class="modifyBtn" href="/bucket/modifybucket?bucketSeq=${bucketOne.bucketSeq }">수정하기</a></div>
			        <div class="btnBox"><a class="deleteBtn" href="/bucket/invisibleaction?bucketSeq=${bucketOne.bucketSeq }">삭제하기</a></div>
			        <div class="btnBox detailCancelBtn">취소</div>
		        </div>

		</div>
	</div>
	
	<form action="/bucket/addbucketreplyaction" method="post" class="addReplyForm">
	<div class="inputReplyBox">
		<input type="hidden" name="bucketSeq" value="${bucketOne.bucketSeq }">
		<input name="replyContents" type="text" placeholder="응원의 말을 남겨주세요." class="inputReply">
		<input class="replyAddImg" type="image" src="../image/bucket/replyAddImg.png" alt="완료" onclick="document.getElementById('addReplyForm').submit();">
	</div>
	</form>
	
<!-- /////////////////////////////////////////////////////////////////////////////////////// -->	

	<script>
	  // 댓글마다 ...누르면 수정 삭제 표시 나오게 하는 스크립트문
	  // JSP의 loopCount 변수를 사용하여 반복 횟수를 JavaScript 변수에 할당
		  let jsLoopCount = ${loopCount};
		  console.log('반복 횟수:', jsLoopCount);
		  
		  for (let i = 0; i < jsLoopCount; i++) {
			    $('.replyEachEllipsis'+i+'').on('click', function(){	//각 ... 을 클릭했을때 해당 댓글에 대한 Modal이 뜨게하는 for문
			    	$('.replyEachModal'+i+'').toggleClass('show');
			    });
			    
			}
		  
		  for (let i = 0; i < jsLoopCount; i++) {
			   $('#replyModifyBtnz'+i+'').on('click', function(){
				   $('.replyContentsTextz'+i+'').addClass('detailDisNone');
				   $('.modifyReplyFormz'+i+'').addClass('show');
				   $('.replyEachModal'+i+'').removeClass('show');				   
			   });
	   
			   $('.modifyReplyCancelBtnz'+i+'').on('click', function(){
				   $('.replyContentsTextz'+i+'').removeClass('detailDisNone');
				   $('.modifyReplyFormz'+i+'').removeClass('show');

			   });
			    
			}
		  $(document).on('click', function(){
			  console.log(event.target);
			  
		  })
		  
		 
	</script>
	

	
	<script>
	const ellipsis = document.querySelector('.bucketDetailEllipsis');

	// add a click event listener to the ellipsis image
	ellipsis.addEventListener('click', () => {
	  // get the element you want to toggle the class on
	  const element = document.querySelector('.modalBox');
	  // toggle the "disNone" class on the element
	  element.classList.toggle('detailDisNone');
	});
	
	$('.detailCancelBtn').on('click', function() {
		  $(this).closest('.modalBox').addClass('detailDisNone');
		});
	</script>
	


</body>
</html>