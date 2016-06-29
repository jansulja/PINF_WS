package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.Racuni;


@Stateless
@Local(RacuniDaoLocal.class)
public class RacuniDaoBean extends GenericDaoBean<Racuni, Integer> implements RacuniDaoLocal {

}
