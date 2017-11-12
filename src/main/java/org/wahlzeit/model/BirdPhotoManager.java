package org.wahlzeit.model;

import java.util.logging.Logger;

public class BirdPhotoManager extends PhotoManager {
	
	protected static final BirdPhotoManager instance = new BirdPhotoManager();

	private static final Logger log = Logger.getLogger(BirdPhotoManager.class.getName());

	
	/**
	 * @methodtype constructor
	 */
	public BirdPhotoManager() {
		photoTagCollector = BirdPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	
}
