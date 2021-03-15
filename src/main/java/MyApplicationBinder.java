import data.PostgresDB;
import data.interfaces.IDB;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import repositories.EstablishmentRepository;
import repositories.UserRepository;
import repositories.interfaces.IEstablishmentRepository;
import repositories.interfaces.IUserRepository;
import services.AuthService;
import services.EstablishmentService;
import services.UserService;
import services.interfaces.IAuthService;
import services.interfaces.IEstablishmentService;
import services.interfaces.IUserService;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(PostgresDB.class).to(IDB.class);
        bind(UserRepository.class).to(IUserRepository.class);
        bind(EstablishmentRepository.class).to(IEstablishmentRepository.class);
        bind(EstablishmentService.class).to(IEstablishmentService.class);
        bind(UserService.class).to(IUserService.class);
        bind(AuthService.class).to(IAuthService.class);
    }
}