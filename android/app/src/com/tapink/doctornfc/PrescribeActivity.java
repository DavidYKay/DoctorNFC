package com.tapink.doctornfc;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.inject.Inject;
import com.tapink.doctornfc.callbacks.AddCallback;
import com.tapink.doctornfc.model.PatientManager;
import com.tapink.doctornfc.patients.Prescription;

@ContentView(R.layout.activity_prescribe)
public class PrescribeActivity extends RoboActivity {

  @InjectView(R.id.spinner)
  private Spinner mSpinner;

  private String mDrugName;
  private ProgressDialog mProgressDialog;

  @Inject
  private PatientManager mPatientManager;

  ////////////////////////////////////////
  // Activity Lifecycle
  ////////////////////////////////////////

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);

    Intent intent = getIntent();
    mDrugName = intent.getStringExtra(Constants.DRUG_NAME);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Constants.LOREM_ARRAY);
    mSpinner.setAdapter(adapter);
  }

  ////////////////////////////////////////
  // Main
  ////////////////////////////////////////

  private void beginUpload() {
    Prescription prescription = new Prescription(
        null,
        null,
        Constants.PATIENT_ID,
        mDrugName,
        "heart medication",
        120,
        1,
        4);

    AddCallback<Prescription> callback = new AddCallback<Prescription>() {

      @Override
      public void failed(Exception exception) {
        // Show failure alert
        showFailureAlert();
      }

      @Override
      public void success() {
        // TODO Dismiss alert
        mProgressDialog.dismiss();

        // Finish
        finishAndExit();
      }
    };
    // show uploading alert
    showUploadingAlert();
    mPatientManager.addPrescription(
        prescription,
        callback
        );
  }

  private void finishAndExit() {
    Intent data = new Intent();
    data.putExtra(Constants.DRUG_NAME, "verapamil");
    setResult(RESULT_OK, data);
    finish();
  }

  ////////////////////////////////////////
  // Alerts
  ////////////////////////////////////////

  private void showConfirmAlert(int messageId) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage(messageId)
        .setPositiveButton(R.string.prescribe, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            beginUpload();
          }
        })
    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        // User cancelled the dialog
      }
    });

    // Create the AlertDialog object and return it
    builder.create().show();
  }

  private void showFailureAlert() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(R.string.failure);
    builder.setMessage(R.string.dialog_upload_failed)
    .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
      }
    });

    // Create the AlertDialog object and return it
    builder.create().show();
  }

  private void showUploadingAlert() {
    mProgressDialog = ProgressDialog.show(this, "Uploading", "Please wait...");
  }

  private void showConfirmAlert() {
    showConfirmAlert(R.string.dialog_confirm_prescribe);
  }

  private void showConfirmVerapamilAlert() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(R.string.warning);
    builder.setMessage(R.string.dialog_confirm_prescribe_verapamil)
        .setPositiveButton(R.string.prescribe, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            finishAndExit();
          }
        })
    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        // User cancelled the dialog
      }
    });

    // Create the AlertDialog object and return it
    builder.create().show();
  }

  public void onDoneButtonClicked(View v) {
    if (mDrugName.toLowerCase().equals("verapamil")) {
      showConfirmVerapamilAlert();
    } else {
      showConfirmAlert();
    }
  }
}
