package com.tim15.sessionbeans;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.tim15.model.Klijent;
import com.tim15.model.Racuni;


public interface KlijentDaoLocal extends GenericDao<Klijent, Integer> {

	public Klijent login(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	public void logout();

	public Racuni getRacunUBanci(int klijentId, int bankaId);

	public String getNaziv(int klijentId);

}
