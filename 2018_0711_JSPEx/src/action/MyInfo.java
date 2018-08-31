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
	
	case 4 : return "쥐"; 
	case 5 :  return"소"; 
	case 6 :  return"호랑이"; 
	case 7 :  return"토끼"; 
	case 8 :  return"용"; 
	case 9 :  return"뱀"; 
	case 10 : return"오"; 
	case 11 : return"미"; 
	case 12 : return"신"; 
	case 1 :  return"유"; 
	case 2 :  return"술"; 
	case 3 :  return"해"; 
	default : return "없음";
	
	}
		
	//System.out.printf("당신의 띠는 %s입니다.",s);
	
}


public String getGang(int a) {
	int gapja=a%12;
	int ji=a%10;
	String gap="";
	String ja="";
 switch(ji) {
	
	case 4 :  gap="갑"; break;
	case 5 :  gap="을"; break;
	case 6 :  gap="병"; break;
	case 7 :  gap="정"; break;
	case 8 :  gap="무"; break;
	case 9 :  gap="기"; break;
	case 10 : gap="경"; break;
	case 11 : gap="신"; break;
	case 1 :  gap="임"; break;
	case 2 :  gap="계"; break;

	default : System.out.println("잘못입력했습니다"); break;
	
	}
 
 switch(gapja) {
	
 case 4 :  ja="자"; break;
	case 5 :  ja="축"; break;
	case 6 :  ja="인"; break;
	case 7 :  ja="묘"; break;
	case 8 :  ja="진"; break;
	case 9 :  ja="사"; break;
	case 10 :  ja="오"; break;
	case 11 :  ja="미"; break;
	case 12 :  ja="신"; break;
	case 1 :  ja="유"; break;
	case 2 :  ja="술"; break;
	case 3 :  ja="해"; break;

	default : System.out.println("잘못입력했습니다"); break;
	
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
