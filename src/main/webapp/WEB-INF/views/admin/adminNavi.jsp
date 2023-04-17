<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<div class="adminNaviBox">
			<div style="border-bottom: solid 1px;">
				<div class="navi-item adminSmallLogo"><img style="width: 7em; margin-right: 0.3em;" src="../image/itdaLogo.png"></div>
			</div>
			<div style="border-bottom: solid 1px;">
				<div id="navi-questionManagement" class="navi-hover">
					<div class="navi-item item-text">하루 질문 관리<img class="adminVector" src="../image/vector.png"></div>
				</div>

			</div>
			<!-- <div style="border-bottom: solid 1px;">
				<div id="navi-newsManagement" class="navi-hover">
					<div class="navi-item item-text">잇다소식 관리<img class="adminVector" src="../image/vector.png"></div>
				</div>
			</div> -->
			<div style="border-bottom: solid 1px;">
				<div id="navi-statistics" class="navi-hover">
					<div class="navi-item item-text">통계 관리<img class="adminVector" src="../image/vector.png"></div>
				</div>
			</div>
		</div>
		
		<div class="top-bar"><span style="margin-right: 5%;">안녕하세요! admin1234 님</span></div>
		
		<script>
		$(".navi-questionList").click(function(){
		    location.href = "/admin/questionmanagementlist";	
		});
		$("#navi-questionManagement").click(function(){
		    location.href = "/admin/questionmanagementlist";	
		});
		$(".navi-requestedList").click(function(){
		    location.href = "/admin/requestedquestionlist";	
		});
		$("#navi-newsManagement").click(function(){
		    location.href = "/admin/newsmanagementlist";	
		});
		$("#navi-statistics").click(function(){
		    location.href = "/admin/statistics";	
		});
		</script>