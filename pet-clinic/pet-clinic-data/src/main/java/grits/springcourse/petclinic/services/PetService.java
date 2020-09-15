package grits.springcourse.petclinic.services;

import grits.springcourse.petclinic.model.Owner;
import grits.springcourse.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
