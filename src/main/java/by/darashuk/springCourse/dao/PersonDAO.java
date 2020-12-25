package by.darashuk.springCourse.dao;

import by.darashuk.springCourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
//new BeanPropertyRowMapper<>(Person.class) - имеет в себе уже сделанные присваивания значений объекту типа:  person.setId(resultSet.getInt("id"));
        return jdbcTemplate.query("SELECT * FROM person",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {//new Object[]{id} - массив с одной переменной - получаемое id

        return jdbcTemplate.query("SELECT * FROM person WHERE id=?",new Object[]{id},new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null) ;//проверяем-есть-ли в базе чел такие id? ecли нет , то вывести надпись
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?)",person.getName(),person.getAge(),person.getEmail());

   }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",
                updatedPerson.getName(),updatedPerson.getAge(),updatedPerson.getEmail(),id);
    }



    public void delete(int id) {
        jdbcTemplate.update( "DELETE FROM Person WHERE id=?",id);



    }
}
