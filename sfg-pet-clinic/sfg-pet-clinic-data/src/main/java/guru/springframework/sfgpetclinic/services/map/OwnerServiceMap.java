package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner owner) {

        if (owner != null) {
            if (owner.getPets() != null) {

                owner.getPets().forEach( pet -> {
                    if (pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }

            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
}
