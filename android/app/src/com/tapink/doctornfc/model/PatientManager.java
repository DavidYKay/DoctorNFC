package com.tapink.doctornfc.model;

import com.tapink.doctornfc.Constants;
import com.tapink.doctornfc.callbacks.AddCallback;
import com.tapink.doctornfc.callbacks.GetCallback;
import com.tapink.doctornfc.callbacks.RemoveCallback;
import com.tapink.doctornfc.network.AddPrescriptionAsyncTask;
import com.tapink.doctornfc.network.GetPrescriptionsAsyncTask;
import com.tapink.doctornfc.patients.Medication;
import com.tapink.doctornfc.patients.Prescription;

public class PatientManager {


  public void addPrescription(Prescription prescription, AddCallback<Prescription> callback) {
    new AddPrescriptionAsyncTask(callback).execute(prescription);
  }

  public void removePrescription(Prescription prescription, RemoveCallback<Prescription> callback) {

  }

  public void listPrescriptions(GetCallback<Prescription> callback) {
    new GetPrescriptionsAsyncTask(callback).execute(Constants.PATIENT_ID);
  }

  public void listMedications(GetCallback<Medication> callback) {

  }

}
