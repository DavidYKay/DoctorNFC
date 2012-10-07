package com.tapink.doctornfc;

import com.tapink.doctornfc.callbacks.AddCallback;
import com.tapink.doctornfc.callbacks.GetCallback;
import com.tapink.doctornfc.callbacks.RemoveCallback;
import com.tapink.doctornfc.network.GetPrescriptionsAsyncTask;
import com.tapink.doctornfc.patients.Medication;
import com.tapink.doctornfc.patients.Prescription;

public class PatientManager {


  public void addPrescription(Prescription prescription, AddCallback<Prescription> callback) {

  }

  public void removePrescription(Prescription prescription, RemoveCallback<Prescription> callback) {

  }

  public void listPrescriptions(GetCallback<Prescription> callback) {
    new GetPrescriptionsAsyncTask(callback).execute();
  }

  public void listMedications(GetCallback<Medication> callback) {

  }

}
