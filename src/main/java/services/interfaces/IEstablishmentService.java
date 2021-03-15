package services.interfaces;

import entities.Desire;
import entities.Establishment;


import java.util.List;

public interface IEstablishmentService {
    List<Establishment> getAllEstablishments();
    Establishment getEstablishmentById(int id);
    List<Establishment> getEstablishmentByType(String type);
    List<Establishment> getEstablishmentByName(String name);
    boolean create(Establishment establishment);
    boolean delete(int id);
    List<Establishment> getEstablishmentByRating();
    boolean update(Establishment establishment);
    boolean updateRating(int id,int rating);
    boolean updateDesire(Desire desire);
    boolean createDesire(Desire desire);
    boolean updateCountry(Establishment establishment);
    boolean deleteDesire(int id);
    boolean updateFounder(Establishment establishment);
}