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
import com.tapink.doctornfc.patients.PrescriptionService;

public class GetPrescriptionsAsyncTask extends AsyncTask<String, Integer, Optional<List<Prescription>>> {

  private PrescriptionService.Client mClient;
  private GetCallback<Prescription> mCallback;

  //@Override
  //protected Result doInBackground(Params... arg0) {
  //  // TODO Auto-generated method stub
  //  return null;
  //}


  public GetPrescriptionsAsyncTask(GetCallback<Prescription> callback) {
    mCallback = callback;
  }

  protected Optional<List<Prescription>> doInBackground(String... patientIds) {
    //int count = urls.length;
    //long totalSize = 0;
    //for (int i = 0; i < count; i++) {
    //  totalSize += Downloader.downloadFile(urls[i]);
    //  publishProgress((int) ((i / (float) count) * 100));
    //  // Escape early if cancel() is called
    //  if (isCancelled()) break;
    //}
    //return totalSize;

    //return mClient.get_prescriptions_for_patient(Constants.PATIENT_ID);

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
    //setProgressPercent(progress[0]);
  }

  protected void onPostExecute(Optional<List<Prescription>> medications) {
    //showDialog("Downloaded " + result + " bytes");
    //
    if (medications.isPresent()) {
      mCallback.itemsReceived(medications.get());
    } else {
      mCallback.failed(new Exception("Failed to fetch items!"));
    }
  }

  private PrescriptionService.Client initClient() throws TTransportException {
    TTransport transport;
    transport = new TSocket(Constants.DEV_MACHINE_ADDRESS, Constants.DEFAULT_PORT);
    transport.open();

    TProtocol protocol = new TBinaryProtocol(transport);

    return new PrescriptionService.Client(protocol);
  }


}
