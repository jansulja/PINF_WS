package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.Kliring;



@Stateless
@Local(KliringDaoLocal.class)
public class KliringDaoBean extends GenericDaoBean<Kliring, Integer> implements KliringDaoLocal {




}
