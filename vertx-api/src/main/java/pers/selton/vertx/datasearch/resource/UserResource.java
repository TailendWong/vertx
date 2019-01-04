package pers.selton.vertx.datasearch.resource;


import com.google.inject.Singleton;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import pers.selton.vertx.inject.CommonUtils;
import pers.selton.vertx.model.data.User;
import pers.selton.vertx.service.IUserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/user")
@Singleton
@Data
@Slf4j
public class UserResource {

    private IUserService userService;

    public UserResource() {
        this.userService = CommonUtils.getInstance(IUserService.class);
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") long id){
        userService.getUser(id);
        return Response.status(OK).build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user){
        userService.addUser(user);
        return Response.status(OK).build();
    }
}
