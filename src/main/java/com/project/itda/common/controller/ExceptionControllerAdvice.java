package com.project.itda.common.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.itda.common.AccessDeniedException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	  @ExceptionHandler(AccessDeniedException.class)
	    public String handleAccessDeniedException(HttpSession session,
	            AccessDeniedException ex, Model model) throws IOException {
	        model.addAttribute("errorMessage", ex.getMessage());
	        return "error";
	    }
}