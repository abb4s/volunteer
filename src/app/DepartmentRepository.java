package app;




import java.util.ArrayList;

import domain.Department;

/**
 * Created by amin on 29/05/2016.
 */
public class DepartmentRepository {
    private static DepartmentRepository repository=null;
    private ArrayList<Department> departments;
    private DepartmentRepository()
    {
        departments=new ArrayList<Department>();
    }
    public static DepartmentRepository getRepository()
    {
        if(repository==null)
        {
            repository=new DepartmentRepository();
        }
        return repository;
    }
    public void add(Department dep)
    {
        departments.add(dep);
    }
    public Department find(String dep){
        for (Department department:departments
             ) {
            if(department.getName().equals(dep)){
                return department;
            }
        }
        return  null;
    }
    public ArrayList<Department> findAll(){
        return departments;
    }
}
