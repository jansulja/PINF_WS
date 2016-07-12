package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.StavkaKliringa;

@Stateless
@Local(StavkaKliringaLocal.class)
public class StavkaKliringaDaoBean extends GenericDaoBean<StavkaKliringa, Integer> implements StavkaKliringaLocal {



}
