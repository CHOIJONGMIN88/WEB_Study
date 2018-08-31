package util;
/*		pageURL:����¡ó���� ����Ʈ ������ 
        nowPage:����������
        rowTotal:��ü�����Ͱ���
        blockList:���������� �Խù���
        blockPage:��ȭ�鿡 ��Ÿ�� ������ ��ϼ�
 */
public class Paging {
	public static String getPaging(
			String pageURL,  //list.do
			int nowPage, 
			int rowTotal,
			int blockList, 
			int blockPage){
		
		
		int totalPage/*��ü��������*/,
            startPage/*������������ȣ*/,
            endPage;/*��������������ȣ*/

		boolean  isPrevPage,isNextPage;
		StringBuffer sb; //��� ��Ȳ�� �Ǵ��Ͽ� HTML�ڵ带 ������ ��
		
		
		isPrevPage=isNextPage=false;
		//�Էµ� ��ü �ڿ��� ���� ��ü ������ ���� ���Ѵ�..
		totalPage = (int)(rowTotal/blockList);
		if(rowTotal%blockList!=0)totalPage++;
		//�ִ������� +1

		//���� �߸��� ����� ���������� ���Ͽ� ���� ������ ���� ��ü ������ ����
		//���� ��� ������ ���������� ���� ��ü ������ ������ ����
		if(nowPage > totalPage)nowPage = totalPage;
		

		//���� �������� ������ �������� ����.
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		//���� �ϱ� 
		endPage = startPage + blockPage - 1; //
		
		//������ ������ ���� ��ü������������ ũ�� ������������ ���� ����
		if(endPage > totalPage)endPage = totalPage;
		
		//�������������� ��ü���������� ���� ��� ���� ����¡�� ������ �� �ֵ���
		//boolean�� ������ ���� ����
		if(endPage < totalPage) isNextPage = true;
		//������������ ���� 1���� ������ ��������¡ ������ �� �ֵ��� ������
		if(startPage > 1)isPrevPage = true;
		
		//HTML�ڵ带 ������ StringBuffer����=>�ڵ����
		sb = new StringBuffer();
//-----�׷�������ó�� ���� --------------------------------------------------------------------------------------------		
		if(isPrevPage){
			sb.append("<a href ='"+pageURL+"?page=");
			sb.append(nowPage - blockPage);
			sb.append("'>��</a>");
		}
		else
			sb.append("��");
		
//------������ ��� ��� -------------------------------------------------------------------------------------------------
		sb.append("|");
		for(int i=startPage; i<= endPage ;i++){
			if(i>totalPage)break;
			if(i == nowPage){ //���� �ִ� ������
				sb.append("&nbsp;<b><font color='#91b72f'>");
				sb.append(i);
				sb.append("</font></b>");
			}
			else{//���� �������� �ƴϸ�
				sb.append("&nbsp;<a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}// end for
		//idx Ʈ��ŷ�۾� ����ó�� �Ŀ��� �ڱⰡ�ִ� �������� ���ƿ��°Ͱ�
		//���� �Ŀ��� idx���� Ʈ��ŷ�ϸ鼭 ���� �ڽ��� �������� �̵��ҋ� idx�� page�� ������ �̵��ؾߵȴ�.
		//��۴޶� �������� ����ؼ� ������ ���� �۾� 
		
		
		sb.append("&nbsp;|");
		
//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		if(isNextPage){
			sb.append("<a href='"+pageURL+"?page=");
			
			sb.append(endPage+1);
		}
		else
			sb.append("��");
//---------------------------------------------------------------------------------------------------------------------	    

		return sb.toString();
	}




		//��� Ŀ��Ʈ ����¡
	public static String getCommentPaging(
		
			int nowPage, 
			int rowTotal,
			int blockList, 
			int blockPage){
		
		
		
		
		
		int totalPage/*��ü��������*/,
            startPage/*������������ȣ*/,
            endPage;/*��������������ȣ*/

		boolean  isPrevPage,isNextPage;
		StringBuffer sb; //��� ��Ȳ�� �Ǵ��Ͽ� HTML�ڵ带 ������ ��
		
		
		isPrevPage=isNextPage=false;
		//�Էµ� ��ü �ڿ��� ���� ��ü ������ ���� ���Ѵ�..
		totalPage = (int)(rowTotal/blockList);
		if(rowTotal%blockList!=0)totalPage++;
		

		//���� �߸��� ����� ���������� ���Ͽ� ���� ������ ���� ��ü ������ ����
		//���� ��� ������ ���������� ���� ��ü ������ ������ ����
		if(nowPage > totalPage)nowPage = totalPage;
		

		//���� �������� ������ �������� ����.
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1; //
		
		//������ ������ ���� ��ü������������ ũ�� ������������ ���� ����
		if(endPage > totalPage)endPage = totalPage;
		
		//�������������� ��ü���������� ���� ��� ���� ����¡�� ������ �� �ֵ���
		//boolean�� ������ ���� ����
		if(endPage < totalPage) isNextPage = true;
		//������������ ���� 1���� ������ ��������¡ ������ �� �ֵ��� ������
		if(startPage > 1)isPrevPage = true;
		
		//HTML�ڵ带 ������ StringBuffer����=>�ڵ����
		sb = new StringBuffer();
//-----�׷�������ó�� ���� --------------------------------------------------------------------------------------------		
		if(isPrevPage){
			sb.append("<a onclick='comment_list(");
			sb.append(nowPage - blockPage);
			sb.append(");>��</a>");
		}
		else
			sb.append("��");
		
//------������ ��� ��� -------------------------------------------------------------------------------------------------
		sb.append("|");
		for(int i=startPage; i<= endPage ;i++){
			if(i>totalPage)break;
			if(i == nowPage){ //���� �ִ� ������
				sb.append("&nbsp;<b><font color='#91b72f'>");
				sb.append(i);
				sb.append("</font></b>");
			}
			else{//���� �������� �ƴϸ�
				sb.append("&nbsp;<a onclick='comment_list(");
				sb.append(i);
				sb.append(")'>");
				sb.append(i);
				sb.append("</a>");
			}
		}// end for
		//idx Ʈ��ŷ�۾� ����ó�� �Ŀ��� �ڱⰡ�ִ� �������� ���ƿ��°Ͱ�
		//���� �Ŀ��� idx���� Ʈ��ŷ�ϸ鼭 ���� �ڽ��� �������� �̵��ҋ� idx�� page�� ������ �̵��ؾߵȴ�.
		//��۴޶� �������� ����ؼ� ������ ���� �۾� 
		
		
		sb.append("&nbsp;|");
		
//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		if(isNextPage){
			sb.append("<a onclick='comment_list(");
			
			sb.append(endPage+1);
		}
		else
			sb.append(");��");
//---------------------------------------------------------------------------------------------------------------------	    

		return sb.toString();
	}
}
