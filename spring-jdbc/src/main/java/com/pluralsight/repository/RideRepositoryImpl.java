package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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

        /*
        KeyHolder keyHolder = new GeneratedKeyHolder(); //NOSONAR
        jdbcTemplate.update(new PreparedStatementCreator() { //NOSONAR

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException { //NOSONAR

                PreparedStatement preparedStatement = connection //NOSONAR
                        .prepareStatement("insert into ride (name, duration) values (?,?)", new String[] { "id" }); //NOSONAR
                preparedStatement.setString(1, ride.getName()); //NOSONAR
                  preparedStatement.setInt(2, ride.getDuration()); //NOSONAR

                return preparedStatement; //NOSONAR
            } //NOSONAR
        }, keyHolder); //NOSONAR
        
        Number id = keyHolder.getKey(); //NOSONAR
        */

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("ride");

        List<String> columns = new ArrayList<>();
        columns.add("name");
        columns.add("duration");

        Map<String, Object> data = new HashMap<>();
        data.put("name", ride.getName());
        data.put("duration", ride.getDuration());

        insert.setGeneratedKeyName("id");

        Number id = insert.executeAndReturnKey(data);
        
        return getRide(id.intValue());
    }
    
    @Override
    public Ride getRide(Integer id) {
        
        return jdbcTemplate.queryForObject("select * from ride where id = ?", new RideRowMapper(), id);
    }

    @Override
    public List<Ride> getRides() {

        return jdbcTemplate.query("select * from ride", new RideRowMapper());
    }
}
