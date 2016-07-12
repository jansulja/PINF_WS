package com.tim15.sessionbeans;

import com.tim15.model.Kliring;


public interface KliringDaoLocal extends GenericDao<Kliring, Integer> {

	public Kliring getNext();

}
