package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.KursUValuti;



@Stateless
@Local(KursUValutiDaoLocal.class)
public class KursUValutiDaoBean extends GenericDaoBean<KursUValuti, Integer> implements KursUValutiDaoLocal{

}
