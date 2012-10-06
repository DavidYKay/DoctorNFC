#!/usr/bin/env ruby

$:.push('./gen-rb')

require 'rubygems'
require 'thrift'
require 'user_service'
require 'userservice_types'

def create_client(host='localhost', port=9090)
  socket = Thrift::Socket.new(host=host, port=port)
  transport = Thrift::BufferedTransport.new(socket)
  protocol = Thrift::BinaryProtocol.new(transport)
  client = UserService::Client.new(protocol)
  return transport, client
end

user = User.new()
user.first_name = 'Paul'
user.last_name = 'Osman'
user.email = email

transport, client = create_client()
transport.open()
client.add_user(user)

users = client.get_users()
users.each do |user|
    puts "#{user.first_name}, #{user.last_name}, #{user.email}"
end
