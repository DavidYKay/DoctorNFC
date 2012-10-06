import os
import sys

sys.path.append(os.path.join(
    os.path.dirname(os.path.abspath(__file__)), '../common/gen-py'))

from thrift.transport import TSocket, TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

#from users.userservice.UserService import UserService
from users.UserService import Processor


class UserServiceHandler(object):

    def __init__(self):
        self.users = []

    def add_user(self, user):
        self.users.append(user)
        return True

    def get_users(self):
        return self.users


#def create_server(host='localhost', port=9090):
def create_server(host='0.0.0.0', port=9090):
    handler = UserServiceHandler()
    return TServer.TSimpleServer(
        #UserService.Processor(handler),
        Processor(handler),
        TSocket.TServerSocket(host=host, port=port),
        TTransport.TBufferedTransportFactory(),
        TBinaryProtocol.TBinaryProtocolFactory()
    )

if __name__ == '__main__':
    server = create_server()
    server.serve()
