package vn.itsol.springci.repository;

import vn.itsol.springci.dto.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
}
