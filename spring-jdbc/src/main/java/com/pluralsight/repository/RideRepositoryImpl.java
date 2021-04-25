package com.pluralsight.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Ride;
import com.pluralsight.repository.util.RideRowMapper;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Ride createRide(Ride ride) {

        /*
         * jdbcTemplate.update("insert into ride (name, duration) values (?,?)",
         * ride.getName(), ride.getDuration()); //NOSONAR
         */

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement preparedStatement = connection //NOSONAR
                        .prepareStatement("insert into ride (name, duration) values (?,?)", new String[] { "id" });
                preparedStatement.setString(1, ride.getName());
                preparedStatement.setInt(2, ride.getDuration());

                return preparedStatement;
            }
        }, keyHolder);
        
        Number id = keyHolder.getKey();

        return getRide(id.intValue());
    }
    
    public Ride getRide(Integer id) {
        
        return jdbcTemplate.queryForObject("select * from ride where id = ?", new RideRowMapper(), id);
    }

    @Override
    public List<Ride> getRides() {

        return jdbcTemplate.query("select * from ride", new RideRowMapper());
    }
}
