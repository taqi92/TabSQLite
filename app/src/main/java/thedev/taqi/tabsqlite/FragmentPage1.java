package thedev.taqi.tabsqlite;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
//import com.notarazi.myviewpagertablayout1.R;
//import com.notarazi.myviewpagertablayout1.db.EmployeeDAO;
//import com.notarazi.myviewpagertablayout1.model.Employee;
import thedev.taqi.tabsqlite.db.*;
import thedev.taqi.tabsqlite.model.Employee;

public class FragmentPage1 extends Fragment implements OnClickListener {
    // UI references
    private EditText empNameEtxt;
    private EditText empAgeEtxt;
    private EditText empLatEtxt;
    private EditText empLonEtxt;
    private Button addButton;
    private Button resetButton;
//    private static final SimpleDateFormat formatter = new SimpleDateFormat(
//            "yyyy-MM-dd", Locale.ENGLISH);
//    DatePickerDialog datePickerDialog;
//    Calendar dateCalendar;
    Employee employee = null;
    private EmployeeDAO employeeDAO;
    private AddEmpTask task;
    public static final String ARG_ITEM_ID = "emp_add_fragment";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeDAO = new EmployeeDAO(getActivity());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_page1, container,
                false);
        findViewsById(rootView);
        setListeners();
        //For orientation change.
//        if (savedInstanceState != null) {
//            dateCalendar = Calendar.getInstance();
//            if (savedInstanceState.getLong("dateCalendar") != 0)
//                dateCalendar.setTime(new Date(savedInstanceState
//                        .getLong("dateCalendar")));
//        }
        return rootView;
    }
    private void setListeners() {
        empLatEtxt.setOnClickListener(this);
//        Calendar newCalendar = Calendar.getInstance();
//        datePickerDialog = new DatePickerDialog(getActivity(),
//                new OnDateSetListener() {
//                    public void onDateSet(DatePicker view, int year,
//                                          int monthOfYear, int dayOfMonth) {
//                        dateCalendar = Calendar.getInstance();
//                        dateCalendar.set(year, monthOfYear, dayOfMonth);
//                        empLatEtxt.setText(formatter.format(dateCalendar
//                                .getTime()));
//                    }
//                }, newCalendar.get(Calendar.YEAR),
//                newCalendar.get(Calendar.MONTH),
//                newCalendar.get(Calendar.DAY_OF_MONTH));
        addButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }
    protected void resetAllFields() {
        empNameEtxt.setText("");
        empAgeEtxt.setText("");
        empLatEtxt.setText("");
    }
    private void setEmployee() {
        employee = new Employee();
        employee.setName(empNameEtxt.getText().toString());
        employee.setAge(Integer.parseInt(empAgeEtxt.getText()
                .toString()));
        employee.setLat(Double.parseDouble(empLatEtxt.getText()
                .toString()));
        employee.setLon(Double.parseDouble(empLonEtxt.getText()
                .toString()));

//        if (dateCalendar != null)
//            employee.setDateOfBirth(dateCalendar.getTime());
    }
    @Override
    public void onResume() {
        //getActivity().setTitle(R.string.add_emp);
        //getActivity().getActionBar().setTitle(R.string.add_emp);
        super.onResume();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
//        if (dateCalendar != null)
//            outState.putLong("dateCalendar", dateCalendar.getTime().getTime());
    }
    private void findViewsById(View rootView) {
        empNameEtxt = (EditText) rootView.findViewById(R.id.etxt_name);
        empAgeEtxt = (EditText) rootView.findViewById(R.id.etxt_age);
        empLatEtxt = (EditText) rootView.findViewById(R.id.etxt_lat);
        empLonEtxt = (EditText) rootView.findViewById(R.id.etxt_lon);
        addButton = (Button) rootView.findViewById(R.id.button_add);
        resetButton = (Button) rootView.findViewById(R.id.button_reset);
    }
    @Override
    public void onClick(View view) {
        if (view == empLatEtxt) {
            //datePickerDialog.show();
        } else if (view == addButton) {
            setEmployee();
            task = new AddEmpTask(getActivity());
            task.execute((Void) null);
        } else if (view == resetButton) {
            resetAllFields();
        }
    }
    public class AddEmpTask extends AsyncTask<Void, Void, Long> {
        private final WeakReference<Activity> activityWeakRef;
        public AddEmpTask(Activity context) {
            this.activityWeakRef = new WeakReference<Activity>(context);
        }
        @Override
        protected Long doInBackground(Void... arg0) {
            long result = employeeDAO.save(employee);
            return result;
        }
        @Override
        protected void onPostExecute(Long result) {
            if (activityWeakRef.get() != null
                    && !activityWeakRef.get().isFinishing()) {
                if (result != -1)
                    Toast.makeText(activityWeakRef.get(), "Employee Saved",
                            Toast.LENGTH_LONG).show();
            }
        }
    }
}
