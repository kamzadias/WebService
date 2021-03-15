package repositories.interfaces;

import entities.Desire;
import entities.Establishment;
import entities.User;
import repositories.interfaces.base.IRepository;

import java.util.List;


public interface IEstablishmentRepository extends IRepository<Establishment> {

    List<Establishment> getEstablishmentByType(String type);
    List<Establishment> getEstablishmentByName(String name);
    boolean createEstablishment(Establishment establishment);
    List<Establishment> getEstablishmentByRating();
    boolean updateEstablishment(Establishment establishment);
    boolean updateRating(int id,int rating);
    boolean updateDesire(Desire desire);
    boolean createDesire(Desire desire);
    boolean updateCountry(Establishment establishment);
    boolean deleteDesire(int id);
    boolean updateFounder(Establishment establishment);
}