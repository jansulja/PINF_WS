package com.tim15.util;

import java.util.Random;

import com.tim15.model.Banka;

public class BankaUtil {

	public static String generateBrojRacuna(Banka banka){

		String id = banka.getSifraBanke();
		String racun = String.valueOf(randInt(0, 9999999)) + String.valueOf(randInt(0, 999999));
		String konrolni_broj = getKontrolniBroj(id,racun);


		return id + "-" + racun + "-" + konrolni_broj;

	}

	private static String getKontrolniBroj(String id, String racun) {

		long num = Long.parseLong(id+racun);

		long checksum = 98-Math.floorMod(num*100, 97);

		return String.valueOf(checksum);
	}

	public static int randInt(int min, int max) {

	    // NOTE: This will (intentionally) not run as written so that folks
	    // copy-pasting have to think about how to initialize their
	    // Random instance.  Initialization of the Random instance is outside
	    // the main scope of the question, but some decent options are to have
	    // a field that is initialized once and then re-used as needed or to
	    // use ThreadLocalRandom (if using at least Java 1.7).
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive


	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}
