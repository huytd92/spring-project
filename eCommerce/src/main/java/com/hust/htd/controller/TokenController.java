package com.hust.htd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuyTaDuc
 */

@RestController
@RequestMapping("/api/token")
public class TokenController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<CsrfToken> getToken(HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		return new ResponseEntity<CsrfToken>(token, HttpStatus.OK);
	}
}
