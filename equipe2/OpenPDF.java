
/*
	Class to Load/Save PDF from explorer into a variable and Read PDF from Path
	By Gaëtan
	*/
	

	import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

	
public class OpenPDF {
	
		public String SearchPDF() throws IOException {
			String s[]=new String [2];
			JFileChooser chooser = new JFileChooser(); // Create a JFileChooser
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Only", "pdf");
			
			chooser.setFileFilter(filter);
			
			chooser.showOpenDialog(null);

			 // if the file can be opened
				// To copy a file from source to dest
				File source = new File(chooser.getSelectedFile().getPath());
				
				
				
				String dest = "PDF\\";
				String destt = "PDF";
				
				Path path = Paths.get(chooser.getSelectedFile().getPath());
				Path path2 = Paths.get(dest);
				Path pathh = Paths.get(destt);

				
				try {
					Files.copy(path, path2,REPLACE_EXISTING);
				
						
					
					
					
				} catch (IOException e) {
					//theDir.mkdirs();
					Files.createDirectory(pathh);

					Files.copy(path, path2,REPLACE_EXISTING);
					e.printStackTrace();
					
				}
				String name = chooser.getName();
				
				//return chooser.getSelectedFile().getPath();
				return name;
			}	
		
		
		public void ReadPDF (String PathPDF) {
			try { 
				File myFile = new File(PathPDF);
				if (Desktop.isDesktopSupported()) { // open PDF File
					
						Desktop.getDesktop().open(myFile);
					
				}
			}
			catch (IOException e){
				//Can't open File
			}
		}
	}
	
	//https://docs.oracle.com/javase/8/docs/api/javax/swing/JFileChooser.html
	//http://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
	
	/*
	http://stackoverflow.com/questions/1146153/copying-files-from-one-directory-to-another-in-java
	http://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html
	https://commons.apache.org/proper/commons-io/javadocs/api-release/org/apache/commons/io/FileUtils.html
	*/
