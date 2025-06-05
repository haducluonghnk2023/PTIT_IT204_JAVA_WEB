package com.data.session19.repo;

import com.data.session19.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MovieRepoImpl implements  MovieRepo {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Movie> findAll(int pageNumber, int pageSize) {
        Session session = sessionFactory.openSession();
        Query<Movie> query = session.createQuery("from Movie", Movie.class);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Movie> movies = query.getResultList();
        session.close();
        return movies;
    }

    @Override
    public Movie findById(Long id) {
        Session session = sessionFactory.openSession();
        Movie movie = session.get(Movie.class, id);
        session.close();
        if (movie != null) {
            return movie;
        }
        return null;
    }

    @Override
    public Movie save(Movie movie) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
        session.close();
        return movie;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, id);
        if (movie != null) {
            session.delete(movie);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Movie movie) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie existingMovie = session.get(Movie.class, movie.getId());
        if (existingMovie != null) {
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setDirector(movie.getDirector());
            existingMovie.setReleaseYear(movie.getReleaseYear());
            existingMovie.setGenre(movie.getGenre());
            existingMovie.setDuration(movie.getDuration());
            existingMovie.setLanguage(movie.getLanguage());
            existingMovie.setPoster(movie.getPoster());
            existingMovie.setStatus(movie.isStatus());
            session.update(existingMovie);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public long countMovies() {
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery("select count(m) from Movie m", Long.class);
        long count = query.uniqueResult();
        session.close();
        return count;
    }
}
