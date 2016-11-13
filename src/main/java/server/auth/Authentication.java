package server.auth;

/**
 * Created by Alex on 16.10.2016.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
@Path("/auth")
public class Authentication {
    private static final Logger log = LogManager.getLogger(Authentication.class);
}