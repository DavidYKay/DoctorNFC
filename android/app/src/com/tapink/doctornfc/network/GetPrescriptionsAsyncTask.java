package com.tapink.doctornfc.network;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import android.os.AsyncTask;

import com.google.common.base.Optional;
import com.tapink.doctornfc.Constants;
import com.tapink.doctornfc.callbacks.GetCallback;
import com.tapink.doctornfc.patients.Prescription;
import com.tapink.doctornfc.patients.MedicationService;

public class GetPrescriptionsAsyncTask extends AsyncTask<String, Integer, Optional<List<Prescription>>> {

  private MedicationService.Client mClient;
  private GetCallback<Prescription> mCallback;

  public GetPrescriptionsAsyncTask(GetCallback<Prescription> callback) {
    mCallback = callback;
  }

  protected Optional<List<Prescription>> doInBackground(String... patientIds) {
    try {
      mClient = initClient();
    } catch (TTransportException e) {
      e.printStackTrace();
      mCallback.failed(e);
    }

    List<Prescription> prescriptions = new ArrayList<Prescription>();
    try {
      prescriptions = mClient.get_prescriptions_for_patient(patientIds[0]);
    } catch (TException e) {
      e.printStackTrace();
      return Optional.absent();
    }
    return Optional.of(prescriptions);
  }

  protected void onProgressUpdate(Integer... progress) {

  }

  protected void onPostExecute(Optional<List<Prescription>> medications) {
    if (medications.isPresent()) {
      mCallback.itemsReceived(medications.get());
    } else {
      mCallback.failed(new Exception("Failed to fetch items!"));
    }
  }

  private MedicationService.Client initClient() throws TTransportException {
    TTransport transport;
    transport = new TSocket(Constants.DEV_MACHINE_ADDRESS, Constants.DEFAULT_PORT);
    transport.open();

    TProtocol protocol = new TBinaryProtocol(transport);

    return new MedicationService.Client(protocol);
  }

}
