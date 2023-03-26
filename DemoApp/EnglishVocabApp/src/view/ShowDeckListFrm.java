/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Deck;
import model.FlashCard;

/**
 *
 * @author nguye
 */
public class ShowDeckListFrm extends javax.swing.JFrame {

    /**
     * Creates new form ShowDeckListFrm
     */
    
    private DefaultListModel<String> listModel;
    private ArrayList<String> nameList;
    protected ArrayList<Deck> deckList;
    private  DefaultTableModel table;
    private ArrayList<FlashCard> cardList;
    public ShowDeckListFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        table = (DefaultTableModel) tblDeckList.getModel();
        
        listModel = new DefaultListModel<>();
        DeckList.setModel(listModel);
        nameList = new ArrayList<>();
        nameList = readFromeFile(); 
        deckList = new ArrayList<>();
       
        for(String b : nameList)
        {
            listModel.addElement(b);
            cardList = ReadCardFile(b+".txt");
            Deck d = new Deck(cardList, b);
            table.addRow(new Object[]{
                b, cardList.size(), cardList.size()});
            deckList.add(d);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DeckList = new javax.swing.JList<>();
        connect = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDeckList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DeckList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(DeckList);

        connect.setText("Connect to Deck");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        jButton1.setText("Close");

        tblDeckList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Deck", "Num", "Due"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDeckList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(connect)
                        .addGap(108, 108, 108)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connect)
                    .addComponent(jButton1))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
        if(DeckList.getSelectedIndex()!=-1)
        {
            String selected = DeckList.getSelectedValue();
            writeDeckChosenToFile(selected);
            new DeckFrm().setVisible(true);
            this.dispose();
        }
        else
        {
            int x =tblDeckList.getSelectedRow();
            if(x!=-1)
            {
                String selected = (String) tblDeckList.getValueAt(x, 0);
                writeDeckChosenToFile(selected);
                new DeckFrm().setVisible(true);
                this.dispose();
            }
        }
            
        
    }//GEN-LAST:event_connectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowDeckListFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowDeckListFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowDeckListFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowDeckListFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowDeckListFrm().setVisible(true);
            }
        });
    }

    private ArrayList<String> readFromeFile() {
        ArrayList<String> list = new ArrayList<>();
        try(Scanner sc = new Scanner(new File("DeckName.txt"))){
            while(sc.hasNext())
            {
                String b = sc.nextLine();
                list.add(b);
            }
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
        return list;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> DeckList;
    private javax.swing.JButton connect;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDeckList;
    // End of variables declaration//GEN-END:variables

    private void writeDeckChosenToFile(String selected) {
            try(PrintWriter pw = new PrintWriter(new File("DeckNameChosen.txt"))){
            pw.println(selected);
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
    }
    
    private void showTable() {
        int i=0;
        while(i<deckList.size()-1)
        {
            Deck d = deckList.get(i);
            table.addRow(new Object[]{
                d.getDeckName(), d.getCardList().size(), 0
            });
            i++;
        }
        
    }

    private ArrayList<FlashCard> ReadCardFile(String par) {
        ArrayList<FlashCard> list = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(par))){
            while(sc.hasNext())
            {
                FlashCard card = new FlashCard();
                card.setQuestion(sc.nextLine());
                card.setAnswer(sc.nextLine());
                
                list.add(card);
                
            }
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
        return list;
    }
    
}
