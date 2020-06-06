
package com.emergentes.dao;

import com.emergentes.modelo.Proveedor;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOimpl extends ConexionBD implements ProveedorDAO {

    @Override
    public void insert(Proveedor proveedor) throws Exception {
         try {
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("INSERT into productos (descrip,stock) values (?, ?)");
        ps.setString(1, proveedor.getDescrip());
        ps.setInt(2, proveedor.getStock());
        ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Proveedor productos) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE productos set descrip = ?, stock = ? WHERE id = ?");
            ps.setString(1, productos.getDescrip());
            ps.setInt(2,productos.getStock());
            ps.setInt(3, productos.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM productos where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Proveedor getById(int id) throws Exception {
        Proveedor pro=new Proveedor();
        
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos where id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                pro.setId(id);
                pro.setDescrip(rs.getString("descrip"));
                pro.setStock(rs.getInt("stock"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return pro;
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
     List<Proveedor> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Proveedor>();
            while(rs.next()){
                Proveedor pro= new Proveedor();
                pro.setId(rs.getInt("id"));
                pro.setDescrip(rs.getString("descrip"));
                pro.setStock(rs.getInt("stock"));
                lista.add(pro);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
        return lista;
    }
    
}
