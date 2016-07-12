package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.Rtgs;




@Stateless
@Local(RtgsDaoLocal.class)
public class RtgsDaoBean extends GenericDaoBean<Rtgs, Integer> implements RtgsDaoLocal {






}
