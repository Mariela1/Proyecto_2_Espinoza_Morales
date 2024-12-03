package bank.com.customer_ms.controller;

import bank.com.customer_ms.model.Cliente;
import bank.com.customer_ms.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para obtener un cliente por su DNI
    @GetMapping("/dni/{dni}")
    public Cliente obtenerClientePorDni(@PathVariable String dni) {
        return clienteService.obtenerClientePorDni(dni);
    }

    // Endpoint para actualizar la información de un cliente
    @PutMapping("/actualizar")
    public Cliente actualizarCliente(@RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(cliente);
    }
}
