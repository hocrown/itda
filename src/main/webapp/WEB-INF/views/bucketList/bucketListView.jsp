<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bucket/bucketListView.css">
</head>
<body>
	<div class="layout">
		<div class="headBox">
			<img src="../image/vector.png" class="vector">
			소망을 잇다
			<img src="../image/addBtn.png" class="addBtn">
		</div>
		
		<span class="ourBucketText">우리 가족 버킷리스트</span>
		
		<div class="testz">
		
			<div class="testbox">
				<a href="/bucket/bucketview"><div class="testspan">함께</div></a>
				<div class="bordermy" style="height: 30px;"></div>
			</div>
		<c:forEach items="${myFam }" var="fam" varStatus="status">
			<div data-member-id="${fam }" class="testbox">
				<button id="sticker${status.index }" class="testspan">${fam }</button>
				<div class="bordermy" style="height: 30px;"></div>
			</div>
		</c:forEach>
		</div>

		<div class="listLayout">
			<div class="listContainer">
				<c:forEach items="${bucketlist}" var="bucket">	
					<c:if test="${bucket.visible eq 'y' }">
						<c:choose>
						<c:when test="${not empty bucket.finishDate && bucket.finishDate <= currentDate}">
							<a href="/bucket/familybucketdetail?bucketSeq=${bucket.bucketSeq }">
							<img src="..${bucket.filepath }" style="width:100%; height: 155px; margin-bottom: 5px; filter: grayscale(70%);">
							<div style="position: relative;">
								<img src="../image/bucket/chkLine.png" style="width: 100%">
								<img src="../image/bucket/successStamp.png" class="successStamp">
								<span class="finishDateText"><fmt:formatDate value="${bucket.finishDate}" pattern="yyyy.MM.dd"/></span>
								<img src="../image/bucket/greenChk.png" class="greenChk">
								<span class="bucketTitleSpan">${bucket.title}</span>				
							</div>
							<div style="height: 25px;"></div>
							</a>
																
						</c:when>							
							
						<c:otherwise>			
							<a href="/bucket/familybucketdetail?bucketSeq=${bucket.bucketSeq }">
							<img src="..${bucket.filepath }" style="width:100%; height: 155px; margin-bottom: 5px;">
							<div style="position: relative;">
								<img src="../image/bucket/chkLine.png" style="width: 100%">
								<span class="bucketTitleSpan">${bucket.title}</span>				
							</div>
							<div style="height: 25px;"></div>
							</a>
						</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>			
			</div>		
		</div>
<!-- 		<img src="../image/bucket/bucketBackground.png" class="imgBack">
 -->		
		
<%-- 
		<c:forEach items="${bucketlist}" var="bucket">
			<c:if test="${bucket.visible eq 'y' }">
				<a href="/bucket/familybucketdetail?bucketSeq=${bucket.bucketSeq }">
				<div class="bucketBox">
			        <img src="..${bucket.filepath }" style="width:100%; height: 200px;">
			        <div class="bucketTextBox">
				        <div class="bucketTitle">${bucket.title}</div>
				        <div class="bucketRegDate">등록일 <fmt:formatDate value="${bucket.regDate}" pattern="yyyy.MM.dd"/></div>
			        </div>
		        </div></a>
		    </c:if>
	    </c:forEach>
 --%>		
 	
 
	</div>	

	
	<script>

	
	$('.testbox').click(function(event){
	    const div = event.currentTarget;
	    const userId = $(div).data('member-id');
	    loadData(userId);
	});
		function loadData(userId) {
//		  const userId = div.getAttribute('data-member-id'); // 클릭한 버튼의 data-member-id 속성 값을 가져옵니다.

		  $.ajax({
		    type: 'GET',
		    url: '/bucket/bucketlistz',
		    data: { userId: userId },
		    dataType: 'json',
		    success: function(response) {
		    	console.log(response);
		    	
		      let output = '';
			
		      if (Array.isArray(response) && response.length === 0)  {
	              output = '<div class="noBucketText">등록된 버킷리스트가 없습니다.</div>';
	            } else {

		      // bucketList 배열을 순회하며 각 요소의 속성 값을 이용하여 HTML 문자열을 생성합니다.
		      response.forEach(bucket => {
		        const { bucketSeq, filepath, title } = bucket; // bucket 객체에서 bucketSeq, bucketListImg, bucketListTitle 속성 값을 가져옵니다.
		        
		        const bucketImgSrc = filepath ? filepath : '/image/itdaLogo.png';

		        output += `
		          <a href="/bucket/familybucketdetail?bucketSeq=`+bucketSeq+`">
		            <img src="..`+bucketImgSrc+`" style="width:100%; height: 155px;">
		            <div style="position: relative;">
		              <img src="../image/bucket/chkLine.png" style="width: 100%">
		              <span class="bucketTitleSpan">`+title+`</span>            
		            </div>
		            <div style="height: 25px;"></div>
		          </a>
		        `;
		      });
	            }
		      $('.listContainer').html(output); // HTML을 동적으로 생성하여 listContainer 영역에 적용합니다.
		    },
		    error: function(error) {
		      console.error(error);
		    }
		  });
		}
	</script>
	
	
</body>
</html>