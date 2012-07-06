package dataGathering;


import java.util.ArrayList;

import processing.core.PApplet;
import processing.xml.XMLElement;

public class GatherXML {

	/**
	 * @param args
	 */
	
	
	
	PApplet p;
	
	public GatherXML(){
		
		String tester = "http://emm.newsbrief.eu/rss?type=alert&id=Jamaica&category=AnimalHealth&language=all";
		tester = "http://emm.newsbrief.eu/rss?type=category&id=UnitedKingdom&language=all&duplicates=false";
		//tester = "http://emm.newsexplorer.eu/rss?type=clusters&language=en";
		//tester = "http://emm.newsbrief.eu/rss?type=entity&id=11&language=fr";
		//tester = "http://emm.newsexplorer.eu/rss?type=entity&id=11&language=fr";
		XMLElement channel = rawXML(tester);
		XMLElement[] items = channel.getChildren("item");
		
		for (int i = 0; i < items.length; i ++){
			try {

				//System.out.println(detectPlaceNameInXML("jamaica", items[i]));
				if (detectPlaceNameInXML("london", items[i]) == true){
					System.out.println(items[i].getChild("description").getContent());
					System.out.println(items[i].getChild("georss:point").getContent());
					entityList(items[i]);
					
				}
				
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
	
	public XMLElement rawXML(String url){
		p = new PApplet();
		XMLElement xml =  new XMLElement(p, url);
		XMLElement channel = xml.getChild(0);
		return channel;
	}
	
	
	public ArrayList entityList(XMLElement xml){
		ArrayList list = new ArrayList();
		XMLElement[] items = xml.getChildren("emm:entity");
		for (int i = 0; i < items.length; i ++){
			System.out.print(items[i].getContent()+" ");
			System.out.println(items[i].getString("id"));
		}
		return list;
		
		
	}
	
	public boolean detectPlaceNameInXML(String name, XMLElement xml){
			String a = "";
			String b = "";
			String c = "";
			try {
				a = xml.getChild("description").getContent();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b = xml.getChild("title").getContent();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				c = xml.getChild("link").getContent();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String checker = a+b+c;
			checker = checker.toLowerCase();
			return checker.contains(name);
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GatherXML();

	}

}
