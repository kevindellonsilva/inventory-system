package com.nibm.project4.service;

import com.nibm.project4.model.Supplier;
import com.nibm.project4.repository.Supplierrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private Supplierrepo supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()) {
            Supplier supplier = supplierOptional.get();
            supplier.setName(updatedSupplier.getName());
            supplier.setContact(updatedSupplier.getContact());
            supplier.setAddress(updatedSupplier.getAddress());
            return supplierRepository.save(supplier);
        } else {
            throw new RuntimeException("Supplier not found with ID: " + id);
        }
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }










}
