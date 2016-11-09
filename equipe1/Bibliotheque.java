import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
*
* @author hamza
* 
* 
* 
*/

public class Bibliotheque {
	  private javax.swing.JMenuItem jMenuItem1;
	    private javax.swing.JMenuItem jMenuItem3;
	    private javax.swing.JMenuItem jMenuItem4;
	    private javax.swing.JMenuItem jMenuItem6;
	    private javax.swing.JPopupMenu jPopupMenu1;

	

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	static String []filename1= new String[300];
	static String []filenamee= new String[300];

	int li=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bibliotheque window = new Bibliotheque();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		for(int i=0;i<300;i++){
			filename1[i] ="";
			filenamee[i] ="";}
		
	}

	/**
	 * Create the application.
	 */
	
	  private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {
		  if(evt.isPopupTrigger())  {
		                          JTable source = (JTable)evt.getSource();
		                       li = source.rowAtPoint( evt.getPoint() );
		                      System.out.println(li);

		      jPopupMenu1.show(evt.getComponent(),evt.getX(),evt.getY());

		  }      
		      }
	
	
	public Bibliotheque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  jPopupMenu1 = new javax.swing.JPopupMenu();
	        jMenuItem1 = new javax.swing.JMenuItem();
	        jMenuItem3 = new javax.swing.JMenuItem();
	        jMenuItem4 = new javax.swing.JMenuItem();
	        jMenuItem6 = new javax.swing.JMenuItem();
	        
	        
	        
	        
	        jMenuItem1.setText("Importer le  PDF");
	        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem1ActionPerformed(evt);
	            }

				private void jMenuItem1ActionPerformed(ActionEvent evt) {
					
					JFileChooser chooser= new JFileChooser();
			        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF FILES", "pdf", "text");
			chooser.setFileFilter(filter);
			chooser.showOpenDialog(null);
			File f= chooser.getSelectedFile();
			filename1[li]= f.getAbsolutePath();
			filenamee[li]=f.getName();
			if(!filename1[li].equals("")){
			    
			    
			     JOptionPane.showMessageDialog(null, filenamee[li]+"  a été associé avec succès");
			    
			    
			    
			}
					
					
					
				}
	        });
	        jPopupMenu1.add(jMenuItem1);

	        jMenuItem3.setText("Ouvrir le PDF");
	        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem3ActionPerformed(evt);
	            }

				private void jMenuItem3ActionPerformed(ActionEvent evt) {
					
					
					String s =new String();
					s=filename1[li];
					System.out.println(s);
					        if (s.equals("")){
					        JOptionPane.showMessageDialog(null, "Vous devez importer un PDF avant d'ouvrir un fichier");


					}else{
					      try {
					                File myFile = new File( s);
					                Desktop.getDesktop().open(myFile);
					            } catch (IOException ex) {
					                // no application registered for PDFs
					            }

					}

					
					
					
					
				}
	        });
	        jPopupMenu1.add(jMenuItem3);

	        jMenuItem4.setText("Supprimer le PDF associé");
	        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem4ActionPerformed(evt);
	            }

				private void jMenuItem4ActionPerformed(ActionEvent evt) {
					
					
					filename1[li]="";
					JOptionPane.showMessageDialog(null, "le Pdf associé est supprimé avec succès");

				
					
				}
	        });
	        jPopupMenu1.add(jMenuItem4);

	        jMenuItem6.setText("Supprimer l'élément");
	        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem6ActionPerformed(evt);
	            }

				private void jMenuItem6ActionPerformed(ActionEvent evt) {
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(li);
					filename1[li]="";
					JOptionPane.showMessageDialog(null, "Elément supprimé avec succès");
					
					
										
				}
	        });
	        jPopupMenu1.add(jMenuItem6);

	        
	        
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmImporter = new JMenuItem("Importer ");
		mntmImporter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			      String[] infoo = new String [12]; 
			        JFileChooser chooser= new JFileChooser();
			        FileNameExtensionFilter filter = new FileNameExtensionFilter("BIBTEX FILES", "bib", "text");
			chooser.setFileFilter(filter);
			chooser.showOpenDialog(null);
			File f= chooser.getSelectedFile();
			String filename= f.getAbsolutePath();
			 filenamee[li]= f.getName();

			//System.out.println(filename);
			        try {
			            Parser parser = new Parser(filename);
			                    infoo=parser.getinfo();

			        } catch (FileNotFoundException ex) {
			            Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
			        }
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[]{"",infoo[0], infoo[1], infoo[2], infoo[3], infoo[4], infoo[5], infoo[6], infoo[7], infoo[8], infoo[9], infoo[10], infoo[11]});
			        JOptionPane.showMessageDialog(null, filenamee[li]+" a été ajouté avec succès ");
			}
		});
		mnFichier.add(mntmImporter);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JCheckBoxMenuItem chckbxmntmByInsaCvl = new JCheckBoxMenuItem("By INSA CVL 2017 COPYRIGHT");
		mnAbout.add(chckbxmntmByInsaCvl);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Livres similaires:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 583, 202, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(222, 583, 1032, 67);
		frame.getContentPane().add(textPane);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.setBounds(1175, 0, 89, 23);
		frame.getContentPane().add(btnChercher);
		
		textField = new JTextField();
		textField.setBounds(998, 1, 171, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 34, 1364, 538);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent evt) {
				
				if(evt.isPopupTrigger())  {
                    JTable source = (JTable)evt.getSource();
                 li = source.rowAtPoint( evt.getPoint() );
                System.out.println(li);

jPopupMenu1.show(evt.getComponent(),evt.getX(),evt.getY());

}
				
				
				
				
			}
		});
		
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Collection", "Auteur", "Titre", "Journal", "Ann\u00E9e", "Volume", "Nombre", "Pages", "Mois", "Doi", "URL", "R\u00E9sum\u00E9", "Mots cl\u00E9s", "TAGS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}
}
