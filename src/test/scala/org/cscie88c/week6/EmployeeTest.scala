package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class EmployeeTest extends StandardTest {
<<<<<<< Updated upstream
  // "Employee" should {
 
  //   "have a default sort order" in {
  //     // write unit tests here
  //   }

  //   "sort employees by salary" in {
  //     // write unit tests here
  //   }
  // }
=======
    val NintendoEmployees: List[Employee] = List(
    Employee("Mario",41,40000000),
    Employee("Peach",37,30000000),
    Employee("Toad",37,0),
    Employee("Rosalina",15,700000),
    Employee("Bowser",37,2000000)
  )

  "Employee" should {
 
    "have a default sort order" in {
      Employee.defaultSortEmployees(NintendoEmployees) should be (List(
        Employee("Bowser",37,2000000),
        Employee("Mario",41,40000000),
        Employee("Peach",37,30000000),
        Employee("Rosalina",15,700000),
        Employee("Toad",37,0)
      ))
    }

    "sort employees by salary" in {
      Employee.sortEmployeesBySalary(NintendoEmployees) should be (List(
        Employee("Mario",41,40000000),
        Employee("Peach",37,30000000),
        Employee("Bowser",37,2000000),
        Employee("Rosalina",15,700000),
        Employee("Toad",37,0)
      ))
    }
  }
>>>>>>> Stashed changes
}
