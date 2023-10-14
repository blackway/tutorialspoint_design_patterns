package creational.prototyp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProtottypePatternTest {

    public static void main(String... args) throws CloneNotSupportedException {
        Employees emps = new ProtottypePatternTest().new Employees();
        emps.loadData();

        // User the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Panka");

        System.out.println("emps List : " +emps.getEmpList());
        System.out.println("empsNew : " +empsNew.getEmpList());
        System.out.println("empsNew1 : " +empsNew1.getEmpList());

    }

    class Employees implements Cloneable {

        private List<String> empList;
        
        public Employees() {
            empList = new ArrayList<>();
        }

        public Employees(List<String> list) {
            this.empList = list;
        }

        public void loadData() {
            //read all employees from database dand put into the list
            empList.add("Panka");
            empList.add("Ra");
            empList.add("David");
            empList.add("Lisa");
        }

        public List<String> getEmpList() {
            return empList;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            List<String> temp = new ArrayList<>();
            temp = this.getEmpList().stream().collect(Collectors.toList());
            return new Employees(temp);
            // return super.clone();
        }
    }
}
