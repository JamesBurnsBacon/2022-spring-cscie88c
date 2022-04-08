package org.cscie88c.week3

final case class Student(
    name: String,
    email: String,
    subject: String,
    score: Int
  ) {
  def description: String =
    s"name: ${name}, email: ${email}, subject: ${subject}, score: ${score}"
}

object Student {
  def apply(csvRow: String): Student = {
    val fields = csvRow.split(",")
    Student(
      name = fields(0),
      email = fields(1),
      subject = fields(2),
      score = fields(3).toInt
    )
  }

  def validateEmail(student: Student): Boolean =
    if (student.email contains '@') {
      true
    }
    else {
      false
    }

  def averageScoreBySubject(
      subject: String,
      studentList: List[Student]
    ): Double = {
    val hasMatchingSubject = (s: Student) => s.subject == subject
    val getStudentScore = (s: Student) => s.score
    val filteredStudentList = studentList.filter(hasMatchingSubject)
    val sum = (filteredStudentList.map(getStudentScore)).sum
    (sum.toDouble / (filteredStudentList.length))
  }

  def averageScoreByStudent(
      student: Student,
      studentList: List[Student]
    ): Double = {
    val hasMatchingStudent = (s: Student) => s.name == student.name
    val getStudentScore = (s: Student) => s.score
    val filteredStudentList = studentList.filter(hasMatchingStudent)
    val sum = (filteredStudentList.map(getStudentScore)).sum
    (sum.toDouble / (filteredStudentList.length))
  }
}
