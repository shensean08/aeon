import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class UnsignedApplet extends JApplet implements ActionListener {
    private static final long serialVersionUID = -4370650602318597069L;

    private JTextArea textArea;
    private JTextField textField;

    @Override
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
            final String contents = download(url.openStream());
            this.textArea.setForeground(Color.BLACK);
            this.textArea.setText(contents);

        } catch (final Exception e) {
            // Display information about the exception.
            this.textArea.setForeground(Color.RED);
            this.textArea.setText(e.toString());
        }
    }

    private static String download(final InputStream in) throws IOException {
        // Read all bytes from the stream and return the data as a string.
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        int ch;
        while (-1 != (ch = in.read()))
            out.write(ch);
        return out.toString();
    }
}