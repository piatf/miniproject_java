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
				String dest = "//PDF";
				try {
					FileUtils.copyFileToDirectory(source, dest);
				} catch (NullPointerException e) {
					if (dest == null) {
						File theDir = new File("PDF");
						theDir.createDirectory(currentDir);
						FileUtils.copyFileToDirectory(source, dest);
					}
				} catch (IOException e) {
					e.printStackTrace();
					return -1;
				}
				String name = getName(chooser);
				//return chooser.getSelectedFile().getPath();
				return (dest + "/" + name);
			}	
		}
		
		public ReadPDF(String PathPDF) {
			try { 
				File myFile = new File(PathPDF);
				if (Desktop.isDesktopSupported()) { // open PDF File
					try {
						Desktop.getDesktop().open(myFile);
					} catch (IOException e) {
						// no application registered for PDFs
					}
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