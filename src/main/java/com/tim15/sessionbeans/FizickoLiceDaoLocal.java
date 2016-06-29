package com.tim15.sessionbeans;

import com.tim15.model.FizickoLice;

public interface FizickoLiceDaoLocal extends GenericDao<FizickoLice, Integer> {

	public void register(FizickoLice fizickoLice) throws NoSuchFieldException;

}
