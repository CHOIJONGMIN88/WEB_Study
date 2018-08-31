package util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import vo.PersonVo;

public class PersonXMLParser {

	public static List<PersonVo> getPersonList(){
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		try {
			//XML Parser
			SAXBuilder builder = new SAXBuilder();
			URL url = new URL("http://localhost:9090/2018_0730_XmlTest/person.xml");
			//Document doc : 읽어오 XML문서를 관리하는 객체
			Document   doc     = builder.build(url.openStream());
			//inputstream 과 openStream차이?
			
			
			System.out.println(doc.toString());	
			
			Element root = doc.getRootElement();
			//persons의 자식 Element 구하기 
			List<Element> p_list = root.getChildren();
			//Element 타입으로 반환한다.
			//getchildren이 xml파일의  데이터를 arraylist로 가져온다.
			
			//자식요소(person)를 순서대로 반복
			for(Element person : p_list) {
				PersonVo vo = new PersonVo();
				

				//<person>자식 <name>의 값을 읽어오기
				String name = person.getChildText("name");
				String nickname = person.getChild("name").getAttributeValue("nickname");
				//부모 요소의 name이 가지고 있는 자식 요소인 nickname을 가져오는 방식이다. 
				int age=Integer.parseInt(person.getChildText("age"));
				//String tel = person.getChildText("tel");
				
				//person의 하위 emement요소를 구함 위에 구문과 동일한 뜻을 풀어쓴코드 
				
			//	Element tel_element = person.getChild("tel");				
			//String tel = tel_element.getText();
				String tel= person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");			
			//	String hometel = tel_element.getAttributeValue("hometel");
				
				vo.setName(name);
				vo.setNickname(nickname);
				vo.setAge(age);
				vo.setTel(tel);
				vo.setHometel(hometel);
				
				list.add(vo);
		
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
}
