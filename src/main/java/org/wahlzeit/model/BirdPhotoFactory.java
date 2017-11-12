package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class BirdPhotoFactory extends PhotoFactory {

	
	private static final Logger log = Logger.getLogger(BirdPhotoFactory.class.getName());
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static BirdPhotoFactory instance = null;
	
	/**
	 * @methodtype constructor
	 */
	public BirdPhotoFactory() {
		super();
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized BirdPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting BirdPhotoFactory").toString());
			setInstance(new BirdPhotoFactory());
		}

		return instance;
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public BirdPhoto createPhoto() {
		return new BirdPhoto();
	}
	
	/**
	 * @methodtype factory
	 */
	
	@Override
	public BirdPhoto createPhoto(PhotoId id) {
		return new BirdPhoto(id);
	}
	
}
