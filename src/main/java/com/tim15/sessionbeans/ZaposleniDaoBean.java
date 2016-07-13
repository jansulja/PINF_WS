package com.tim15.sessionbeans;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.tim15.model.Zaposleni;
import com.tim15.model.Zaposleni;



@Stateless
@Local(ZaposleniDaoLocal.class)
public class ZaposleniDaoBean extends GenericDaoBean<Zaposleni, Integer> implements ZaposleniDaoLocal {

	@Context
	private HttpServletRequest request;

	@EJB
	private BankaDaoLocal bankaDao;

	@Override
	public Zaposleni login(String username, String password)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {

		Query q = em.createQuery(
				"select distinct u from " + "Zaposleni u where u.email = :username " + "and u.password = :password");
		q.setParameter("username", username);
		q.setParameter("password", password);

		@SuppressWarnings("unchecked")
		List<Zaposleni> users = q.getResultList();
		if (users.size() == 1) {
			request.getSession().setAttribute("zaposleni", users.get(0));
			return users.get(0);
		} else
			return null;
	}

	@Override
	public void logout() {
		request.getSession().invalidate();

	}



}
