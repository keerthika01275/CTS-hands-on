package com.mvc;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            model.setName(name);
            view.displayUpdateSuccess("name");
        } else {
            view.displayErrorMessage("Name cannot be empty");
        }
    }

    public void setStudentRollNo(String rollNo) {
        if (rollNo != null && !rollNo.trim().isEmpty()) {
            model.setRollNo(rollNo);
            view.displayUpdateSuccess("roll number");
        } else {
            view.displayErrorMessage("Roll number cannot be empty");
        }
    }

    public void setStudentGrade(String grade) {
        if (grade != null && !grade.trim().isEmpty()) {
            model.setGrade(grade);
            view.displayUpdateSuccess("grade");
        } else {
            view.displayErrorMessage("Grade cannot be empty");
        }
    }

    public String getStudentName() {
        return model.getName();
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(
            model.getRollNo(),
            model.getName(),
            model.getGrade()
        );
    }
}
