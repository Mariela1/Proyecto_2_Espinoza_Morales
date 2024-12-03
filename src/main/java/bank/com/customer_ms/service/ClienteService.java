package bank.com.customer_ms.service;

import bank.com.customer_ms.model.Cliente;
import bank.com.customer_ms.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para obtener un cliente por su DNI
    public Cliente obtenerClientePorDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    // Método para actualizar un cliente
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(cliente.getId()).orElse(null);
        if (clienteExistente != null) {
            clienteExistente.setDni(cliente.getDni());
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setTelefono(cliente.getTelefono());
            return clienteRepository.save(clienteExistente);
        } else {
            return null;
        }
    }
}
