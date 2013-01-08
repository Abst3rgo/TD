package xmas.application;

import xmas.controller.IController;
import xmas.parts.ISpielfeld;

import com.google.inject.AbstractModule;

public class XmasModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IController.class).to(xmas.controller.impl.Controller.class);
		bind(ISpielfeld.class).to(xmas.parts.impl.Spielfeld.class);
		
	}

}
