package com.tim15.sessionbeans;

import com.tim15.model.PravnoLice;

public interface PravnoLiceDaoLocal extends GenericDao<PravnoLice, Integer> {

	public void register(PravnoLice pravnoLice) throws NoSuchFieldException;

}
