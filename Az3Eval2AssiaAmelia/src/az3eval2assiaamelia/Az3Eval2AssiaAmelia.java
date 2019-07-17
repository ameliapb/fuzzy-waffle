/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az3eval2assiaamelia;

import java.awt.event.ActionEvent;

/**
 *
 * @author TAOURIRT
 */
public class Az3Eval2AssiaAmelia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          VueArticle  fen = new VueArticle();
          fen.jBAjouter.setEnabled(false);
            fen.jBAnnuler.setEnabled(false);
        
       ModeleVueArticle rec = new ModeleVueArticle();
       rec.getConnection();
      ControleurVueArticle ctrl = new ControleurVueArticle(fen,rec);
        ActionEvent e = null;
      ctrl.jBPremierActionPerformed(e);
   
      
       fen.setVisible(true);
    }
    
}
