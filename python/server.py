import os
import sys

sys.path.append(os.path.join(
    os.path.dirname(os.path.abspath(__file__)), '../common/gen-py'))

from thrift.transport import TSocket, TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

import pymongo as mongo

#from users.userservice.UserService import UserService
from patients.MedicationService import Processor
from patients.ttypes import Medication, Prescription, Patient

connection = mongo.Connection()
database = connection.doctornfc

def init_object_from_dict(model_class, data_dict):
  instance = model_class()
  instance.__dict__.update(data_dict)
  return instance

class DataHandler(object):
  def __init__(self, collection, model_class):
    self.collection  = collection
    self.model_class = model_class

  def add_item(self, item):
      self.collection.insert(item.__dict__)
      return True

  def remove_item(self, item):
      self.collection.remove({'_id': item.id})
      return True

  def get_items(self):
    cursor = self.collection.find()
    results = [init_object_from_dict(self.model_class, item) for item in list(cursor)]
    return results

  def get_item_by_id(self, item_id):
    item_dict = self.collection.find_one({'_id': item_id})
    return init_object_from_dict(self.model_class, item_dict)

  def get_item_by_tag_id(self, tag_id):
    item_dict = self.collection.find_one({'tag_id': tag_id})
    return init_object_from_dict(self.model_class, item_dict)

class MegaHandler(object):
  def __init__(self):
    self.handlers = {
        'medications': DataHandler(database.medications, Medication),
        'patients': DataHandler(database.patients, Patient),
        'prescriptions': DataHandler(database.prescriptions, Prescription),
    }

  """ Medications """
  def add_medication(self, medication):
      return self.handlers['medications'].add_item(medication)

  def remove_medication(self, medication):
      return self.handlers['medications'].remove_item(medication)

  def get_medications(self):
      return self.handlers['medications'].get_items()

  def get_medication_by_tag_id(self, tag_id):
      return self.handlers['medications'].get_item_by_tag_id(tag_id)


  """ Prescriptions """
  def add_prescription(self, prescription):
      return self.handlers['prescriptions'].add_item(prescription)

  def remove_prescription(self, prescription):
      return self.handlers['prescriptions'].remove_item(prescription)

  def get_prescriptions(self):
      return self.handlers['prescriptions'].get_items()

  def get_prescription_by_tag_id(self, tag_id):
      return self.handlers['prescriptions'].get_item_by_tag_id(tag_id)

  """ Patients """
  def add_patient(self, patient):
      return self.handlers['patients'].add_item(patient)

  def remove_patient(self, patient):
      return self.handlers['patients'].remove_item(patient)

  def get_patients(self):
      return self.handlers['patients'].get_items()

  def get_patient_by_tag_id(self, tag_id):
      return self.handlers['patients'].get_item_by_tag_id(tag_id)


def create_server(host='0.0.0.0', port=9090):
    handler = MegaHandler()
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
