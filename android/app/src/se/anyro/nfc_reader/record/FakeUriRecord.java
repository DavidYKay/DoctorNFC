package se.anyro.nfc_reader.record;

import android.net.Uri;

public class FakeUriRecord extends UriRecord {

  public FakeUriRecord() {
    super(Uri.parse("http://www.example.org"));
  }
}
