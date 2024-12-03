package bank.com.customer_ms.repository;

import bank.com.customer_ms.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Método para buscar un cliente por DNI
    Cliente findByDni(String dni);
}
