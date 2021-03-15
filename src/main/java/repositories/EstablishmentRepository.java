package repositories;

import data.interfaces.IDB;
import entities.Desire;
import entities.Establishment;
import entities.User;
import repositories.interfaces.IEstablishmentRepository;

import javax.inject.Inject;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EstablishmentRepository implements IEstablishmentRepository{
    @Inject
    private IDB db;

    @Override
    public boolean create(Establishment establishment) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO establishment(establishment_name,country,rating,establishment_type,founder,desire_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, establishment.getName());
            st.setString(2,establishment.getCountry());
            st.setInt(3,establishment.getRating());
            st.setString(4,establishment.getType());
            st.setString(5,establishment.getFounder());
            st.setInt(6,establishment.getDesire_id());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Establishment get(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT e.establishment_id, e.establishment_name, e.country, e.rating, " +
                    "e.establishment_type, e.founder ,e.desire_id ,d.desire_name, d.desire_description" +
                    " FROM establishment e, desire d WHERE e.desire_id = d.desire_id AND e.establishment_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Establishment establishment = new Establishment(
                        rs.getInt("establishment_id"),
                        rs.getString("establishment_name"),
                        rs.getString("country"),
                        rs.getInt("rating"),
                        rs.getString("establishment_type"),
                        rs.getString("founder"),
                        rs.getInt("desire_id"),
                        new Desire(
                                rs.getInt("desire_id"),
                                rs.getString("desire_name"),
                                rs.getString("desire_description")
                        )

                );

                return establishment;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Establishment> getAll() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM establishment";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Establishment> establishments = new LinkedList<>();
            while (rs.next()) {
                Establishment establishment = new Establishment(
                        rs.getInt("establishment_id"),
                        rs.getString("establishment_name"),
                        rs.getString("country"),
                        rs.getInt("rating"),
                        rs.getString("establishment_type"),
                        rs.getString("founder"),
                        rs.getInt("desire_id"));
                establishments.add(establishment);
            }

            return establishments;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public boolean delete(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM establishment WHERE establishment_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();

            return st.getUpdateCount() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public List<Establishment> getEstablishmentByType(String type){
        Connection con = null;
        type = "%"+type+"%";
        try {
            con = db.getConnection();
            String sql = "SELECT establishment_id,establishment_name,country,rating,establishment_type,founder,desire_id FROM establishment WHERE establishment_type LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,type);
            ResultSet rs = st.executeQuery();

            List<Establishment> establishments = new LinkedList<>();

            while (rs.next()) {
                Establishment establishment = new Establishment(
                        rs.getInt("establishment_id"),
                        rs.getString("establishment_name"),
                        rs.getString("country"),
                        rs.getInt("rating"),
                        rs.getString("establishment_type"),
                        rs.getString("founder"),
                        rs.getInt("desire_id"));

                establishments.add(establishment);
            }

            return establishments;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Establishment> getEstablishmentByName(String name) {
        Connection con = null;
        name = "%"+name+"%";
        try {
            con = db.getConnection();
            String sql = "SELECT establishment_id,establishment_name,country,rating,establishment_type,founder,desire_id FROM establishment WHERE establishment_name LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,name);

            ResultSet rs = st.executeQuery();
            List<Establishment> establishments = new LinkedList<>();
            if (rs.next()) {
                Establishment establishment = new Establishment(
                        rs.getInt("establishment_id"),
                        rs.getString("establishment_name"),
                        rs.getString("country"),
                        rs.getInt("rating"),
                        rs.getString("establishment_type"),
                        rs.getString("founder"),
                        rs.getInt("desire_id"));

                establishments.add(establishment);
            }
            return establishments;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean createEstablishment(Establishment establishment) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "INSERT INTO establishment(establishment_id,establishment_name,country,rating,establishment_type,founder,desire_id) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,establishment.getId());
            st.setString(2,establishment.getName());
            st.setString(3,establishment.getCountry());
            st.setInt(4,establishment.getRating());
            st.setString(5,establishment.getType());
            st.setString(6,establishment.getFounder());
            st.setInt(7,establishment.getDesire_id());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public List<Establishment> getEstablishmentByRating(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT establishment_id,establishment_name,country,rating,establishment_type,founder,desire_id FROM establishment ORDER BY rating DESC";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            List<Establishment> establishments = new LinkedList<>();

            while (rs.next()) {
                Establishment establishment = new Establishment(
                        rs.getInt("establishment_id"),
                        rs.getString("establishment_name"),
                        rs.getString("country"),
                        rs.getInt("rating"),
                        rs.getString("establishment_type"),
                        rs.getString("founder"),
                        rs.getInt("desire_id"));

                establishments.add(establishment);
            }

            return establishments;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean updateEstablishment(Establishment establishment) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE establishment SET establishment_name=?,country=?,rating=?,establishment_type=?,founder=?,desire_id=? WHERE establishment_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,establishment.getName());
            st.setString(2,establishment.getCountry());
            st.setInt(3,establishment.getRating());
            st.setString(4,establishment.getType());
            st.setString(5,establishment.getFounder());
            st.setInt(6,establishment.getDesire_id());
            st.setInt(7,establishment.getId());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean updateRating(int id,int rating) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE establishment SET rating=? WHERE establishment_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,rating);
            st.setInt(2,id);


            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean updateDesire(Desire desire) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE desire SET desire_name=?, desire_description=? WHERE desire_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,desire.getName());
            st.setString(2,desire.getDescription());
            st.setInt(3,desire.getId());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean createDesire(Desire desire) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO desire(desire_id,desire_name,desire_description) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,desire.getId());
            st.setString(2, desire.getName());
            st.setString(3,desire.getDescription());


            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean updateCountry(Establishment establishment) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE establishment SET country=? WHERE founder=? and establishment_type=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,establishment.getCountry());
            st.setString(2,establishment.getFounder());
            st.setString(3,establishment.getType());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean deleteDesire(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM desire WHERE desire_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();

            return st.getUpdateCount() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }
    @Override
    public boolean updateFounder(Establishment establishment) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE establishment SET founder=? WHERE founder='Unknown' and establishment_id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,establishment.getFounder());
            st.setInt(2,establishment.getId());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}