#!/usr/bin/env python
import os
import sys

sys.path.append(os.path.join(
    os.path.dirname(os.path.abspath(__file__)), '../common/gen-py'))

from thrift import Thrift
from thrift.transport import TSocket, TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

from patients.ttypes import Medication
from patients.MedicationService import Client

#require 'rubygems'
#require 'thrift'
#require 'user_service'
#require 'userservice_types'

#def create_client(host='localhost', port=9090):
#  socket = Thrift::Socket.new(host=host, port=port)
#  transport = Thrift::BufferedTransport.new(socket)
#  protocol = Thrift::BinaryProtocol.new(transport)
#  client = UserService::Client.new(protocol)
#  return transport, client
#end

medication = Medication(
    name  = 'Albuterol',
    type  = 'Antibacterial',
    side_effects      = [
        'Headache',
        'Nausea',
        'Diahhrea',
        'Vomiting',
    ],
    interacting_drug_ids      = [],
)

try:
  # Make socket
  transport = TSocket.TSocket('localhost', 9090)
  # Buffering is critical. Raw sockets are very slow
  transport = TTransport.TBufferedTransport(transport)
  # Wrap in a protocol
  protocol = TBinaryProtocol.TBinaryProtocol(transport)
  # Create a client to use the protocol encoder
  client = Client(protocol)
  # Connect!
  transport.open()

  client.add_medication(medication)

  medications = client.get_medications()
  for medication in medications:
      print "%s, %s, %s, %s" % (medication.name, medication.type,
                            medication.side_effects,
                            medication.interacting_drug_ids)

except Thrift.TException, tx:
  print '%s' % (tx.message)
