package com.twd.SabahaBackend.repository;

import com.twd.SabahaBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
