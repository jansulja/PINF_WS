package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.AnalitikaIzvoda;

@Stateless
@Local(AnalitikaIzvodaDaoLocal.class)
public class AnalitikaIzvodaDaoBean extends GenericDaoBean<AnalitikaIzvoda, Integer> implements AnalitikaIzvodaDaoLocal{

}
