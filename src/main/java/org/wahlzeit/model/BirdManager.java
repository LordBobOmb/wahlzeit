package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.wahlzeit.services.ObjectManager;

public class BirdManager extends ObjectManager{

	public HashMap<String, BirdType> birdTypes;
	public ArrayList<Bird> birds;
	
	public BirdManager() {
		birdTypes =  new HashMap<>();
		birdTypes.put("default", new BirdType("default"));
		birdTypes.put("owl", new BirdType("owl"));
		birdTypes.put("blue jay", new BirdType("blue jay"));
	}
	
	
	public void addBird(Bird bird) {
		birds.add(bird);
	}
	
	public Bird createBird(String typeName) {
		 BirdType birdType = getBirdType(typeName);
		 Bird result = birdType.createInstance();
		 birds.add(result);
		 return result;
		}
	
	private BirdType getBirdType(String typeName) {
		BirdType type = birdTypes.get(typeName);
		if (type != null) {
			return type;
		} else {
			BirdType newType = new BirdType(typeName);
			birdTypes.put(typeName, newType);
			return newType;
		}
	}
}
