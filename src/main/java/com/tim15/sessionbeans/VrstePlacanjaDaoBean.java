package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.Valuta;
import com.tim15.model.VrstePlacanja;

@Stateless
@Local(VrstePlacanjaDaoLocal.class)
public class VrstePlacanjaDaoBean extends GenericDaoBean<VrstePlacanja, Integer> implements VrstePlacanjaDaoLocal {



}
