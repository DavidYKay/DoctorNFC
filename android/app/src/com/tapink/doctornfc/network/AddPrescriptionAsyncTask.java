package com.tapink.doctornfc.network;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import android.os.AsyncTask;

import com.tapink.doctornfc.Constants;
import com.tapink.doctornfc.callbacks.AddCallback;
import com.tapink.doctornfc.patients.MedicationService;
import com.tapink.doctornfc.patients.Prescription;

public class AddPrescriptionAsyncTask extends AsyncTask<Prescription, Integer, Boolean> {

  private MedicationService.Client mClient;
  private AddCallback<Prescription> mCallback;

  public AddPrescriptionAsyncTask(AddCallback<Prescription> callback) {
    mCallback = callback;
  }

  protected Boolean doInBackground(Prescription... prescriptions) {
    try {
      mClient = initClient();
    } catch (TTransportException e) {
      e.printStackTrace();
      mCallback.failed(e);
    }

    Boolean success = false;
    try {
      success = mClient.add_prescription(prescriptions[0]);
    } catch (TException e) {
      e.printStackTrace();
      return success;
    }
    return success;
  }

  protected void onProgressUpdate(Integer... progress) {

  }

  protected void onPostExecute(Boolean success) {
   if (success) {
      mCallback.success();
    } else {
      mCallback.failed(new Exception("Failed to add prescription!"));
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
