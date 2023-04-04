/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package menu;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import main.AddCardFrm;
import model.FlashCard;

/**
 *
 * @author nguye
 */
public class DeckHome extends javax.swing.JPanel {

    private ArrayList<String> nameList;
    private ArrayList<FlashCard> cardList;
    private Study study;
   public boolean isAdd;
    private String dueDate;
    private int count  = 0;
    LocalDateTime check;
     LocalDateTime check1;
    public DeckHome() {
        initComponents();
        check = LocalDateTime.MIN;
        
        init();
        

    }
    
    public final void init()
    {
        nameList = new ArrayList<>();
        cardList = new ArrayList<>();
        nameList = ReadDeckNameFile();
        count = ReadDeckCountFile();
        isAdd = false;
        if(!nameList.isEmpty())
        {
            
            deckNametxt.setText(nameList.get(nameList.size() - 1));
        
            dueDate = "";
        
        LocalDateTime due = readDueDate();
        System.out.println(due);
        int result = due.compareTo(check);
        if(result==0)
        {
            dueDate = "It is high time to study!";
        } else{
            dueDate = formatTime(due);
        }
            
        
        duetxt.setText(dueDate);
            
        
        cardList = ReadCardFile();
        numtxt.setText(Integer.toString(cardList.size()));
        }
        
    }
    
    public void setStudy(Study s)
    {
        study = s;
    }
    
    public boolean isAddOn()
    {
        return isAdd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deckNametxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numtxt = new javax.swing.JLabel();
        duetxt = new javax.swing.JLabel();
        studyBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(192, 219, 234));

        addBtn.setBackground(new java.awt.Color(233, 200, 105));
        addBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-new-50.png"))); // NOI18N
        addBtn.setText("Add New Card");
        addBtn.setFocusPainted(false);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deckNametxt.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
        deckNametxt.setForeground(new java.awt.Color(204, 0, 0));
        deckNametxt.setText("Deck Name");
        deckNametxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-anki-50.png"))); // NOI18N
        jLabel2.setText("Cards Number:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 43, 27));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-deadline-50.png"))); // NOI18N
        jLabel3.setText("Due Date: ");

        numtxt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        numtxt.setText("0");

        duetxt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        duetxt.setForeground(new java.awt.Color(255, 51, 102));
        duetxt.setText("0");

        studyBtn.setBackground(new java.awt.Color(233, 200, 105));
        studyBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        studyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-book-reading-50.png"))); // NOI18N
        studyBtn.setText("Study");
        studyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studyBtnActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(233, 200, 105));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-available-updates-50.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duetxt)
                            .addComponent(studyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(deckNametxt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(deckNametxt)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numtxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duetxt))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addEventBack(ActionListener event) {
        addBtn.addActionListener(event);
    }
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        //isAdd = true;
        new AddCardFrm().setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void studyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studyBtnActionPerformed
        study.init();
        study.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_studyBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        init();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel deckNametxt;
    private javax.swing.JLabel duetxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel numtxt;
    private javax.swing.JButton studyBtn;
    // End of variables declaration//GEN-END:variables
    private ArrayList ReadDeckNameFile() {
        ArrayList<String> list = new ArrayList<>();
        try(Scanner sc = new Scanner(new File("DeckNameChosen.txt"))){
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

    private ArrayList<FlashCard> ReadCardFile() {
        String deckName = deckNametxt.getText();
        ArrayList<FlashCard> list = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(deckName+".txt"))){
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

    private int ReadDeckCountFile() {
        String deckName = deckNametxt.getText();
        int x = 0;
        try(Scanner sc = new Scanner(new File(deckName+"count.txt")))
        {
            while(sc.hasNext())
            {
                x = sc.nextInt();
            }
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
         
        return x;
                  
    }

    private void writeDeckCountToFile(int count) {
        try(PrintWriter pw = new PrintWriter(new File(deckNametxt.getText()+"count.txt"))){
            pw.println(count);
        } catch(Exception e)
        {
            System.out.println("Got an exception");
        }
    }

    private LocalDateTime readDueDate() {
        String x = "";
        LocalDateTime y = null;
        try (Scanner sc = new Scanner(new File(deckNametxt.getText() + "DueTime.txt"))) {
            while (sc.hasNext()) {
                x = sc.nextLine();
                y = LocalDateTime.parse(x);
               
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }

        return y;
    }

    private String formatTime(LocalDateTime due) {
        String pattern = "dd/MM/yyy HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDateTime = due.format(formatter);
        return formattedDateTime;
    }

    
}
