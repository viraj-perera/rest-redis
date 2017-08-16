package vipe.test.ws;

import vipe.test.domain.Customer;
import vipe.test.service.CustomerService;
import vipe.test.service.CustomerServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerResource {

    private CustomerService customerService;

    public CustomerResource() {
        this.customerService = new CustomerServiceImpl();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") String id){
        System.out.println("Customer id: "+id);
        return Response.status(Response.Status.OK).entity(this.customerService.getCustomer(id)).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer){
        System.out.println("Saving customer started...");
        this.customerService.saveCustomer(customer);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeCustomer(@PathParam("id") String id){
        System.out.println("Deleting customer started...");
        this.customerService.removeCustomer(id);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/")
    public Response editCustomer(Customer customer){
        System.out.println("Editing customer started...");
        this.customerService.editCustomer(customer);
        return Response.status(Response.Status.OK).build();
    }
}
