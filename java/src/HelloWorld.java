import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import co.gargoyle.hellothrift.users.User;
import co.gargoyle.hellothrift.users.UserService;
import co.gargoyle.hellothrift.users.UserService.AsyncClient;
import co.gargoyle.hellothrift.users.UserService.AsyncClient.add_user_call;
import co.gargoyle.hellothrift.users.UserService.AsyncClient.get_users_call;
import co.gargoyle.hellothrift.users.UserService.Client;


public class HelloWorld {

  private static final String DEV_MACHINE_ADDRESS = "192.168.2.2";
  private static final int DEFAULT_PORT = 9090;
  private static final User EXAMPLE_USER = new User(
      "David",
      "Kay",
      "davidykay@gmail.com"
      );

  private Client mClient;
  private AsyncClient mAsyncClient;

  private boolean mAddComplete = false;
  private boolean mGetComplete = false;

  public static void main(String[] args) throws TException {
    new HelloWorld().doit();
  }

  public void doit() throws TException {
    try {
      initThrift();
    } catch (TTransportException e) {
      e.printStackTrace();
      //throw new RuntimeException("Failed to init thrift!");
      System.exit(-1);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(-1);
    }

    addUserAsync(EXAMPLE_USER);
    //getUsersAsync();

    int counter = 0;
    while (isRunning()) {
      counter++;
    }

    System.out.println("Success!!!");
  }

  private boolean isRunning() {
    //return mAddComplete && mGetComplete;
    //return mGetComplete;
    return !mAddComplete;
  }

  private void initThrift() throws TTransportException, IOException {
    mClient = initClient();
    mAsyncClient = initAsyncClient();
  }

  private Client initClient() throws TTransportException {
    TTransport transport;
    transport = new TSocket(DEV_MACHINE_ADDRESS, DEFAULT_PORT);
    transport.open();

    TProtocol protocol = new TBinaryProtocol(transport);

    return new Client(protocol);
  }

  private AsyncClient initAsyncClient() throws IOException, TTransportException {
    SocketChannel socketChannel = SocketChannel.open();

    TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
    TAsyncClientManager clientManager = new TAsyncClientManager();

    AsyncClient.Factory clientFactory = new AsyncClient.Factory(
        clientManager,
        protocolFactory
        );

    //TNonblockingSocket socket = new TNonblockingSocket(socketChannel);
    TNonblockingSocket socket = new TNonblockingSocket(DEV_MACHINE_ADDRESS, DEFAULT_PORT);
    TNonblockingTransport transport = socket;

    return clientFactory.getAsyncClient(transport);
  }

  private void addUserAsync(User user) throws TException {
    AsyncMethodCallback<add_user_call> callback = new AsyncMethodCallback<UserService.AsyncClient.add_user_call>() {

      @Override
      public void onError(Exception exception) {
        writeExceptionToView(exception);
      }

      @Override
      public void onComplete(add_user_call response) {
        System.out.println("addUser onComplete()");
        boolean result;
        try {
          result = response.getResult();
          System.out.println(String.valueOf(result));

          mAddComplete = true;
        } catch (TException e) {
          e.printStackTrace();
          writeExceptionToView(e);
        }
      }
    };
    mAsyncClient.add_user(user, callback);
  }

  private void getUsersAsync() throws TException {
    AsyncMethodCallback<get_users_call> callback = new AsyncMethodCallback<UserService.AsyncClient.get_users_call>() {

      @Override
      public void onComplete(UserService.AsyncClient.get_users_call response) {
        System.out.println("getUser onComplete()");
        List<User> result;
        try {
          result = response.getResult();
          //System.out.println(String.valueOf(result));
          System.out.println(result.toString());

          mGetComplete = true;
        } catch (TException e) {
          e.printStackTrace();
          writeExceptionToView(e);
        }
      }

      @Override
      public void onError(Exception exception) {
        writeExceptionToView(exception);
      }
    };
    mAsyncClient.get_users(callback);
  }

  private void writeExceptionToView(Exception exception) {
    System.out.println("Error! " + exception.toString());
  }
}
