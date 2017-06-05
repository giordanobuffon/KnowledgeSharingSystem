package br.edu.ifrs.dao;

import br.edu.ifrs.bean.Student;
import br.edu.ifrs.utils.ConnectionToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {


    public static void insert(Student student) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("INSERT INTO knowledge_sharing_system.student (name, email, registration, course, semester, password) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getRegistration());
            ps.setString(4, student.getCourse());
            ps.setString(5, student.getSemester());
            ps.setString(6, student.getPassword());

            ps.execute();
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.StudentDAO.insert] Falha ao acessar o banco de dados. Aqui?" + e.getMessage() + e.getCause());
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    public static void update(Student student) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("UPDATE knowledge_sharing_system.student SET name = ?, password = ? WHERE id = ?");
            ps.setString(1, student.getName());
            ps.setString(2, student.getPassword());
            ps.setInt(3, student.getId());

            ps.execute();
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.StudentDAO.update] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    public static Student[] search(Student student) throws Exception {
        List<Student> list = new ArrayList();
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("SELECT * FROM knowledge_sharing_system.student WHERE student.registration LIKE ? AND student.password LIKE ?");
            ps.setString(1, "%" + student.getRegistration() + "%");
            ps.setString(2, "%" + student.getPassword() + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setRegistration(rs.getInt("registration"));
                s.setCourse(rs.getString("course"));
                s.setSemester(rs.getString("semester"));
                s.setPassword(rs.getString("password"));

                list.add(s);
            }
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.StudentDAO.search] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return list.toArray(new Student[0]);
    }

    public static Student select(Student student) throws Exception {
        Student s = new Student();
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("SELECT * FROM knowledge_sharing_system.student WHERE id = ?");
            ps.setInt(1, student.getId());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setRegistration(rs.getInt("registration"));
                s.setCourse(rs.getString("course"));
                s.setSemester(rs.getString("semester"));
                s.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.StudentDAO.select] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return s;
    }

    public static void delete(Student student) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("DELETE FROM knowledge_sharing_system.student WHERE id = ?");
            ps.setInt(1, student.getId());

            ps.execute();
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.StudentDAO.delete] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

}
