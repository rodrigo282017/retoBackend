package controller;

import lombok.extern.slf4j.Slf4j;
import model.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.impl.ClientService;

import javax.validation.Valid;

@RestController
@Slf4j
public class ClientController {

  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping("/createClient")
  public ResponseEntity<Void> createClient(@Valid @RequestBody ClientDTO clientDTO) {
    log.info("Create client invoked with data: [{}]",
        clientDTO.toString());

    clientService.createClient();
  }


}
