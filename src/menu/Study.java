/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package menu;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import model.FlashCard;

/**
 *
 * @author nguye
 */
public class Study extends javax.swing.JPanel {
    
    private String deckName;
    private ArrayList<FlashCard> cardList;
    private boolean isShowAnswer;
    private Iterator cardIterator;
    private FlashCard currentCard;
    private int count;
    private int remember = 0;
    private int progress = 0;
    private DeckList deckList;

    public Study() {
        initComponents();
        forgetbtn.setEnabled(false);
        forgetbtn.setVisible(false);
        rememberbtn.setEnabled(false);
        rememberbtn.setVisible(false);
        init();
        
    }

    public void init() {
        currentCard = new FlashCard();
        deckName = "";
        deckName = ReadDeckNameFromFile();
        decktxt.setText(deckName);
        cardList = new ArrayList<>();
        cardList = ReadCardFromFile();
        Random random = new Random();
        Collections.shuffle(cardList, random);

        //Separator1.setEnabled(false);
        //backtxt.setEnabled(false);
        backtxt.setVisible(false);
        cardIterator = cardList.iterator();
        forgetbtn.setEnabled(false);
        forgetbtn.setVisible(false);
        rememberbtn.setEnabled(false);
        rememberbtn.setVisible(false);
        count = ReadDeckCountFile();
        if(cardIterator.hasNext()) showNextCard();
    }
    
