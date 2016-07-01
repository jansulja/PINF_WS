package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.Valuta;

@Stateless
@Local(ValutaDaoLocal.class)
public class ValutaDaoBean extends GenericDaoBean<Valuta, Integer> implements ValutaDaoLocal {



}
