/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az3eval2assiaamelia;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author TAOURIRT
 */
public class ControleurVueArticle {
      private VueArticle vue;
    private ModeleVueArticle model;

    public ControleurVueArticle(VueArticle vue, ModeleVueArticle model) {
        this.vue = vue;
        this.model = model;
        model.addObserver(vue);
        vue.jBAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBInsererrActionPerformed(e);
                
            }
        });
        vue.jBModifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBModifierActionPerformed(e);
                
            }

         
        });
         vue.jBSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBSupprimerActionPerformed(e);
                
            }

         
        });
          vue.jBPremier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBPremierActionPerformed(e);
                
            }

         
        });
          vue.jBDernier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBDernierActionPerformed(e);
                
            }

         
        });
           vue.jBSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBSuivantActionPerformed(e);
                
            }

         
        });
            vue.jBNouveau.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBNouveauActionPerformed(e);
                
            }

         
        });
             vue.jBAnnuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBAnnulerActionPerformed(e);
                
            }

         
        });
                  vue.jBPrécedent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBPrecedanttActionPerformed(e);
                
            }

         
        });
    }
     public void   jBAnnulerActionPerformed(ActionEvent e) {
         
                
           
        
          vue.jBPremier.setEnabled(true);
          vue.jBDernier.setEnabled(true);
          vue.jBSuivant.setEnabled(true);
          vue.jBPrécedent.setEnabled(true);
          vue.jBNouveau.setEnabled(true);
          vue.jBModifier.setEnabled(true);
          vue.jBSupprimer.setEnabled(true);
          vue.jBAjouter.setEnabled(false);
          vue.jBAnnuler.setEnabled(false);
          
       try {
           
          vue.jTextField1.setText(model.AnnulerArticleS().getCode_art()); 
          vue.jTextField2.setText(model.AnnulerArticleS().getDes_art()); 
          vue.jTextField3.setText(model.AnnulerArticleS().getCode_cat()); 
          vue.jTextField4.setText(String.valueOf(model.AnnulerArticleS().getprix())) ;
          
           
       
             } catch (Exception ex) {
              JOptionPane.showMessageDialog(vue, "Erreur de saisi corriger, svp!");
             }

}
    public void   jBNouveauActionPerformed(ActionEvent e) {
            try {
                
          
          vue.jTextField1.setText(""); 
          vue.jTextField2.setText(""); 
          vue.jTextField3.setText(""); 
          vue.jTextField4.setText("") ;
          vue.jBPremier.setEnabled(false);
          vue.jBDernier.setEnabled(false);
          vue.jBSuivant.setEnabled(false);
          vue.jBPrécedent.setEnabled(false);
          vue.jBNouveau.setEnabled(false);
          vue.jBModifier.setEnabled(false);
          vue.jBSupprimer.setEnabled(false);
          vue.jBAjouter.setEnabled(true);
          vue.jBAnnuler.setEnabled(true);
       
             } catch (Exception ex) {
              JOptionPane.showMessageDialog(vue, "Erreur de saisi corriger, svp!");
             }

}
     public void   jBSuivantActionPerformed(ActionEvent e) {
            try {
                Article art2=model.AfficheArticleS();
           
         vue.jTextField1.setText(art2.getCode_art()); 
      vue.jTextField2.setText(art2.getDes_art()); 
    vue.jTextField3.setText(art2.getCode_cat()); 
       vue.jTextField4.setText(String.valueOf(art2.getprix())) ;
 
             } catch (Exception ex) {
              JOptionPane.showMessageDialog(vue, "l'enregistrement courant est le dernier de la table Article !");
             }

}
     public void   jBPrecedanttActionPerformed(ActionEvent e) {
            try {
                Article art2=model.AfficheArticlePre();
           
         vue.jTextField1.setText(art2.getCode_art()); 
      vue.jTextField2.setText(art2.getDes_art()); 
    vue.jTextField3.setText(art2.getCode_cat()); 
       vue.jTextField4.setText(String.valueOf(art2.getprix())) ;
 
             } catch (Exception ex) {
              JOptionPane.showMessageDialog(vue, "l'enregistrement courant est le premier de la table. !");
        
             }

}
    public void   jBDernierActionPerformed(ActionEvent e) {
            try {
           if(vue.jTextField1.getText().equals(model.AfficheArticleD().getCode_art())){
            JOptionPane.showMessageDialog(vue, "l'enregistrement courant est le dernier de la table. !");
           }else{ 
          vue.jTextField1.setText(model.AfficheArticleD().getCode_art()); 
          vue.jTextField2.setText(model.AfficheArticleD().getDes_art()); 
          vue.jTextField3.setText(model.AfficheArticleD().getCode_cat()); 
          vue.jTextField4.setText(String.valueOf(model.AfficheArticleD().getprix())) ;
           }
       
             } catch (Exception ex) {
              JOptionPane.showMessageDialog(vue, "Erreur de saisi corriger, svp!");
             }

}
      public void   jBPremierActionPerformed(ActionEvent e) {
        try {
            
          if(vue.jTextField1.getText().equals(model.AfficheArticleP().getCode_art())){
            JOptionPane.showMessageDialog(vue, "l'enregistrement courant est le premier de la table. !");
           }else{
          vue.jTextField1.setText(model.AfficheArticleP().getCode_art()); 
           vue.jTextField2.setText(model.AfficheArticleP().getDes_art()); 
            vue.jTextField3.setText(model.AfficheArticleP().getCode_cat()); 
            vue.jTextField4.setText(String.valueOf(model.AfficheArticleP().getprix())) ;
           
          }
        } catch (Exception ex) {
              JOptionPane.showMessageDialog(vue, "Erreur de saisi corriger, svp!");
        }

}

    public void   jBInsererrActionPerformed(ActionEvent e) {
         vue.jBAjouter.setEnabled(false);
          vue.jBAnnuler.setEnabled(false);
           vue.jBPremier.setEnabled(true);
          vue.jBDernier.setEnabled(true);
          vue.jBSuivant.setEnabled(true);
          vue.jBPrécedent.setEnabled(true);
          vue.jBNouveau.setEnabled(true);
          vue.jBModifier.setEnabled(true);
          vue.jBSupprimer.setEnabled(true);
        try {
           
            String codeArticle = vue.jTextField1.getText();
            String desigantionArticle = vue.jTextField2.getText();
            String codeCategorie =vue.jTextField3.getText();
            double prix =Double.valueOf(vue.jTextField4.getText());
            Article art=new Article(codeArticle, desigantionArticle, codeCategorie, prix);
             if(model.getCategorie(codeCategorie)==true){
            model.ajouterArticles(art);
             JOptionPane.showMessageDialog(vue, "Article ajouté avec succès!");
             
            //  
                } else{
          
          JOptionPane.showMessageDialog(null, "le code catégorie n'existe pas ");
          }
             this.jBPremierActionPerformed(e);
        } catch (Exception ex) {
              JOptionPane.showMessageDialog(vue, "Erreur de saisi corriger, svp!");
        }

}
 private void jBModifierActionPerformed(ActionEvent e) {
     if(vue.jTextField1.getText()==" "){
         JOptionPane.showMessageDialog(null, "Veuillez remplir le champ du code de l'article");
     }else{
     
       
     
 if(JOptionPane.showConfirmDialog(null, "vouller vous modifier les informations de l'article avec le code='"+vue.jTextField1.getText()+"' ","confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){        
     try {
            String code = vue.jTextField1.getText();
            String desigantionArticle = vue.jTextField2.getText();
            String codeCategorie =vue.jTextField3.getText();
            double prix =Double.valueOf(vue.jTextField4.getText());
            Article art=new Article(code, desigantionArticle, codeCategorie, prix);
            model.modifierArticles(art);
       } catch (Exception ex) {
              JOptionPane.showMessageDialog(null,ex.getMessage()+ "Erreur de saisi corriger, svp!");
        }
            
 }else{
    JOptionPane.showMessageDialog(null, "la modification a été annulé");


    }
 }}    
    private void jBSupprimerActionPerformed(ActionEvent e) {
     if(vue.jTextField1.getText()==" "){
         JOptionPane.showMessageDialog(null, "Veuillez remplir le champ du code de l'article");
     }else{
     
       
     
 if(JOptionPane.showConfirmDialog(null, "vouller vous supprimer l'article avec le code='"+vue.jTextField1.getText()+"' ","confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){        
     try {
           String code = vue.jTextField1.getText();
            model.supprimerArticles(code);
         this.jBPremierActionPerformed(e);
       } catch (Exception ex) {
              JOptionPane.showMessageDialog(null,ex.getMessage()+ "Erreur de saisi corriger, svp!");
        }
            
 }else{
    JOptionPane.showMessageDialog(null, "la suppression a été annulé");


    }
 }}    
    
}
