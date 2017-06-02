package thedev.taqi.tabsqlite.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.ParseException;
import thedev.taqi.tabsqlite.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import thedev.taqi.tabsqlite.db.DataBaseHelper;
import thedev.taqi.tabsqlite.db.EmployeeDBDAO;
import thedev.taqi.tabsqlite.model.Employee;

public class EmployeeDAO extends EmployeeDBDAO {
    private static final SimpleDateFormat formatter = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.ENGLISH);
    public EmployeeDAO(Context context) {
        super(context);
    }
    //...
    public long save(Employee employee) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.NAME_COLUMN, employee.getName());
        values.put(DataBaseHelper.AGE,employee.getAge());
        values.put(DataBaseHelper.LATITUDE, employee.getLat());
        values.put(DataBaseHelper.LONGITUDE, employee.getLon());


        return database.insert(DataBaseHelper.EMPLOYEE_TABLE, null, values);
    }
    //Get all records from the database
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Cursor cursor = database.query(DataBaseHelper.EMPLOYEE_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.NAME_COLUMN,
                        DataBaseHelper.AGE,
                        DataBaseHelper.LATITUDE,
                        DataBaseHelper.LONGITUDE}, null, null, null,null,
                null, null);
        while (cursor.moveToNext()) {
            Employee employee = new Employee();
            employee.setId(cursor.getInt(0));
            employee.setName(cursor.getString(1));
//            try {
//                employee.setDateOfBirth(formatter.parse(cursor.getString(2)));
//            } catch (ParseException e) {
//                employee.setDateOfBirth(null);
//            } catch (java.text.ParseException e) {
//                e.printStackTrace();
//            }
            employee.setAge(cursor.getInt(2));
            employee.setLat(cursor.getDouble(3));
            employee.setLon(cursor.getDouble(4));
            employees.add(employee);
        }
        return employees;
    }
}