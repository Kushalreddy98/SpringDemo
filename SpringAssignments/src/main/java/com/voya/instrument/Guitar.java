package com.voya.instrument;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements IInstrument{

	public void play(String song) {
		// TODO Auto-generated method stub
		System.out.println(song+" is played by Guitar");
	}

}
