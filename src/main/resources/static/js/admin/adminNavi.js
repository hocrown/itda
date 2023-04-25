/**
 * 
 */
$(document).ready(function(){
	$(".logout").click(function() {
			sessionStorage.clear
			window.location.href= '/user/logout';
	});
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
});