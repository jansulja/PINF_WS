package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.DnevnoStanjeRacuna;

@Stateless
@Local(DnevnoStanjeRacunaDaoLocal.class)
public class DnevnoStanjeRacunaDaoBean extends GenericDaoBean<DnevnoStanjeRacuna, Integer> implements DnevnoStanjeRacunaDaoLocal{

}
