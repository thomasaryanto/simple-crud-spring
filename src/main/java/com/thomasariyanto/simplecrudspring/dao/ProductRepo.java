package com.thomasariyanto.simplecrudspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thomasariyanto.simplecrudspring.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
