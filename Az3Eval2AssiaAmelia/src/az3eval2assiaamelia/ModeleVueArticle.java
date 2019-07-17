/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az3eval2assiaamelia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author TAOURIRT
 */
public class ModeleVueArticle extends Observable{
       private static String hote = "jdbc:mysql://localhost/projetswing";
    private static String usager = "root";
    private static String passwd = "";
     private static String sqlc;
    private static Statement stmt;
    private static ResultSet rs;
    private static PreparedStatement pstmt;
     private Connection con= null;
    int pos;
      public Connection getConnection (){
    Connection con = null;
    try {
        con = DriverManager.getConnection(hote, usager, passwd);
  
    }catch (SQLException e){
        e.printStackTrace();
    }
    return con;
}
    
    public void ajouterArticles (Article art) throws SQLException{
  
        sqlc = "insert into article ( code, code_categorie, désignation_art,  prix) values (?,?,?,?)";
        pstmt= con.prepareStatement(sqlc);
        pstmt.setString(1,art.getCode_art());
        pstmt.setString(2, art.getCode_cat());
        pstmt.setString(3, art.getDes_art());
        pstmt.setDouble(4, art.getprix());
        pstmt.executeUpdate();
      
    }

    public void modifierArticles (Article art) throws SQLException{
        try {
  
             if(getArticle(art.getCode_art())==true){
            
        sqlc = "UPDATE article SET désignation_art = ? ,code_categorie=?,prix=? WHERE code=?";
        pstmt= con.prepareStatement(sqlc);
        pstmt.setString(1,art.getDes_art());
        pstmt.setString(2,art.getCode_cat() );
       pstmt.setDouble(3,art.getprix());
        pstmt.setString(4,art.getCode_art());
       
        pstmt.executeUpdate();
          JOptionPane.showMessageDialog(null,"Article modifier avec succès !");
           } else{
          
          JOptionPane.showMessageDialog(null, "le code article n'existe pas ");
          }
      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    }
      public void supprimerArticles (String _code) throws SQLException{
  try {
  
             if(getArticle(_code)==true){
            
        sqlc = "delete from article WHERE code='"+_code+"'";
     
       pstmt.execute(sqlc);
       
     
          JOptionPane.showMessageDialog(null,"Article supprimee avec succès !");
           } else{
          
          JOptionPane.showMessageDialog(null, "le code article n'existe pas ");
          }
      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    }
    public boolean getArticle(String _code) throws SQLException{
        boolean codeexist = false;
  
        String sql = "select * from article WHERE code='"+_code+"' ";
        try {
            stmt= con.createStatement();
            rs =stmt.executeQuery(sql); 
                while(rs.next()){
                    codeexist=true;
                }
             
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "erreur de saisie"); }
             return codeexist;}
     public boolean getCategorie(String _code) throws SQLException{
        boolean codeexist = false;
  
        String sql = "select * from catégorie WHERE code='"+_code+"' ";
        try {
            stmt= con.createStatement();
            rs =stmt.executeQuery(sql); 
                while(rs.next()){
                    codeexist=true;
                }
             
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "erreur de saisie"); }
             return codeexist;}
    
   public Article AfficheArticleP() throws SQLException{

pos=1;
return AfficheArticlePosition(pos);
   
   }
    public Article AfficheArticleD() throws SQLException{

       String sql = "select * from article";
//        
        try {
        
   
          
     pstmt= con.prepareStatement(sql);
     
            rs =pstmt.executeQuery();
          
          
              rs.last();
              pos=rs.getRow();
         
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur d'affichage !"); 
       }

return AfficheArticlePosition(pos); 
   
   }
     public Article AfficheArticleS() throws SQLException{
      rs.next();
       
   return AfficheArticlePosition(++pos);
   
   }
      public Article AfficheArticlePre() throws SQLException{
      rs.previous();
      if(pos>0)
     return AfficheArticlePosition(--pos);
      else
          return null;
   
   }
       public Article AnnulerArticleS() throws SQLException{
     
 int pos2=pos;
        
   return AfficheArticlePosition(pos2);
   
   }
     public Article AfficheArticlePosition(int pos) throws SQLException{
     Article art = null; 
       String code1="",code2="",code3="";
     double code4=0;
        String sql = "select * from article";
         con = DriverManager.getConnection(hote, usager, passwd);
        try {
        
          
          
     pstmt= con.prepareStatement(sql);
     
            rs =pstmt.executeQuery();
      
             rs.absolute(pos);

                code1=rs.getString("code"); 
          code2=rs.getString("désignation_art"); 
           code3=rs.getString("code_categorie"); 
             code4=rs.getDouble("prix"); 
             
 
                
         
              art=new Article(code1, code2,code3,code4);
          
           
       } catch (Exception e) {
          // JOptionPane.showMessageDialog(null, "erreur d'affichage !"+e.getMessage()); 
       }
   
     return   art;     
   
   }
     
    

    
}
