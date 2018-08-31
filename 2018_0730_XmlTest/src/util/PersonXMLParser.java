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
			//Document doc : �о�� XML������ �����ϴ� ��ü
			Document   doc     = builder.build(url.openStream());
			//inputstream �� openStream����?
			
			
			System.out.println(doc.toString());	
			
			Element root = doc.getRootElement();
			//persons�� �ڽ� Element ���ϱ� 
			List<Element> p_list = root.getChildren();
			//Element Ÿ������ ��ȯ�Ѵ�.
			//getchildren�� xml������  �����͸� arraylist�� �����´�.
			
			//�ڽĿ��(person)�� ������� �ݺ�
			for(Element person : p_list) {
				PersonVo vo = new PersonVo();
				

				//<person>�ڽ� <name>�� ���� �о����
				String name = person.getChildText("name");
				String nickname = person.getChild("name").getAttributeValue("nickname");
				//�θ� ����� name�� ������ �ִ� �ڽ� ����� nickname�� �������� ����̴�. 
				int age=Integer.parseInt(person.getChildText("age"));
				//String tel = person.getChildText("tel");
				
				//person�� ���� emement��Ҹ� ���� ���� ������ ������ ���� Ǯ��ڵ� 
				
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
