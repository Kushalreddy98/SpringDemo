package com.voya.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Performer {
	@Autowired
	private IInstrument violin;
	@Autowired
	private IInstrument guitar;
	@Autowired
	private IInstrument keyboard;
	
	
	 void playMusic(String choice,String song) {
		 if(choice.equals("guitar"))
			 guitar.play(song);
		 if(choice.equals("violin"))
			 violin.play(song);
		 if(choice.equals("keyboard"))
			 keyboard.play(song);
	 }

}
