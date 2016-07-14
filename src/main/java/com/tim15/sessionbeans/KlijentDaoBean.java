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

import com.tim15.model.Banka;
import com.tim15.model.FizickoLice;
import com.tim15.model.Klijent;
import com.tim15.model.PravnoLice;
import com.tim15.model.Racuni;



@Stateless
@Local(KlijentDaoLocal.class)
public class KlijentDaoBean extends GenericDaoBean<Klijent, Integer> implements KlijentDaoLocal {

	@Context
	private HttpServletRequest request;

	@EJB
	private BankaDaoLocal bankaDao;

	@EJB
	private PravnoLiceDaoLocal pravnoLiceDao;


	@EJB
	private FizickoLiceDaoLocal fizickoLiceDao;

	@Override
	public Klijent login(String username, String password)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {

		Query q = em.createQuery(
				"select distinct u from " + "Klijent u where u.email = :username " + "and u.password = :password");
		q.setParameter("username", username);
		q.setParameter("password", password);

		@SuppressWarnings("unchecked")
		List<Klijent> users = q.getResultList();
		if (users.size() == 1) {
			request.getSession().setAttribute("klijent", users.get(0));
			return users.get(0);
		} else
			return null;
	}

	@Override
	public void logout() {
		request.getSession().invalidate();

	}

	@Override
	public Racuni getRacunUBanci(int klijentId, int bankaId) {

		Banka banka = bankaDao.findById(bankaId);
		Racuni racun = null;

		for(Racuni racuni : banka.getRacuni()){

			if(racuni.getKlijent().getKlijentId() == klijentId){
				racun = racuni;
				break;
			}

		}
		return racun;
	}

	@Override
	public String getNaziv(int klijentId) {


		PravnoLice pl = pravnoLiceDao.findById(klijentId);
		FizickoLice fl = fizickoLiceDao.findById(klijentId);

		String naziv = null;
		if(pl!=null){

			naziv = pl.getNaziv();

		}else{
			naziv = fl.getPunoIme();
		}


		return naziv;
	}


}
