package com.retoback.service;

import com.retoback.model.Client;
import com.retoback.model.ClientDTO;
import com.retoback.model.ClientKPI;

import java.util.List;

public interface ClientService {
  Client createClient(ClientDTO clientDTO);

  ClientKPI showClientsKpi();

  List<Client> listClients();
}
