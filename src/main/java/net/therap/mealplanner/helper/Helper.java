package net.therap.mealplanner.helper;


import net.therap.mealplanner.enums.Day;
import net.therap.mealplanner.enums.Option;
import net.therap.mealplanner.enums.Type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public class Helper {

    private static final Map<Integer, Option> optionMap = new HashMap<>();
    private static final Map<Integer, Day> dayMap = new HashMap<>();
    private static final Map<Integer, Type> typeMap = new HashMap<>();

    //private static final String DATABASE_AUTHENTICATION = "jdbc:mysql://localhost/meal_planner_hibernate?useSSL=false";
    //private static final String USER = "root";
    //rivate static final String PASSWORD = "password";

    static {
        optionMap.put(1, Option.VIEW_PLAN);
        optionMap.put(2, Option.VIEW_ITEMS);
        optionMap.put(3, Option.ADD_PLAN);
        optionMap.put(4, Option.ADD_ITEM);

        dayMap.put(1, Day.SUN);
        dayMap.put(2, Day.MON);
        dayMap.put(3, Day.TUE);
        dayMap.put(4, Day.WED);
        dayMap.put(5, Day.THU);

        typeMap.put(1, Type.BREAKFAST);
        typeMap.put(2, Type.LUNCH);
    }

    //public static Connection connect() throws SQLException {
    //    return DriverManager.getConnection(DATABASE_AUTHENTICATION, USER, PASSWORD);
    //}

    public static Option getOption(int input) {
        if (optionMap.containsKey(input)) {
            return optionMap.get(input);
        }

        return Option.INVALID;
    }

    public static Day getDay(int input) {
        return dayMap.get(input);
    }

    public static Type getType(int input) {
        return typeMap.get(input);
    }

    public static Map<Integer, Day> getDayMap() {
        return dayMap;
    }

    public static Map<Integer, Type> getTypeMap() {
        return typeMap;
    }
}
