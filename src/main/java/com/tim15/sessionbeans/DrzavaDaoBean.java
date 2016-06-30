package com.tim15.sessionbeans;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.tim15.model.Drzava;




@Stateless
@Local(DrzavaDaoLocal.class)
public class DrzavaDaoBean extends GenericDaoBean<Drzava, Integer> implements DrzavaDaoLocal {

	@Context
	private HttpServletRequest request;






}
