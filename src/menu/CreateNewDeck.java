/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package menu;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author nguye
 */
public class CreateNewDeck extends javax.swing.JPanel {

    private ArrayList<String> DeckNameLists;
    private int count;
    private DeckHome deckHome;
    private String deckName;
    LocalDateTime due;
    private String dueDate;
    public CreateNewDeck() {
        initComponents();
        init();
        
        
        
    }
    
    public void init()
    {
        nametextfield.setText("");
        DeckNameLists = new ArrayList<>();
        DeckNameLists = ReadDeckNameFile();
        count = 0;
        due = null;
        deckName = "";
    }
    
    public void setDeckHome(DeckHome d)
    {
        deckHome = d;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nametextfield = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(192, 219, 234));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("New Deck Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        nametextfield.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nametextfield.setBorder(null);
        add(nametextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 390, 50));

        okBtn.setBackground(new java.awt.Color(62, 174, 249));
        okBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        okBtn.setText("OK");
        okBtn.setFocusPainted(false);
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        add(okBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 90, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
       if(!nametextfield.getText().equals(""))
       {
           DeckNameLists.add(nametextfield.getText());
           deckName = nametextfield.getText();
           WriteDeckChosenToFile();
        writeDeckNameToFile(DeckNameLists);
        writeDeckChosenToFile(nametextfield.getText());
        writeDeckCountToFile(count);
        due = LocalDateTime.MIN;
        writeDueTimeToFile();
        
        //new DeckFrm().setVisible(true);
        //this.dispose();
        deckHome.setVisible(true);
        deckHome.init();
        
        this.setVisible(false);
       } else{
           JOptionPane.showMessageDialog(this, "You have not entered the Deck Name yet!", "Warning", JOptionPane.INFORMATION_MESSAGE);
       }
        
       
    }//GEN-LAST:event_okBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nametextfield;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
    private void writeDeckNameToFile(ArrayList<String> list) {
        try(PrintWriter pw = new PrintWriter(new File("DeckName.txt"))){
            for(String b:list)
            {
                pw.println(b);
            }
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
    }
    
     private ArrayList ReadDeckNameFile() {
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

    private void writeDeckChosenToFile(String text) {
        try(PrintWriter pw = new PrintWriter(new File("DeckNameChosen.txt"))){
            pw.println(text);
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
    }

    private void writeDeckCountToFile(int count) {
        try(PrintWriter pw = new PrintWriter(new File(nametextfield.getText()+"count.txt"))){
            pw.println(count);
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
    }

    private void writeDueTimeToFile() {
        try (PrintWriter pw = new PrintWriter(new File( nametextfield.getText()+ "DueTime.txt"))) {
            pw.println(due);
        } catch (Exception e) {
            System.out.println("Got an 1exception");
        }
    }

    private void WriteDeckChosenToFile() {
        try (PrintWriter pw = new PrintWriter(new File("DeckNameChosen.txt"))) {
            pw.println(deckName);
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
    }
}
