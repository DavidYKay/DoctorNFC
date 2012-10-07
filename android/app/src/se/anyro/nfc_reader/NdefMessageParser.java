package se.anyro.nfc_reader;

/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


import java.util.ArrayList;
import java.util.List;

import se.anyro.nfc_reader.record.FakeUriRecord;
import se.anyro.nfc_reader.record.UriRecord;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

/**
 * Utility class for creating {@link ParsedNdefMessage}s.
 */
public class NdefMessageParser {

  // Utility class
  private NdefMessageParser() {

  }

  /** Parse an NdefMessage */
  public static List<UriRecord> parse(NdefMessage message) {
    return getRecords(message.getRecords());
  }

  public static List<UriRecord> getRecords(NdefRecord[] records) {
    List<UriRecord> elements = new ArrayList<UriRecord>();
    for (final NdefRecord record : records) {
      if (UriRecord.isUri(record)) {
        elements.add(UriRecord.parse(record));
//      } else if (TextRecord.isText(record)) {
//        elements.add(TextRecord.parse(record));
//      } else if (SmartPoster.isPoster(record)) {
//        elements.add(SmartPoster.parse(record));
      } else {
        elements.add(new FakeUriRecord());
      }
    }
    return elements;
  }
}
