package action;

public class MyInfo {

 private int age;
 private int current_age=2018;
 
 
public int nai(int a) {
	
	age=current_age-a;
	return age+1;
	
}


public String get_tti(int a){
	int TTI;
	TTI=a%12;
	switch(TTI) {
	
	case 4 : return "��"; 
	case 5 :  return"��"; 
	case 6 :  return"ȣ����"; 
	case 7 :  return"�䳢"; 
	case 8 :  return"��"; 
	case 9 :  return"��"; 
	case 10 : return"��"; 
	case 11 : return"��"; 
	case 12 : return"��"; 
	case 1 :  return"��"; 
	case 2 :  return"��"; 
	case 3 :  return"��"; 
	default : return "����";
	
	}
		
	//System.out.printf("����� ��� %s�Դϴ�.",s);
	
}


public String getGang(int a) {
	int gapja=a%12;
	int ji=a%10;
	String gap="";
	String ja="";
 switch(ji) {
	
	case 4 :  gap="��"; break;
	case 5 :  gap="��"; break;
	case 6 :  gap="��"; break;
	case 7 :  gap="��"; break;
	case 8 :  gap="��"; break;
	case 9 :  gap="��"; break;
	case 10 : gap="��"; break;
	case 11 : gap="��"; break;
	case 1 :  gap="��"; break;
	case 2 :  gap="��"; break;

	default : System.out.println("�߸��Է��߽��ϴ�"); break;
	
	}
 
 switch(gapja) {
	
 case 4 :  ja="��"; break;
	case 5 :  ja="��"; break;
	case 6 :  ja="��"; break;
	case 7 :  ja="��"; break;
	case 8 :  ja="��"; break;
	case 9 :  ja="��"; break;
	case 10 :  ja="��"; break;
	case 11 :  ja="��"; break;
	case 12 :  ja="��"; break;
	case 1 :  ja="��"; break;
	case 2 :  ja="��"; break;
	case 3 :  ja="��"; break;

	default : System.out.println("�߸��Է��߽��ϴ�"); break;
	
	}

 
    return gap+ja;

	
	
}






public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public int getCurrent_age() {
	return current_age;
}


public void setCurrent_age(int current_age) {
	this.current_age = current_age;
}











}
