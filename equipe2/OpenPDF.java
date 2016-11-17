package bibliotheque;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class to Save/Load PDF from explorer into a variable and Read PDF from Path
 * 
 * @author Gaetan COULHON
*/
public class OpenPDF {
	/**
	 * Open explorer to search a PDF file,
	 * Copy it into the directory PDF inside the project.
	 * 
	 * @return the String corresponding to the full name of the PDF.
	 * 
	 * @throws IOException 
	 * 			Throws an error if there is an input/output error.
	 */
	public String SearchPDF() throws IOException {
		
		JFileChooser chooser = new JFileChooser(); // Create a JFileChooser
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Only", "pdf"); // Create Filter to search PDF only
		
		chooser.setFileFilter(filter); // set Filter
		
		chooser.showOpenDialog(null);

		//File source = new File(chooser.getSelectedFile().getPath()); // get full path of the selected PDF
		Path source = Paths.get(chooser.getSelectedFile().getPath()); // get full path of the selected PDF
		
		Path dest = Paths.get("PDF\\"); // create a Path for the destination where to copy the PDF
		
		File f = new File(""); // create an empty file in order to catch the Path of the existing project
		File file = new File(f.getPath()+"PDF"); // create a new directory called PDF in the current project
		if (!file.exists()) {
		    if (file.mkdir()) {
		        System.out.println("Directory is created!");
		    } else {
		        System.out.println("Failed to create directory!");
		    }
		}
		
		Files.copy(source, dest, REPLACE_EXISTING); // copy the PDF from the source to the destination (PDF directory in the project)
		
		String name = chooser.getName(); // Save the name of the selected PDF
		
		//return chooser.getSelectedFile().getPath();
		return name; //return the full name of the PDF
	}

	/**
	 * Read a PDF from its Path
	 * 
	 * @param PathPDF
	 * 					The Full Path to the PDF
	 */
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