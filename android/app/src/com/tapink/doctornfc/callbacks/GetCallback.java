package com.tapink.doctornfc.callbacks;

import java.util.List;

public interface GetCallback<T> extends NetworkCallback {

  public void itemsReceived(List<T> items);

  public void itemReceived(T item);

}
