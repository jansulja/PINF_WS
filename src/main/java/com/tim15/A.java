package com.tim15;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tim15.model.Valuta;

public class A {


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "a", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Fetch(FetchMode.SELECT)
	private java.util.Collection<A> listA;

}
