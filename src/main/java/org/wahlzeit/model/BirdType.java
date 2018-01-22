package org.wahlzeit.model;
public class BirdType {

	public BirdPhotoManager manager;
	public String typeName;
	public BirdType family;
	
	public BirdType(String typeName) {
		this.typeName = typeName;
	}
	
	public BirdType(String typeName, BirdType family) {
		this.typeName = typeName;
		this.family  = family;
	}
	
	public boolean isSubtype(BirdType type) {
		return family.equals(type);
	}
	
	public Bird createInstance() {
		return new Bird(this);
	}
}
