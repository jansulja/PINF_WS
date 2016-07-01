package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.Ukidanje;
import com.tim15.model.Valuta;
import com.tim15.model.VrstePlacanja;

@Stateless
@Local(UkidanjeDaoLocal.class)
public class UkidanjeDaoBean extends GenericDaoBean<Ukidanje, Integer> implements UkidanjeDaoLocal {



}
