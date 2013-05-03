import java.io.*;
import java.net.*;
import sun.misc.BASE64Encoder;

public class postImage {
	static String sessionId = "";

	public static String getPicBASE64() {
		String picPath="/Users/seanshen/Documents/route1.jpg";
		String content = "";
		try {
			FileInputStream fileForInput = new FileInputStream(picPath);
			byte[] bytes = new byte[fileForInput.available()];
			fileForInput.read(bytes);
			content = new sun.misc.BASE64Encoder().encode(bytes);
			fileForInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
  
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://127.0.0.1:8080/aeon/downloadAction.action");
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		connection.connect();
		Long sendTime = System.currentTimeMillis();
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());

		String content = URLEncoder.encode("pic", "UTF-8") + "=" + URLEncoder.encode(getPicBASE64(), "UTF-8");
		
		out.writeBytes(content);
		out.flush();
		out.close(); // flush and close
		
		//Get Session ID
		String key = "";
		if (connection != null)
		{
		for (int i = 1; (key = connection.getHeaderFieldKey(i)) != null; i++) 
		{
		if (key.equalsIgnoreCase("set-cookie"))
		{
		sessionId = connection.getHeaderField(key);
		sessionId = sessionId.substring(0, sessionId.indexOf(";"));
		}
		}
		}
		
		// ------------------ read the SERVER RESPONSE
		try {
		DataInputStream inStream = new DataInputStream(connection.getInputStream());
		String str;
		if((str = inStream.readLine()) != null)
		{
		System.out.println("Server response is: " + str);
		System.out.println("");
		}
		inStream.close();
		} 
		catch (IOException ioex) 
		{
		System.out.println("From (ServerResponse): " + ioex);
		}
		connection.disconnect();
	}
}
