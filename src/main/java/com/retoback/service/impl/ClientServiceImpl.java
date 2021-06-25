package com.retoback.service.impl;

import com.retoback.model.Client;
import com.retoback.model.ClientDTO;
import com.retoback.model.ClientKPI;
import com.retoback.repository.ClientRepository;
import com.retoback.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

  private static final int LIFE_EXPECTANCY = 73;
  private final ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Client createClient(ClientDTO clientDTO) {
    Client client = new Client();
    BeanUtils.copyProperties(clientDTO, client, "id");

    clientRepository.save(client);
    return client;
  }

  @Override
  public ClientKPI showClientsKpi() {
    ClientKPI clientKPI = new ClientKPI();

    List<Integer> agesList = clientRepository.findAll()
        .stream()
        .map(Client::getAge)
        .collect(Collectors.toList());

    clientKPI.setAgeAverage(calculateClientsAgeAverage(agesList));
    clientKPI.setStandardDeviation(calculateStandardDeviation(agesList));

    return clientKPI;
  }

  @Override
  public List<Client> listClients() {
    for(Client client : clientRepository.findAll()){
      client.setPossibleDateOfDeath(calculatePossibleDateOfDeath(client));
    }

    return clientRepository.findAll();
  }

  private Double calculateClientsAgeAverage(List<Integer> agesList) {
    return agesList.stream().mapToInt(val -> val).average().orElse(0.0);
  }

  private Double calculateStandardDeviation(List<Integer> agesList) {
    double standardDeviation = 0.0;
    double ageAverage = calculateClientsAgeAverage(agesList);

    for (int num : agesList) {
      standardDeviation += Math.pow(num - ageAverage, 2);
    }

    return Math.sqrt(standardDeviation / agesList.size());
  }

  private Date calculatePossibleDateOfDeath(Client client) {
    //I'm gonna consider the expectancy in the world is about 73 years (70-73 wikipedia)
    Calendar dateOfBirth = Calendar.getInstance();
    dateOfBirth.setTime(client.getDateOfBirth());

    Calendar dateOfDeath = dateOfBirth;
    dateOfDeath.add(Calendar.YEAR, LIFE_EXPECTANCY);

    return dateOfDeath.getTime();
  }
}