    public void setDeckList(DeckList d) {
        deckList = d;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        fronttxt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        backtxt = new javax.swing.JTextArea();
        showAnsBtn = new javax.swing.JButton();
        rememberbtn = new javax.swing.JButton();
        forgetbtn = new javax.swing.JButton();
        decktxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 219, 234));

        fronttxt.setBackground(new java.awt.Color(245, 255, 201));
        fronttxt.setColumns(10);
        fronttxt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        fronttxt.setLineWrap(true);
        fronttxt.setRows(5);
        fronttxt.setWrapStyleWord(true);
        fronttxt.setBorder(null);
        jScrollPane1.setViewportView(fronttxt);

        backtxt.setBackground(new java.awt.Color(245, 255, 201));
        backtxt.setColumns(20);
        backtxt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        backtxt.setLineWrap(true);
        backtxt.setRows(5);
        backtxt.setWrapStyleWord(true);
        backtxt.setBorder(null);
        jScrollPane2.setViewportView(backtxt);

        showAnsBtn.setBackground(new java.awt.Color(255, 255, 102));
        showAnsBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        showAnsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-light-on-50.png"))); // NOI18N
        showAnsBtn.setText("Show Answer");
        showAnsBtn.setFocusPainted(false);
        showAnsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAnsBtnActionPerformed(evt);
            }
        });

        rememberbtn.setBackground(new java.awt.Color(255, 170, 207));
        rememberbtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        rememberbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-winner-50.png"))); // NOI18N
        rememberbtn.setText("Remember");
        rememberbtn.setFocusPainted(false);
        rememberbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberbtnActionPerformed(evt);
            }
        });

        forgetbtn.setBackground(new java.awt.Color(0, 153, 153));
        forgetbtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        forgetbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-sad-50 (1).png"))); // NOI18N
        forgetbtn.setText("Forget");
        forgetbtn.setFocusPainted(false);
        forgetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgetbtnActionPerformed(evt);
            }
        });

        decktxt.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        decktxt.setForeground(new java.awt.Color(102, 20, 72));
        decktxt.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(rememberbtn)
                .addGap(74, 74, 74)
                .addComponent(forgetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(decktxt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(showAnsBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(decktxt)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(showAnsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(forgetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rememberbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rememberbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberbtnActionPerformed
        showAnsBtn.setEnabled(true);
        remember++;
        rememberbtn.setVisible(false);
        rememberbtn.setEnabled(false);
        forgetbtn.setEnabled(false);
        forgetbtn.setVisible(false);
    }//GEN-LAST:event_rememberbtnActionPerformed

    private void forgetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgetbtnActionPerformed
        showAnsBtn.setEnabled(true);
        
        rememberbtn.setVisible(false);
        rememberbtn.setEnabled(false);
        forgetbtn.setEnabled(false);
        forgetbtn.setVisible(false);
    }//GEN-LAST:event_forgetbtnActionPerformed

    private void showAnsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAnsBtnActionPerformed
        if (isShowAnswer) {
            
            backtxt.setVisible(true);
            backtxt.setText(currentCard.getAnswer());
            showAnsBtn.setText("Next Card");
            showAnsBtn.setEnabled(false);
            rememberbtn.setVisible(true);
            rememberbtn.setEnabled(true);
            forgetbtn.setEnabled(true);
            forgetbtn.setVisible(true);
            isShowAnswer = false;
            
        } else {
            if (cardIterator.hasNext()) {
                showNextCard();
            } else {
                if (!"Done".equals(showAnsBtn.getText())) {
                    fronttxt.setText("That was the last card.");
                    
                    backtxt.setVisible(false);
                    //showAnsBtn.setEnabled(false);
                    //forgetbtn.setEnabled(true);
                    showAnsBtn.setText("Done");
                } else {
                    LocalDateTime now = LocalDateTime.now();
                    String formattedNow = formatTime(now);
                    if (count == 0) {
                        count++;
                        writeDeckCountToFile(count);
                        writeStudyTimeToFile(now);
                    } else {
                        LocalDateTime due = readDueTime();
                        int a = due.compareTo(now);
                        if (a <= 0) {
                            count++;
                            writeDeckCountToFile(count);
                            writeStudyTimeToFile(now);
                        }
                    }
                    CalculateProgress();
                    
                    WriteProgressToFile(progress);
                    deckList.init();
                    deckList.setVisible(true);
                    this.setVisible(false);
                    
                }
                
            }
        }
    }//GEN-LAST:event_showAnsBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea backtxt;
    private javax.swing.JLabel decktxt;
    private javax.swing.JButton forgetbtn;
    private javax.swing.JTextArea fronttxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton rememberbtn;
    private javax.swing.JButton showAnsBtn;
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
    
    private int ReadDeckCountFile() {
        int x = 0;
        try (Scanner sc = new Scanner(new File(deckName + "count.txt"))) {
            while (sc.hasNext()) {
                x = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
        
        return x;
    }
    
    private void showNextCard() {
        currentCard = (FlashCard) cardIterator.next();
        fronttxt.setText(currentCard.getQuestion());
        showAnsBtn.setText("Show Answer");
        isShowAnswer = true;
        
        backtxt.setVisible(false);
        rememberbtn.setVisible(false);
        rememberbtn.setEnabled(false);
        forgetbtn.setEnabled(false);
        forgetbtn.setVisible(false);
    }
    
    private String formatTime(LocalDateTime now) {
        String pattern = "dd/MM/yyy HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
    
    private void writeDeckCountToFile(int count) {
        try (PrintWriter pw = new PrintWriter(new File(deckName + "count.txt"))) {
            pw.println(count);
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
    }
    
    private void writeStudyTimeToFile(LocalDateTime now) {
        try (PrintWriter pw = new PrintWriter(new File(deckName + "StudyTime.txt"))) {
            pw.println(now);
        } catch (Exception e) {
            System.out.println("Got an 1exception");
        }
    }
    
    private LocalDateTime readDueTime() {
        String x;
        LocalDateTime y = null;
        try (Scanner sc = new Scanner(new File(deckName + "DueTime.txt"))) {
            while (sc.hasNext()) {
                x = sc.nextLine();
                y = LocalDateTime.parse(x);
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
        
        return y;
    }
    
    private void CalculateProgress() {
        progress = remember * 100 / cardList.size();
    }
    
    private void WriteProgressToFile(int progress) {
        try (PrintWriter pw = new PrintWriter(new File(deckName + "Progress.txt"))) {
            pw.println(progress);
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
    }
}
