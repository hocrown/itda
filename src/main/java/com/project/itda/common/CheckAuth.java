package com.project.itda.common;

import javax.servlet.http.HttpSession;

public class CheckAuth {
	
	public static void checkLogin(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			throw new AccessDeniedException("로그인이 필요한 페이지입니다.");
		}
	}

	public static void checkFamilyMember(HttpSession session, int familySeq) {
		int sessionFamilySeq = (int) session.getAttribute("famSeq");
		if (sessionFamilySeq != familySeq) {
			throw new AccessDeniedException("접근할 수 없는 <br> 사용자입니다.");
		}
	}
}