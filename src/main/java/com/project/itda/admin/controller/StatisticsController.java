package com.project.itda.admin.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.itda.admin.model.JoinCountModel;
import com.project.itda.admin.service.IAdminService;
import com.project.itda.admin.service.IStatisticsService;

@Controller
public class StatisticsController {
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	IStatisticsService statisticsService;
	
//	//통계 페이지
//	@GetMapping("/admin/statistics")
//	public String adminStatistics(Model model) {
//		
//		List<JoinCountModel> results = statisticsService.getJoinedMembersByMonth();
//		model.addAttribute("results", results);
//		System.out.println(results);
//		
//		
//		return "admin/statistics";
//	}	
	
	@GetMapping("/admin/statistics")
	public String getWeeklyVisitors(Model model) throws JacksonException {
	    
		List<Map<String, Object>> weeklyVisitorData = statisticsService.getWeeklyVisitors();
		ObjectMapper mapper = new ObjectMapper();
		int total = 0;
		String jsonString = mapper.writeValueAsString(weeklyVisitorData);
		for (int i=0; i<weeklyVisitorData.size(); i++ ) {
			BigDecimal count = (BigDecimal) weeklyVisitorData.get(i).get("COUNT");
			total += count.intValue();
		}
		
		List<JoinCountModel> joinCounts = statisticsService.getJoinedMembersByMonth();
		String joinCountsJson = mapper.writeValueAsString(joinCounts);
		
		int joinTotal = 0;
		int joinThisMonth = 0;
		LocalDate now = LocalDate.now();
		String currentMonth = now.format(DateTimeFormatter.ofPattern("yyyy-MM"));

		for (JoinCountModel joinCount : joinCounts) {
		    joinTotal += joinCount.getNumOfMembers();
		    if (joinCount.getJoinYearMonth().equals(currentMonth)) {
		        joinThisMonth = joinCount.getNumOfMembers();
		    }
		}
		
		double joinAverage = (double) total / joinCounts.size();
		DecimalFormat df = new DecimalFormat("#.#");
		String formattedAverage = df.format(joinAverage);

		
		BigDecimal btoday = (BigDecimal) weeklyVisitorData.get(weeklyVisitorData.size()-1).get("COUNT");
		int today = btoday.intValue();
		System.out.println(today);
		System.out.println(weeklyVisitorData.get(1).get("COUNT"));
		model.addAttribute("joinTotal", joinTotal);
		model.addAttribute("joinThisMonth", joinThisMonth);
		model.addAttribute("joinAverage", formattedAverage);
		model.addAttribute("joinCountsJson", joinCountsJson);
		model.addAttribute("total", total);
		model.addAttribute("today", today);
		model.addAttribute("weeklyVisitorData", jsonString);
	    return "admin/statistics";
    }
}
