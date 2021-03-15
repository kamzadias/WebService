package services;

import entities.Desire;
import entities.Establishment;
import entities.User;
import repositories.interfaces.IEstablishmentRepository;
import services.interfaces.IEstablishmentService;

import javax.inject.Inject;
import java.util.List;

public class EstablishmentService implements IEstablishmentService {
    @Inject
    private IEstablishmentRepository establishmentRepository;

    @Override
    public Establishment getEstablishmentById(int id) {
        return establishmentRepository.get(id);
    }
    @Override
    public List<Establishment> getEstablishmentByType(String type) {
        return establishmentRepository.getEstablishmentByType(type);
    }
    @Override
    public List<Establishment> getEstablishmentByName(String name) {
        return establishmentRepository.getEstablishmentByName(name);
    }
    @Override
    public boolean create(Establishment establishment) {
        return establishmentRepository.createEstablishment(establishment);
    }
    @Override
    public boolean delete(int id) {
        return establishmentRepository.delete(id);
    }
    @Override
    public List<Establishment> getAllEstablishments() {
        List<Establishment> establishments = establishmentRepository.getAll();
        return establishments;
    }
    @Override
    public  List<Establishment> getEstablishmentByRating(){
        List<Establishment> establishments = establishmentRepository.getEstablishmentByRating();
        return establishments;
    }
    @Override
    public boolean update(Establishment establishment) {
        return establishmentRepository.updateEstablishment(establishment);
    }
    @Override
    public boolean updateRating(int id,int rating) {
        return establishmentRepository.updateRating(id, rating);
    }
    @Override
    public boolean updateDesire(Desire desire) {
        return establishmentRepository.updateDesire(desire);
    }
    @Override
    public boolean createDesire(Desire desire) {
        return establishmentRepository.createDesire(desire);
    }
    @Override
    public boolean updateCountry(Establishment establishment) {
        return establishmentRepository.updateCountry(establishment);
    }
    @Override
    public boolean deleteDesire(int id) {

        return establishmentRepository.deleteDesire(id);
    }
    @Override
    public boolean updateFounder(Establishment establishment) {
        return establishmentRepository.updateFounder(establishment);
    }
}
