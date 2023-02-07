package net.therap.mealplanner.dao;

import net.therap.mealplanner.domains.Item;
import net.therap.mealplanner.domains.Meal;
import net.therap.mealplanner.enums.Day;
import net.therap.mealplanner.enums.Type;
import net.therap.mealplanner.helper.Helper;
import net.therap.mealplanner.helper.HibernateHelper;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public class MealDao {

    public List<Meal> getMeals() throws SQLException {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Query query = session.createQuery("from Meal");

        List<Meal> meals = query.list();
        session.close();
        return meals;
    }

    public void addItemsToMeal(Day day, Type type, List<Item> items) throws SQLException {
        Meal meal = new Meal();
        meal.setDay(day);
        meal.setType(type);
        meal.setItems(items);

        Session session = HibernateHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(meal);
        session.getTransaction().commit();
        session.close();
    }
}
