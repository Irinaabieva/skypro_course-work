public class Main {
    public static Employee[] arr = new Employee[10];

    public static void main(String[] args) {
        arr[0] = new Employee("Иван Иванов", "ИТ", 35_000);
        arr[1] = new Employee("Петр Петров", "ИТ", 40_000);
        arr[2] = new Employee("Семен Семенов", "ИТ", 35_000);
        arr[3] = new Employee("Сергей Васичкин", "ИТ", 32_000);
        arr[4] = new Employee("Михаил Махайлов", "ЧС", 34_000);
        arr[5] = new Employee("Марина Авдотьева", "ЧС", 31_000);
        arr[6] = new Employee("Сусанна Сергеева", "ФИН", 32_000);
        arr[7] = new Employee("Мирослава Акофеева", "ФИН", 30_000);
        arr[8] = new Employee("Эдуард Эдуардов", "ССТ", 40_000);
        arr[9] = new Employee("Андрей Андреев", "ЭК", 50_000);
        allPrint(arr);
        System.out.println("Сумма затрат на зарплаты в месяц " + getSumSalaryOnMonth(arr) + " рублей");
        System.out.println("Сотрудник с максимальной зарплатой - " + getEmployeeWithMaxSalary(arr));
        System.out.println("Сотрудник с минимальной зарплатой - " + getEmployeeWithMinSalary(arr));
        System.out.println("Среднее значение зарлат = " + getAverageSalary(arr) + " рублей");
        printName(arr);
        System.out.println(employeeWithMinSalaryInDepartment("ФИН"));
        System.out.println(employeeWithMaxSalaryInDepartment("ИТ"));
        System.out.println(getSumSalaryInDepartment("ФИН"));
        System.out.println(getAverageSalaryInDepartment("ФИН"));
        printIndexSalary(3);
    }


    // 1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    public static void allPrint(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // 2. Посчитать сумму затрат на зарплаты в месяц.
    public static int getSumSalaryOnMonth(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    //   3. Найти сотрудника с минимальной зарплатой.
    public static String getEmployeeWithMinSalary(Employee[] employees) {
        String result = "";
        int minSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                result = employees[i].getName();
            }
        }
        return result;
    }


    //    4. Найти сотрудника с максимальной зарплатой.
    public static String getEmployeeWithMaxSalary(Employee[] employees) {
        String result = "";
        int maxSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                result = employees[i].getName();
            }
        }
        return result;
    }

    //    5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    public static int getAverageSalary(Employee[] employees) {
        return getSumSalaryOnMonth(employees) / employees.length;
    }

    //    Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public static void printName(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName());
        }
    }

    // ПОВЫШЕННАЯ СЛОЖНОСТЬ

    //    Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).

    public static void printIndexSalary(int percent) {
        int indexSalary = 0;
        for (Employee employee : arr) {
            if (employee != null) {
                indexSalary = (employee.getSalary() + employee.getSalary() * percent / 100);
                System.out.println("После индексации зп " + employee.getName() + " получает " + indexSalary + " рублей");

            }
        }
    }

    //    Напечатать всех сотрудников отдела (все данные, кроме отдела).

    public static void printEmployeeInDepartment(String department) {

        for (Employee employee : arr) {
            if (department == employee.getDepartment()) {
                System.out.println(employee.getName() + " " + employee.getSalary());
            }
        }
    }

    //    Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов) Сотрудника с минимальной зарплатой
    public static String employeeWithMinSalaryInDepartment(String department) {
        String result = "";
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : arr) {
            if (employee.getSalary() < minSalary && employee.getDepartment() == department) {
                minSalary = employee.getSalary();
                result = employee.getName();
            }
        }
        return result;
    }

    //    Сотрудника с максимальной зарплатой
    public static String employeeWithMaxSalaryInDepartment(String department) {
        String result = "";
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : arr) {
            if (employee.getSalary() > maxSalary && employee.getDepartment() == department) {
                maxSalary = employee.getSalary();
                result = employee.getName();
            }
        }
        return result;
    }

    //    Сумму затрат на зарплату по отделу.
    public static int getSumSalaryInDepartment(String department) {
        int sum = 0;
        for (Employee employee : arr) {

            if (department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //    Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
    public static int getAverageSalaryInDepartment(String department) {
        int sum = 0;
        for (Employee employee : arr) {
            if (employee.getDepartment() == department) {
                sum += 1;
            }
        }
        return getSumSalaryInDepartment(department) / sum;
    }

}