package thedev.taqi.tabsqlite.model;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

import static java.lang.System.in;
//import static thedev.taqi.tabsqlite.R.string.salary;

public class Employee implements Parcelable {
    private int id;
    private String name;
    private int age;
    private double latitude;
    private double longitude;
    public Employee() {
        super();
    }
    private Employee(Parcel in) {
        super();
        this.id = in.readInt();
        this.name = in.readString();
        this.age = in.readInt();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getLat() {
        return latitude;
    }
    public void setLat(double latitude) {
        this.latitude = latitude;
    }
    public double getLon() {
        return longitude;
    }
    public void setLon(double longitude) {
        this.longitude = longitude;
    }
    //public void

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age="
                + age + ", longitude=" + longitude + ",  latitude=" + latitude + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeInt(getAge());
        parcel.writeDouble(getLat());
        parcel.writeDouble(getLon());
    }
//    public static final Parcelable.Creator<Employee> CREATOR = newParcelable.Creator<Employee>() {
//        public Employee createFromParcel(Parcel in) {
//            return new Employee(in);
//        }
//        public Employee[] newArray(int size) {
//            return new Employee[size];
//        }
//    };
}