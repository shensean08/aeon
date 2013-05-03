import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.applet.Applet;  

import java.io.*;
import java.net.*;
  
import sun.misc.BASE64Encoder; 

public class DownloadApplet extends Applet implements ActionListener {
	private static final long serialVersionUID = 7973760697552446266L;
	
	private static final String urlString = "http://127.0.0.1:8080/aeonsite/downloadAction.action";

    private JTextArea textArea;
    private JTextField textField;
	
    public void init() {
        // Add a text field that provides the URL to download.
        this.textField = new JTextField("http://www2.hawaii.edu/~yucheng/home");
        this.textField.addActionListener(this);

        // Add a button that downloads the content from the URL.
        final JButton button = new JButton("Download");
        button.addActionListener(this);

        // Add a text area that displays the downloaded content.
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        this.textArea.setLineWrap(true);

        // Layout the Applet.
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(8, 8));
        panel.add(this.textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.LINE_END);
        this.setLayout(new BorderLayout(8, 8));
        this.add(panel, BorderLayout.PAGE_START);
        this.add(new JScrollPane(this.textArea), BorderLayout.CENTER);
    }
	
    public void actionPerformed(final ActionEvent event) {
        try {
            // Download and display the contents for the URL.
            final URL url = new URL(this.textField.getText());
            final String contents = download();
            this.textArea.setForeground(Color.BLACK);
            this.textArea.setText(contents);

        } catch (final Exception e) {
            // Display information about the exception.
            this.textArea.setForeground(Color.RED);
            this.textArea.setText(e.toString());
        }
    }

    public String download() {
    	try {
    		DownloadImage("1234567890");
        } catch ( Exception e) {
            // Display information about the exception.
            this.textArea.setForeground(Color.RED);
            this.textArea.setText(e.toString());
        }
        return "ok";
    }
    
	private static byte[] CaptureScreen() throws Exception {
		byte[] result = null;
		
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRectangle);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			ImageIO.write(image, "png", outStream);
			result = outStream.toByteArray();
		
		return result;
	}
	
	private static String Bytes2BASE64(byte[] value) {
		String result = "";

		result = new BASE64Encoder().encode(value);

		return result;
	}
	
	
	public static void DownloadImage(String userID,String sLat,String sLng,) throws Exception {
			// capture Screen
			String pic = Bytes2BASE64(CaptureScreen());
			
			URL url = new URL(urlString);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	
			// post 
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
	
			String content = URLEncoder.encode("pic", "UTF-8") + "=" + URLEncoder.encode(pic, "UTF-8");
			content += "&" + URLEncoder.encode("userID", "UTF-8") + "=" + userID;
			
			out.writeBytes(content);
			out.flush();
			out.close();
			
			//server response
			DataInputStream inStream = new DataInputStream(connection.getInputStream());
			String strResponse = inStream.readLine();
			inStream.close();
			
			connection.disconnect();
	}
}
