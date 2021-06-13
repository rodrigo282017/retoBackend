package service.impl;

import model.ClientDTO;

import java.util.ArrayList;

public interface ClientService {
  void createClient();

  ClientDTO clientKpi();

  ArrayList<ClientDTO> listClients();
}
