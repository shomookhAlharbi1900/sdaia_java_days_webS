package org.example.dao;

import org.example.models.jobs;

import java.sql.*;
import java.util.ArrayList;

public class jobsDAO {
    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\HrApiDay5\\hr.db";
    private static final String SELECT_ALL_jobs = "select * from jobs";
    private static final String SELECT_ONE_id_job = "select * from jobs where job_id = ?";
    private static final String INSERT_jobs = " insert into jobs values (?,?,?,?)" ;
    private static final String UPDATE_jobs = "update jobs set job_title = ? min_salary = ? , max_salary = ?,where job_id  = ?";
    private static final String DELETE_jobs = "delete from jobs where job_id = ?";

    public void INSERT_jobs(jobs j) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_jobs);
        st.setInt(1,j.getJob_id());
        st.setString(2,j.getJob_title());
        st.setDouble(3,j.getMin_salary());
        st.setDouble(4,j.getMax_salary());
        st.executeUpdate();
        conn.close();
    }

    public void UPDATE_jobs(jobs j) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_jobs);
        st.setInt(4,j.getJob_id());
        st.setString(1,j.getJob_title());
        st.setDouble(2,j.getMin_salary());
        st.setDouble(3,j.getMax_salary());
        st.executeUpdate();
        conn.close();
    }
    public void DELETE_jobs(int job_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_jobs);
        st.setInt(1, job_id);
        st.executeUpdate();
        conn.close();
    }
    public jobs SELECT_ONE_id_job(int job_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_id_job);
        st.setInt(1, job_id);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new jobs(rs);
        }
        else {
            return null;
        }
    }
    public ArrayList<jobs> SELECT_ALL_jobs() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_jobs);
        ResultSet rs = st.executeQuery();
        ArrayList<jobs> job = new ArrayList<>();
        while (rs.next()) {
            job.add(new jobs(rs));
        }

        return job;
    }














}
