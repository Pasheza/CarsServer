package server.data;

/**
 * Created by pashe on 14-Nov-16.
 */


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import model.TestTemplate;
import server.data.TestsContainer;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
@Path("/data")
public class DataProvider {
    @NotNull
    private static final Logger log = LogManager.getLogger(DataProvider.class);


    @GET
    @Path("/")
    public Response getTests(@QueryParam("number") int num){
        if (num <= 0)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        log.info(TestTemplate.writeJSON(TestsContainer.getTests(num)));
        return Response.ok((TestTemplate.writeJSON(TestsContainer.getTests(num)))).build();
    }
}
