package gallerie.db.tables;

 import java.sql.Connection;
import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.Statement;
 import java.sql.SQLException;
 import java.util.Date;
import java.util.LinkedList;
import java.util.List;
 import java.util.Objects;
 import java.util.Optional;

import gallerie.db.Table;
import gallerie.model.Student;
import gallerie.utils.Utils;

 public final class StudentsTable implements Table<Student, Integer> {    
     public static final String TABLE_NAME = "students";

     private final Connection connection; 

     public StudentsTable(final Connection connection) {
         this.connection = Objects.requireNonNull(connection);
     }

     @Override
     public String getTableName() {
         return TABLE_NAME;
     }

     public boolean createTable() {
         // 1. Create the statement from the open connection inside a try-with-resources
         try (final Statement statement = this.connection.createStatement()) {
             // 2. Execute the statement with the given query
             statement.executeUpdate(
                 "CREATE TABLE " + TABLE_NAME + " (" +
                         "id INT NOT NULL PRIMARY KEY," +
                         "firstName CHAR(40) NOT NULL," + 
                         "lastName CHAR(40) NOT NULL," + 
                         "birthday DATE" + 
                     ")");
             return true;
         } catch (final SQLException e) {
             // 3. Handle possible SQLExceptions
             return false;
         }
     }

     @Override
     public Optional<Student> findByPrimaryKey(final Integer id) {
    	 /*
         try (final Statement statement = this.connection.createStatement()) {
        	 final ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id);
        	 // SQLInjection --> meglio non fare concatenazione di stringhe con oggetti passati dall'esterno
        	 return readStudentsFromResultSet(resultSet).stream().findFirst();
         } catch (final SQLException e) {
        	 return Optional.empty();
         }
         */
    	 
    	 // Usa PreparedStatement e ? per evitare SQLInjection
    	 final String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
    	 try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
    		 statement.setInt(1, id);
        	 final ResultSet resultSet = statement.executeQuery();
        	 return readStudentsFromResultSet(resultSet).stream().findFirst();
         } catch (final SQLException e) {
        	 return Optional.empty();
         }
     }

     /**
      * Given a ResultSet read all the students in it and collects them in a List
      * @param resultSet a ResultSet from which the Student(s) will be extracted
      * @return a List of all the students in the ResultSet
      */
     private List<Student> readStudentsFromResultSet(final ResultSet resultSet) {
         // Create an empty list, then
         // Inside a loop you should:
         //      1. Call resultSet.next() to advance the pointer and check there are still rows to fetch
         //      2. Use the getter methods to get the value of the columns
         //      3. After retrieving all the data create a Student object
         //      4. Put the student in the List
         // Then return the list with all the found students

         // Helpful resources:
         // https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
         // https://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html
         final List<Student> list = new LinkedList<>();
         try {
			while (resultSet.next()) {
				 int id = resultSet.getInt("id");
				 String name = resultSet.getString("firstName");
				 String lastname = resultSet.getString("lastName");
				 Optional<Date> birth;
				 if (resultSet.getDate("birthday") == null) {
					 birth = Optional.empty();
				 } else {
					 birth = Optional.of(Utils.sqlDateToDate(resultSet.getDate("birthday")));
				 }
				 Student student = new Student(id, name, lastname, birth);
				 list.add(student);
			 }
			return list;
		} catch (SQLException e) {
			return null;
		}
     }

     @Override
     public List<Student> findAll() {
    	 try (final Statement statement = this.connection.createStatement()) {
    		 final ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
        	 return readStudentsFromResultSet(resultSet);
         } catch (final SQLException e) {
        	 return null;
         }
     }

     public List<Student> findByBirthday(final Date date) {
    	 final String query = "SELECT * FROM " + TABLE_NAME + " WHERE birthday = ?";
    	 try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
    		 statement.setDate(1, Utils.dateToSqlDate(date));
        	 final ResultSet resultSet = statement.executeQuery();
        	 return readStudentsFromResultSet(resultSet);
         } catch (final SQLException e) {
        	 return null;
         }
     }

     @Override
     public boolean dropTable() {
    	 try (final Statement statement = this.connection.createStatement()) {
             // 2. Execute the statement with the given query
             statement.executeUpdate("DROP TABLE " + TABLE_NAME);
             return true;
         } catch (final SQLException e) {
             // 3. Handle possible SQLExceptions
             return false;
         }
     }

     @Override
     public boolean save(final Student student) {
    	 if (this.findByPrimaryKey(student.getId()).isPresent()) {
    		 return false;
    	 }
    	 String query = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?)";
    	 if (student.getBirthday().isEmpty()) {
    		 query = "INSERT INTO " + TABLE_NAME + " (id, firstName, lastName) VALUES (?, ?, ?)";
    	 }
         try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
        	 statement.setInt(1, student.getId());
        	 statement.setString(2, student.getFirstName());
        	 statement.setString(3, student.getLastName());
        	 if (student.getBirthday().isPresent()) {
        		 statement.setDate(4, Utils.dateToSqlDate(student.getBirthday().get()));
        	 }
        	 statement.executeUpdate();
        	 return true;
         } catch (SQLException e) {
			return false;
		}
     }

     @Override
     public boolean delete(final Integer id) {
         if (this.findByPrimaryKey(id).isEmpty()) {
        	 return false;
         } else {
        	 final String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        	 try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
        		 statement.setInt(1, id);
        		 statement.executeUpdate();
        		 return true;
        	 } catch (SQLException e) {
        		 return false;
        	 }
         }
     }

     @Override
     public boolean update(final Student student) {
    	 if (this.findByPrimaryKey(student.getId()).isEmpty()) {
        	 return false;
         } else {
        	 final String query = "UPDATE " + TABLE_NAME + " SET id = ?, firstName = ?, lastName = ?, birthday = ? "
        	 					+ "WHERE id = ?";
        	 try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
        		 statement.setInt(1, student.getId());
        		 statement.setString(2, student.getFirstName());
        		 statement.setString(3, student.getLastName());
        		 if (student.getBirthday().isPresent()) {
            		 statement.setDate(4, Utils.dateToSqlDate(student.getBirthday().get()));
        		 } else {
        			 statement.setDate(4, null);
        		 }
        		 statement.setInt(5, student.getId());
        		 statement.executeUpdate();
        		 return true;
        	 } catch (SQLException e) {
        		 return false;
        	 }
         }
     }
 }