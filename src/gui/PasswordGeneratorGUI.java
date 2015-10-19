import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.util.Random;
import java.awt.Desktop;

/**
 * @author rahul
 */
public class PasswordGeneratorGUI extends javax.swing.JFrame {

	public PasswordGeneratorGUI() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
    
    private void initComponents() {

        title = new javax.swing.JLabel();
        lengthlabel = new javax.swing.JLabel();
        lengthinput = new javax.swing.JTextField();
        checkboxdescription = new javax.swing.JLabel();
        lowercase = new javax.swing.JCheckBox();
        uppercase = new javax.swing.JCheckBox();
        digit = new javax.swing.JCheckBox();
        special = new javax.swing.JCheckBox();
        notifier = new javax.swing.JLabel();
        applybutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        title.setFont(new java.awt.Font("Cantarell", 0, 36));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Rocky's Password Generator");

        lengthlabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lengthlabel.setText("Password length:");

        checkboxdescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkboxdescription.setText("Include the following rules in the password,");

        lowercase.setText("Lowercase Letters");
        lowercase.setToolTipText("");

        uppercase.setText("Uppercase Letters");

        digit.setText("Numbers");

        special.setText("Special Characters");

        notifier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        applybutton.setText("Generate!");
        applybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applybuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 182, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lowercase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(digit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uppercase)
                                    .addComponent(special))
                                .addGap(216, 216, 216))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lengthlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lengthinput, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(checkboxdescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(notifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(180, 180, 180))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(applybutton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthinput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lengthlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkboxdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lowercase, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(uppercase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(digit, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(special, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(notifier, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(applybutton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }

    private void applybuttonActionPerformed(java.awt.event.ActionEvent evt) {
        int n = 1;
		String array = "";
		boolean lock = false;
		try {
			n = Integer.parseInt(lengthinput.getText());
			
			if(lowercase.isSelected())
				array += "qwertyuiopasdfghjklzxcvbnm";
				
			if(uppercase.isSelected())
				array += "QWERTYUIOPASDFGHJKLZXCVBNM";
				
			if(digit.isSelected())
				array += "1234567890";
				
			if(special.isSelected())
				array += "`~!@#$%^&*()-_=+[]{}|;:,<.>/?";
		}catch(java.lang.NumberFormatException e) {
			notifier.setForeground(new java.awt.Color(255, 0, 0));
			notifier.setText("Invalid input for length");
			lock = true;
		}
		
		if(array.equals("")) {
			if(!lock) {
				notifier.setForeground(new java.awt.Color(255, 0, 0));
				notifier.setText("Select atleast one rule");
			}
		}
		
		else {
			array = shuffle(array);
			int size = array.length();
			String password="";
			
			for(int i=0;i<n;i++)
				password += array.charAt(new Random().nextInt(size));
			
			saveFile(password);
		}
    }
	
	private void saveFile(String password) {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try(FileWriter fw = new FileWriter(file)) {
				fw.write(password);
				notifier.setForeground(new java.awt.Color(0, 0, 255));
				notifier.setText("Password saved successfully");
			}catch(IOException e) {
				notifier.setForeground(new java.awt.Color(255, 0, 0));
				notifier.setText("Error saving file in directory");
			}
			
			Desktop dt = Desktop.getDesktop();
			
			try {
				dt.open(file);
			}catch(IOException e) {
				notifier.setForeground(new java.awt.Color(255, 0, 0));
				notifier.setText("Error opening file");
			}
		}
	}
	
	private String shuffle(String array) {
		int size = array.length();
		char[] a = array.toCharArray();
		Random rnd = new Random();
    	
    	for(int i=size; i>1; i--)
    		a=swap(a, i-1, rnd.nextInt(i));
    	
    	return new String(a);
	}
	
	private char[] swap(char[] x, int a, int b) {
    	char t = x[a];
    	x[a] = x[b];
    	x[b] = t;
    	return x;
	}
	
	public static void main(String args[]) {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PasswordGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PasswordGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PasswordGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PasswordGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PasswordGeneratorGUI().setVisible(true);
			}
		});
	}

    private javax.swing.JButton applybutton;
    private javax.swing.JLabel checkboxdescription;
    private javax.swing.JCheckBox digit;
    private javax.swing.JTextField lengthinput;
    private javax.swing.JLabel lengthlabel;
    private javax.swing.JCheckBox lowercase;
    private javax.swing.JLabel notifier;
    private javax.swing.JCheckBox special;
    private javax.swing.JLabel title;
    private javax.swing.JCheckBox uppercase;
}
