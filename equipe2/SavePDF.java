	/*
	Class to Load/Save PDF from explorer into a variable and Read PDF from Path
	By Gaëtan
	*/
	
	import org.apache.commons.io;
	
	public class OpenPDF {
		public SearchPDF() {
			JFileChooser chooser = new JFileChooser(); // Create a JFileChooser
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Only", "pdf");
			
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showOpenDialog(parent); // in response to a button click
			
			if(returnVal == JFileChooser.APPROVE_OPTION) { // if the file can be opened
				// To copy a file from source to dest
				File source = new File(chooser.getSelectedFile().getPath(););
				File dest = new File("C:\\");
				try {
					FileUtils.copyFile(source, dest); // better using copyFileToDirectory
					// copy filename + key for unique name in unique directory.
				} catch (NullPointerException e) {
					if (dest == null) {
						// create the directory? createDirectory from Files class
					}
					// then do it again
				} catch (IOException e) {
					e.printStackTrace();
				}
				return chooser.getSelectedFile().getPath(); // return the File Path
			}	
		}
		
		public ReadPDF(String PathPDF) {
			JFileChooser chooser = new JFileChooser(PathPDF); // Create a JFileChooser
			
			int returnVal = chooser.showOpenDialog(parent); // in response to a button click
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			}
			if (Desktop.isDesktopSupported()) { // open PDF File
				try {
					File myFile = new File(PathPDF);
					Desktop.getDesktop().open(myFile);
				} catch (IOException ex) {
					// no application registered for PDFs
				}
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