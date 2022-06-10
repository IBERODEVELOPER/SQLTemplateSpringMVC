package edu.ibero.model;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author IBERO
 */
public class Conectar {

    // Declaramos los datos de conexion a la bd driver
    private static final String driver = "com.mysql.jdbc.Driver";
    //url de la db puerto, db autilizar e indicamos el caracterencoding
    private static final String url = "jdbc:mysql://localhost:3306/dbibero?characterEncoding=UTF-8";
    //credenciales de conexion a la DB
    private static final String user = "root";
    private static final String pass = "12345";
    
    //metodo de tipo DriverManagerSource
    public DriverManagerDataSource conectar() {
        //crear un objeto de la clase DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //pasos los datos de conexion al DriverManagerDataSource - DRIVER, URL,USER,PASS
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pass);
        //Retornamos el DriverManagerDataSource
        return dataSource;
    }
    
}

//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
////        dataSource.setUrl("jdbc:mysql://localhost/iberodb");
//        dataSource.setUsername("root");
//        dataSource.setPassword("12345");
