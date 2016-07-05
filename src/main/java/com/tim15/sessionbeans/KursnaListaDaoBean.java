package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.KursnaLista;

@Stateless
@Local(KursnaListaDaoLocal.class)
public class KursnaListaDaoBean extends GenericDaoBean<KursnaLista, Integer> implements KursnaListaDaoLocal{

}
