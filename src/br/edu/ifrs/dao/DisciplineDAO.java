package br.edu.ifrs.dao;

import br.edu.ifrs.bean.Discipline;
import br.edu.ifrs.bean.Student;
import br.edu.ifrs.utils.ConnectionToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDAO {


    public static void insert(Discipline discipline) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("INSERT INTO knowledge_sharing_system.discipline ( description, semester) VALUES (?, ?)");
            ps.setString(1, discipline.getDescription());
            ps.setString(2, discipline.getSemester());

            ps.execute();
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.DisciplineDAO.insert] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    public static void update(Discipline discipline) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("UPDATE knowledge_sharing_system.discipline SET description = ?, semester = ? WHERE id = ?");
            ps.setString(1, discipline.getDescription());
            ps.setString(2, discipline.getSemester());
            ps.setInt(3, discipline.getId());

            ps.execute();
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.DisciplineDAO.update] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    public static Discipline[] search(Discipline discipline) throws Exception {
        List<Discipline> list = new ArrayList();
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("SELECT * FROM knowledge_sharing_system.discipline WHERE discipline.description LIKE ? AND discipline.semester LIKE ?");
            ps.setString(1, "%" + discipline.getDescription() + "%");
            ps.setString(2, "%" + discipline.getSemester() + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Discipline d = new Discipline();
                d.setId(rs.getInt("id"));
                d.setDescription(rs.getString("description"));
                d.setSemester(rs.getString("semester"));

                list.add(d);
            }
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.DisciplineDAO.search] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return list.toArray(new Discipline[0]);
    }

    public static Discipline select(Discipline discipline) throws Exception {
        Discipline d = new Discipline();
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("SELECT * FROM knowledge_sharing_system.discipline WHERE id = ?");
            ps.setInt(1, discipline.getId());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setDescription(rs.getString("description"));
                d.setSemester(rs.getString("semester"));
            }
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.DisciplineDAO.select] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return d;
    }

    public static void delete(Discipline discipline) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionToDB.open();

            ps = conn.prepareStatement("DELETE FROM knowledge_sharing_system.discipline WHERE id = ?");
            ps.setInt(1, discipline.getId());

            ps.execute();
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.dao.DisciplineDAO.delete] Falha ao acessar o banco de dados.");
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

}
