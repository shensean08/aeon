<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="edu.kgu.aeon.logic.loginQrLogic"%>
<%  
	
	String QRCode = new String(request.getParameter("qrcode").getBytes("iso-8859-1"),"UTF-8");
	loginQrLogic logic = new loginQrLogic();
	String res = logic.execute(QRCode);
   	//"1315492432"
   	//response.setContentType("text/html charset=utf-8");
   	//PrintWriter out = response.getWriter();
    
	out.println(res); 
%>
<% 
//	out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><places><place><name>家</name><address>大阪府大阪市浪速区日本橋3丁目2-36</address><geometry><location><lat></lat><lng></lng></location></geometry></place><place><name>学校</name><address>兵庫県三田市学園2丁目1</address><geometry><location><lat></lat><lng></lng></location></geometry></place><place><name>会社</name><address>大阪府大阪市北区梅田2丁目1</address><geometry><location><lat></lat><lng></lng></location></geometry></place></places>");
%>	