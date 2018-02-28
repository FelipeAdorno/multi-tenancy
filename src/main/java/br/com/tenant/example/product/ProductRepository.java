package br.com.tenant.example.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Felipe Adorno felipeadsc@gmail.com
 */
@Repository
interface ProductRepository extends JpaRepository<Product, Integer> {
}
