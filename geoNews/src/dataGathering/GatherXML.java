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
		//System.out.println(xml.getAttributeCount());
		
		System.out.println(xml.toString());
		XMLElement channel = xml.getChild(0);
		System.out.println(channel.getChild("item"));
		XMLElement[] items = channel.getChildren("item");
		
		System.out.println(items.length);
		for (int i = 0; i < items.length; i ++){
			//XMLElement description = ;
			
			try {
				System.out.println(items[i].getChild("georss:point").getContent());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GatherXML();

	}

}
