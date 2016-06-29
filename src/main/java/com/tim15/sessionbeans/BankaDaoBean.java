package com.tim15.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.tim15.model.Banka;
@Stateless
@Local(BankaDaoLocal.class)
public class BankaDaoBean extends GenericDaoBean<Banka, Integer> implements BankaDaoLocal{

}
