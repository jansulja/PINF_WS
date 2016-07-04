package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.AnalitikaIzvoda;
import com.tim15.model.NaseljenoMesto;

@Stateless
@Local(NaseljenoMestoDaoLocal.class)
public class NaseljenoMestoDaoBean extends GenericDaoBean<NaseljenoMesto, Integer> implements NaseljenoMestoDaoLocal{

}
