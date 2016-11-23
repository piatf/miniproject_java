package bibliotheque;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


/* This table model is created in order to use the Sort and Filter function;
 * With this sort and filter function, we can implement the tag search function easily
 */
public class MyTableModel extends AbstractTableModel {
    private  Locale currentLocale = Locale.getDefault();
    private boolean DEBUG = false;
    private int id;
    private ResourceBundle labels = ResourceBundle.getBundle("resources.Resources", currentLocale); ;
    
    private Vector<Object[]> data = new Vector<Object[]>();
    
    MyTableModel(Locale currentLocale) {
    	this.currentLocale = currentLocale;
    	labels  =ResourceBundle.getBundle("resources.Resources", currentLocale);
    	String[] columnNames1 = {labels.getString("Collection"), labels.getString("Author"), 
        		labels.getString("Title"), labels.getString("Journal"),
        		labels.getString("Year"), labels.getString("Volume"),
        		labels.getString("Number"), labels.getString("Month"), 
        		labels.getString("Resume"), labels.getString("Keywords"), 
        		labels.getString("Tags"), "PDF" };
    	columnNames = columnNames1;
    	
    }
    private String[] columnNames = {labels.getString("Collection"), labels.getString("Author"), 
    		labels.getString("Title"), labels.getString("Journal"),
    		labels.getString("Year"), labels.getString("Volume"),
    		labels.getString("Number"), labels.getString("Month"), 
    		labels.getString("Resume"), labels.getString("Keywords"), 
    		labels.getString("Tags"), "PDF" };
   
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class,
        java.lang.String.class, java.lang.String.class, java.lang.String.class, 
        java.lang.String.class, java.lang.String.class, java.lang.String.class,
        java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
    };

   
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
    	
    	    return types[c];
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
    	return true;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
    	// Set a temp value
    	Object[] temp = data.get(row);
    	temp[col] = value;
    	// Delete the previous value of Object in the hasmap
    	data.set(row, temp);
    	fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data.get(i)[j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

	public void insertRow(int id, Object[] objects) {
		// TODO Auto-generated method stub
		data.add(id, objects);
		// Set the row with the id:
		
	}
	public void removeRow(int id) {
		// TODO Auto-generated method stub
		data.remove(id);
		System.out.println(id);
		fireTableRowsDeleted(id,id);
	}
}
