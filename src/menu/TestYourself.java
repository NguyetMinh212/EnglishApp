/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package menu;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.FlashCard;


public class TestYourself extends javax.swing.JPanel {

   private String deckName;
    private ArrayList<FlashCard> cardList;
    private boolean isShowAnswer;
    private Iterator cardIterator;
    private FlashCard currentCard;
    private int check = 0;
    private int isTrue = 0;
    private String correct;
    public TestYourself() {
        initComponents();
        init();
                
    }
    public void init()
    {
        currentCard = new FlashCard();
        deckName = "";
        deckName = ReadDeckNameFromFile();
        decktxt.setText(deckName);
        cardList = new ArrayList<>();
        cardList = ReadCardFromFile();
        Random random = new Random();
        Collections.shuffle(cardList, random);
        cardIterator = cardList.iterator();
        
        if(cardIterator.hasNext()) showNextCard();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decktxt = new javax.swing.JLabel();
        questiontxt = new javax.swing.JTextField();
        answertxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        checkBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(192, 219, 234));

        decktxt.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        decktxt.setForeground(new java.awt.Color(153, 102, 0));
        decktxt.setText("Name");

        questiontxt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        questiontxt.setForeground(new java.awt.Color(255, 104, 91));
        questiontxt.setBorder(null);

        answertxt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        answertxt.setForeground(new java.awt.Color(153, 153, 153));
        answertxt.setToolTipText("");
        answertxt.setBorder(null);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Question:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Answer:");

        checkBtn.setBackground(new java.awt.Color(204, 255, 153));
        checkBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-checkmark-50.png"))); // NOI18N
        checkBtn.setText("Check");
        checkBtn.setFocusPainted(false);
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        nextBtn.setBackground(new java.awt.Color(204, 255, 153));
        nextBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-next-page-50.png"))); // NOI18N
        nextBtn.setText("Next");
        nextBtn.setFocusPainted(false);
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(decktxt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(checkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(answertxt, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(questiontxt))))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(decktxt)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        if(answertxt.getText().equals(""))
        {
             JOptionPane.showMessageDialog(this, "Please enter your answer!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(isShowAnswer)
            {
                isTrue = 0;
                if(answertxt.getText().equals(correct))
                {
                    isTrue = 1;
                    answertxt.setForeground(Color.GREEN);
                    check = 1;
                }
                if(isTrue==0)
                {
                    
                        answertxt.setForeground(Color.red);
                        checkBtn.addActionListener((e) -> {
                            
                            answertxt.setForeground(Color.GREEN);
                            answertxt.setText(correct);
                            check = 1;
                        });
                    
                    
                    
                }
                isShowAnswer=false;
            }
        }
    }//GEN-LAST:event_checkBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        if(check==1 && isShowAnswer == false)
        {
            check = 0;
            if (cardIterator.hasNext()) {
                showNextCard();
            }
            else{
                questiontxt.setText("Congratulations! You have done the test!");
                answertxt.setEnabled(false);
                nextBtn.setEnabled(false);
                checkBtn.setEnabled(false);
            }
        }
    }//GEN-LAST:event_nextBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answertxt;
    private javax.swing.JButton checkBtn;
    private javax.swing.JLabel decktxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTextField questiontxt;
    // End of variables declaration//GEN-END:variables
     private String ReadDeckNameFromFile() {
        String b = "";
        try (Scanner sc = new Scanner(new File("DeckNameChosen.txt"))) {
            while (sc.hasNext()) {
                b = sc.nextLine();
                
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
        return b;
    }
    
    private ArrayList<FlashCard> ReadCardFromFile() {
        ArrayList<FlashCard> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(deckName + ".txt"))) {
            while (sc.hasNext()) {
                FlashCard card = new FlashCard();
                card.setQuestion(sc.nextLine());
                card.setAnswer(sc.nextLine());
                
                list.add(card);
                
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
        return list;
    }
    private void showNextCard() {
        currentCard = (FlashCard) cardIterator.next();
        questiontxt.setText(currentCard.getQuestion());
        isShowAnswer = true;
        isTrue = 0;
        check = 0;
        answertxt.setText("");
        answertxt.setForeground(Color.gray);
        correct = currentCard.getAnswer();
    }
}
