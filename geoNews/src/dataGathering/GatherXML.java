package dataGathering;


import processing.core.PApplet;
import processing.xml.XMLElement;

public class GatherXML {

	/**
	 * @param args
	 */
	
	
	XMLElement xml;
	PApplet p;
	
	public GatherXML(){
		p = new PApplet();
		xml =  new XMLElement(p, "http://emm.newsbrief.eu/rss?type=alert&id=Jamaica&language=en");
		System.out.println(xml.getAttributeCount());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GatherXML();

	}

}
