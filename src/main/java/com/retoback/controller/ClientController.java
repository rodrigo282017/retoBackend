package com.retoback.controller;

import com.retoback.model.Client;
import com.retoback.model.ClientKPI;
import com.retoback.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import com.retoback.model.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping("/createClient")
  public ResponseEntity<Client> createClient(@Valid @RequestBody ClientDTO clientDTO) {
    log.info("Create client invoked with data: [{}]",
        clientDTO.toString());

    Client client = clientService.createClient(clientDTO);

    return ResponseEntity.ok(client);
  }

  @GetMapping("/listClients")
  public ResponseEntity<List<Client>> listClients(){
    log.info("Listing clients...");

    return ResponseEntity.ok(clientService.listClients());
  }

  @GetMapping("/clientsKPI")
  public ResponseEntity<ClientKPI> showClientsKPI(){
    log.info("Listing clients KPI...");

    return ResponseEntity.ok(clientService.showClientsKpi());
  }


}
