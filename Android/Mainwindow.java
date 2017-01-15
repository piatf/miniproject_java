package com.example.hamza.bibliotheque;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mainwindow extends AppCompatActivity {
    private Button add;
    TextView scr1,scr2;
    TableLayout T; // table
    TableRow Tr; //row
    private String fpath;// path of file
    private TextView txtvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_mainwindow);
        add=(Button) findViewById(R.id.b_add);







    }
    public String getSafeSubstring(String s, int maxLength){
        if(!TextUtils.isEmpty(s)){
            if(s.length() >= maxLength){
                return s.substring(0, maxLength);
            }
        }
        return s;
    }


    /**
     * Button Listener
     *
     * Call the default file chooser of the System
     *
     * @param v
     */
    public void OnClick(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");//bibtex only
        startActivityForResult(Intent.createChooser(intent, "ADD FILE"),1001);

        // I gave the code
        // the value 1001 to the activity
        //finish();



    }
   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {


            super.onKeyDown(keyCode, event);
            return true;
        }
        return false;
    }*/

    /**
     * This class is used to get the content of the file chosen
     * @param requestCode is the code of the activity just launched in our class we need just the
     *                    code of the activity launched by the filechooser
     * @param resultCode No need to explain this parameter
     * @param data Data here represents the content variable
     *
     *
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        // super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1001&& resultCode == RESULT_OK) {
            Uri currFileURI = data.getData();
             fpath=currFileURI.getPath();// path value


           //     txtvi.setText(fpath);

          /*  TableLayout tl=(TableLayout)findViewById(R.id.table1);
            //TableRow tbrow = new TableRow(this);
            TableRow tbrow= (TableRow)findViewById(R.id.row);
            ((TextView)tbrow.findViewById(R.id.title)).setText("hiiiiiifg");
            ((TextView)tbrow.findViewById(R.id.author)).setText("okhjksdbfk");
            tl.addView(tbrow);
            tl.requestLayout();
*/






            /*TextView t1v = new TextView(this);
            t1v.setText(getSafeSubstring("okoo000000000000000000000000000000000000000000",6) );
            tbrow.addView(t1v);
            TextView space = new TextView(this);
            space.setText("|");
            space.setTextColor(Color.BLACK);
            tbrow.addView(space);
            TextView t2v = new TextView(this);
            t2v.setText("Product");
            tbrow.addView(t2v);
            //tl.addView(tbrow, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
*/

            TableLayout table = (TableLayout)findViewById(R.id.attrib_table1);
            String[] infoo = new String [12];
            try {
                Parser parser = new Parser(fpath);
                infoo=parser.getinfo();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
            }

                // Inflate your row "template" and fill out the fields.
                TableRow row = (TableRow)LayoutInflater.from(this).inflate(R.layout.attrib_row, null);
                ((TextView)row.findViewById(R.id.attrib_name)).setText(infoo[1]);
                ((TextView)row.findViewById(R.id.attrib_value)).setText(infoo[0]);
            ((TextView)row.findViewById(R.id.attrib_name1)).setText(infoo[11]);
            ((TextView)row.findViewById(R.id.attrib_name2)).setText(infoo[6]);
            ((TextView)row.findViewById(R.id.attrib_name3)).setText(infoo[3]);

            table.addView(row);

            table.requestLayout();






        }
        if(resultCode == RESULT_CANCELED)
            onResume();
    }
}
