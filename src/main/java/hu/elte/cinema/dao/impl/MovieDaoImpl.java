package hu.elte.cinema.dao.impl;


import hu.elte.cinema.dao.interfaces.MovieDao;
import hu.elte.cinema.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MovieDaoImpl extends CrudDaoImpl<Movie, Integer>
implements MovieDao {

    @Autowired
    public MovieDaoImpl(SessionFactory sessionFactory) {
        super(Movie.class, sessionFactory);
    }
}
