package controllers;

import entities.Desire;
import entities.Establishment;
import entities.User;
import filters.customAnnotations.JWTTokenNeeded;
import services.interfaces.IEstablishmentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("establishments")
public class EstablishmentController {
    @Inject
    private IEstablishmentService establishmentService;

    @JWTTokenNeeded
    @GET
    public Response getAll() {
        List<Establishment> establishments;
        try {
            establishments = establishmentService.getAllEstablishments();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        return Response
                .ok(establishments)
                .build();
    }


    @JWTTokenNeeded
    @GET
    @Path("select/{id}")
    public Response getEstablishmentById(@PathParam("id") int id) {
        Establishment establishment;
        try {
            establishment = establishmentService.getEstablishmentById(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (establishment == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Establishment does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(establishment)
                .build();
    }
    @JWTTokenNeeded
    @POST
    @Path("/{type}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstablishmentByType(@PathParam("type") String type) {
        List<Establishment> establishment;
        try {
            establishment = establishmentService.getEstablishmentByType(type);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (establishment == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Establishment does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(establishment)
                .build();
    }
    @JWTTokenNeeded
    @GET
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstablishmentByName(@PathParam("name") String name) {
        List<Establishment> establishment;
        try {
            establishment = establishmentService.getEstablishmentByName(name);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (establishment == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Establishment does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(establishment)
                .build();
    }
    @POST
    @Path("/create/establishment")
    public Response createEstablishment(Establishment establishment) {
        boolean created;
        try {
            created = establishmentService.create(establishment);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("User cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("User created successfully!")
                .build();
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEstablishment(@PathParam("id") int id) {
        boolean removed;

        try {
            removed = establishmentService.delete(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (removed) {
            return Response.ok("A establishment was removed successfully!").build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("A establishment with such id was not found!")
                    .build();
        }
    }

    @JWTTokenNeeded
    @GET
    @Path("/sort/rating")
    public Response getEstablishmentByRating() {
        List<Establishment> establishment;
        try {
            establishment = establishmentService.getEstablishmentByRating();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (establishment == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Establishment does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(establishment)
                .build();
    }
        @POST
        @Path("/update")
        public Response updateEstablishment(Establishment establishment) {
            boolean created;
            try {
                created = establishmentService.update(establishment);
            } catch (ServerErrorException ex) {
                return Response.serverError().entity(ex.getMessage()).build();
            }

            if (!created) {
                return Response
                        .status(Response.Status.BAD_REQUEST)
                        .entity("Update cannot be created!")
                        .build();
            }

            return Response
                    .status(Response.Status.CREATED)
                    .entity("Update created successfully!")
                    .build();
        }
    @JWTTokenNeeded
    @POST
    @Path("/update/{id}/{rating}")
    public Response updateRating(@PathParam("id") int id,@PathParam("rating") int rating) {
        boolean created;
        try {
            created = establishmentService.updateRating(id,rating);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Update rating cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Update rating successfully!")
                .build();
    }
    @POST
    @Path("/desire")
    public Response updateDesire(Desire desire) {
        boolean created;
        try {
            created = establishmentService.updateDesire(desire);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Update desire cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Update desire created successfully!")
                .build();
    }
    @POST
    @Path("/create/desire")
    public Response createDesire(Desire desire) {
        boolean created;
        try {
            created = establishmentService.createDesire(desire);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Desire cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Desire created successfully!")
                .build();
    }
    @POST
    @Path("/update/country")
    public Response updateCountry(Establishment establishment) {
        boolean created;
        try {
            created = establishmentService.updateCountry(establishment);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Update country cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Update country created successfully!")
                .build();
    }
    @DELETE
    @Path("/delete/desire/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDesire(@PathParam("id") int id) {
        boolean removed;

        try {
            removed = establishmentService.deleteDesire(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (removed) {
            return Response.ok("A desire was removed successfully!").build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("A desire with such id was not found!")
                    .build();
        }
    }
    @POST
    @Path("/update/founder")
    public Response updateFounder(Establishment establishment) {
        boolean created;
        try {
            created = establishmentService.updateFounder(establishment);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Update founder cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Update founder created successfully!")
                .build();
    }
}
