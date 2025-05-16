package com.data.session09.repository.ex02;

import com.data.session09.model.ex02.Movie;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MovieRepoImpl implements  MovieRepo {
    @Override
    public List<Movie> findAll() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Movie> movies = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call find_all_movie()}");
            boolean hasResult = callableStatement.execute();
            if (hasResult) {
                ResultSet rs = callableStatement.getResultSet();
                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getLong("id"));
                    movie.setTitle(rs.getString("title"));
                    movie.setDirector(rs.getString("director"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setDescription(rs.getString("description"));
                    movie.setDuration(rs.getInt("duration"));
                    movie.setLanguage(rs.getString("language"));
                    movies.add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return movies;
    }

    @Override
    public Movie findById(Long id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call find_movie_by_id(?)}");
            callableStatement.setLong(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setLanguage(resultSet.getString("language"));
                return movie;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return null;
    }
}
