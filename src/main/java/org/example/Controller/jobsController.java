package org.example.Controller;

import jakarta.ws.rs.*;
import org.example.dao.jobsDAO;
import org.example.models.jobs;

import java.sql.*;
import java.util.ArrayList;

@Path("/jobs")
public class jobsController {
     jobsDAO jo = new jobsDAO();

     @GET
     public ArrayList<jobs> SELECT_ALL_jobs() {
          try {
               return jo.SELECT_ALL_jobs();
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
     }
     @GET
     @Path("{Job_id}")
     public jobs SELECT_ONE_id_job(@PathParam("Job_id") int Job_id) {
          try {
               return jo.SELECT_ONE_id_job(Job_id);
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
     }
     @DELETE
     @Path("{Job_id}")
     public void DELETE_jobs(@PathParam("Job_id") int Job_id) {

          try {
               jo.DELETE_jobs(Job_id);
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
     }
     @POST
     public void INSERT_jobs(jobs job) {
          try {
               jo.INSERT_jobs(job);
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
     }
     @PUT
     @Path("{Job_id}")
     public void UPDATE_jobs(@PathParam("Job_id") int Job_id, jobs job) {

          try {
               job.setJob_id(Job_id);
               jo.UPDATE_jobs(job);
          } catch (Exception e) {
               throw new RuntimeException(e);
          }
     }


}

