package com.tim15;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tim15.model.Drzava;

public class Test {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "{\"nazivDrzave\" : \"naziv1\"}";

		Drzava obj = null;

		//JSON from String to Object
		try {

			obj = mapper.readValue(jsonInString, Drzava.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
