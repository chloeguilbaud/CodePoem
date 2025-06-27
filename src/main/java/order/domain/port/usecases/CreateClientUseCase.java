package order.domain.port.usecases;

import order.domain.exceptions.HiShoeNotFoundException;
import order.domain.model.Client;
import order.domain.port.repositories.ClientRepository;
import order.domain.service.CreateClientService;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase {

    private CreateClientService createClientService;
    private ClientRepository clientRepository;

    public void handle(CreateClientCommand command) {

        // créer le client
        Client client = createClientService.createClient(command.getFirstName(), command.getLastName(), command.getEmail(), command.getAddress());

        // enregistrer le client en base de données
        clientRepository.save(client);

    }
}
