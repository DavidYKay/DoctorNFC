package com.tapink.doctornfc.model;

import com.tapink.doctornfc.callbacks.AddMedicationCallback;
import com.tapink.doctornfc.callbacks.GetMedicationsCallback;
import com.tapink.doctornfc.callbacks.RemoveMedicationCallback;
import com.tapink.doctornfc.exceptions.NotImplementedException;
import com.tapink.doctornfc.patients.Medication;


public class MedicationManager {

  public void getMedications(GetMedicationsCallback callback) {
    callback.failed(new NotImplementedException());
  }

  public void addNewMedication(Medication medication, AddMedicationCallback callback) {

    callback.failed(new NotImplementedException());
  }

  public void removeMedication(Medication medication, RemoveMedicationCallback callback) {

    callback.failed(new NotImplementedException());
  }

}
