package com.example.loisirs.javatoandroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Path;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;

/**
 * Class to Save/Load PDF from explorer into a variable and Read PDF from Path
 *
 *
 * @author Gaëtan COULHON
 */
public class MainActivityPDF extends AppCompatActivity {

    static final int PICK_FILE_REQUEST = 1;  // The request code
    public String filePath;
    public String fileName;

    private void searchPDF(View view){ // pour tester après appui sur bouton, lance la fonction
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        //Intent i = Intent.createChooser(intent, "File");
        startActivityForResult(intent, PICK_FILE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_FILE_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }

    private void openPDF(String fp){
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/"+ fp);
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file),"application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, "Open File");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Instruct the user to install a PDF reader here, or something
        }
    }

}