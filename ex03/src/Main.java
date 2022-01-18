import domain.Company;
import domain.employee.Employee;
import domain.employee.EmployeeStorage;
import domain.employee.Role;
import domain.pay.Bookkeeper;

/**
 * 급여 관리 시스템
 * - 연초 매달 지급하는 기본급에 대한 협의를 함
 * - 회사는 급여 지급 시 소득세율에 따라 세금을 공제
 * - 급여 = 기본급 - (기본급 * 소득세율)
 *
 * @author Hman
 * @version 1.0.0
 * 작성일 2022-01-15
 */
public class Main {
    public static void main(String[] args) {
        //직원
        Employee employee1 = new Employee("정규직1", 1000, 0.1, Role.PERMANENT);
        Employee employee2 = new Employee("정규직2", 2000, 0.2, Role.PERMANENT);
        Employee employee3 = new Employee("계약직1", 3000, 0.3, Role.TEMPORARY);
        Employee employee4 = new Employee("계약직2", 4000, 0.3, Role.TEMPORARY);
        EmployeeStorage employeeStorage = new EmployeeStorage(employee1, employee2, employee3, employee4);

        //경리직원
        Bookkeeper bookkeeper = new Bookkeeper(employeeStorage);

        //회사
        Company company = new Company("Gyub",bookkeeper);

        System.out.println("정규직1의 월급 = " + company.informPay(employee1));
        System.out.println("계약직1의 월급 = " + company.informPay(employee3));
        System.out.println("전체 정규직 월급 = " + company.informAllPay(Role.PERMANENT));
        System.out.println("전체 계약직 월급 = " + company.informAllPay(Role.TEMPORARY));

    }
}
