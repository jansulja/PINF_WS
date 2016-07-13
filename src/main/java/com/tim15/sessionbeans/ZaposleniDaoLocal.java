package com.tim15.sessionbeans;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.tim15.model.Klijent;
import com.tim15.model.Racuni;
import com.tim15.model.Zaposleni;


public interface ZaposleniDaoLocal extends GenericDao<Zaposleni, Integer> {

	public Zaposleni login(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	public void logout();



}
