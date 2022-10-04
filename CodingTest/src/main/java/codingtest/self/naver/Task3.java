package codingtest.self.naver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
class Person {

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private Long id;

    private String firstName;

    @OneToMany(mappedBy = "person")
    List<Pet> pets = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public Set<Pet> getPets() {
        Set<Pet> set = new HashSet<Pet>();

        for(Pet pet : pets) {
            set.add(pet);
        }//end for()

        return set;
    }

}

@Entity
@Getter @Setter
class Pet {

    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    private String name;

    public String getOwnerName() {
        //FIXME
        return null;
    }

    public String getName() {
        return name;
    }

	public void setName(String petName) {
		// TODO Auto-generated method stub
		
	}
}

class PersonNotFoundException extends RuntimeException {

}

@Service
class PersonService {

    private final EntityManager entityManager;

    PersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addPet(Long personId, String petName) {
        Person person = entityManager.find(Person.class, personId);

        if(person == null) {
            throw new PersonNotFoundException();
        } else {
            Pet pet = new Pet();
            pet.setName(petName);

            //person.addPets(pet);
            entityManager.persist(person);
        }//end if()
        //FIXME
    }
}
