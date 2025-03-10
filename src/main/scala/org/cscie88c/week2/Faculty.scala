package org.cscie88c.week2

// write code for class Faculty below
class Faculty(
    name: String,
    email: String,
    courseid: String
  ) extends UniversityEmployee(name, email) {
  override def description: String =
    s"Name: ${name}, Email: ${email}, Course: ${courseid}"
}
