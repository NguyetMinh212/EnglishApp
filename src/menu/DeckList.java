/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.FlashCard;

/**
 *
 * @author nguye
 */
public class DeckList extends javax.swing.JPanel {

    private ArrayList<String> nameList;
    private ArrayList<FlashCard> cardList;
    private int count;
    LocalDateTime study, due;
    String dueDate;
    private int progress;
    private ArrayList<Integer> dueList;
    private DeckHome deckHome;

    public DeckList() {
        initComponents();
        init();

        

    }
    
    public final void init()
    {
        nameList = new ArrayList<>();
        nameList = readFromeFile();
        dueList = new ArrayList<>();
        dueList.add(0);
        dueList.add(30);
        dueList.add(90);
        dueList.add(1);
        dueList.add(2);
        dueList.add(5);
        dueList.add(10);
        dueList.add(14);
        study = null;
        due = null;
        dueDate = "";
        DefaultTableModel tbl = (DefaultTableModel) table1.getModel();
        tbl.setRowCount(0);
        for (String b : nameList) {

            cardList = ReadCardFile(b + ".txt");
            count = ReadDeckCountFile(b);
            progress = ReadProgess(b);
            if (count > 0) {
                study = readStudyTime(b);
                System.out.println(study);
                if (count < 3) {
                    due = study.plus(dueList.get(count), ChronoUnit.MINUTES);
                    writeDueTimeToFile(b);
                    dueDate = formatTime(due);
                } else if (count > 7) {
                    if (progress < 100) {
                        dueDate = "Try to reach 100% of progress";
                    } else {
                        dueDate = "You've remembered the deck";
                    }
                } else {
                    due = study.plus(dueList.get(count), ChronoUnit.DAYS);
                    writeDueTimeToFile(b);
                    dueDate = formatTime(due);
                }

            } else{
                due = LocalDateTime.MIN;
                dueDate= "Study for the first time.";
                writeDueTimeToFile(b);
            }
            String progress1 = String.valueOf(progress);
            progress1+="%";
            table1.addRow(new Object[]{
                b, cardList.size(), progress1, dueDate});
}
    }

    public void setDeckHome(DeckHome d) {
        deckHome = d;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new component.Table();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(192, 219, 234));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(122, 62, 101));
        jLabel1.setText("Deck List");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Deck Name", "Card Number", "Progress", "Due Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(table1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 540, 330));

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 120, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x = table1.getSelectedRow();
        if (x != -1) {

            String selected = (String) table1.getValueAt(x, 0);
            writeDeckChosenToFile(selected);
            //deckHome.init();
            deckHome.setVisible(true);
            deckHome.init();
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private component.Table table1;
    // End of variables declaration//GEN-END:variables
    private ArrayList<String> readFromeFile() {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("DeckName.txt"))) {
            while (sc.hasNext()) {
                String b = sc.nextLine();
                list.add(b);
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
        return list;
    }

    private void writeDeckChosenToFile(String selected) {
        try (PrintWriter pw = new PrintWriter(new File("DeckNameChosen.txt"))) {
            pw.println(selected);
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
    }

//    private void showTable() {
//        int i=0;
//        while(i<deckList.size()-1)
//        {
//            Deck d = deckList.get(i);
//            table.addRow(new Object[]{
//                d.getDeckName(), d.getCardList().size(), 0
//            });
//            i++;
//        }
//        
//    }
    private ArrayList<FlashCard> ReadCardFile(String par) {
        ArrayList<FlashCard> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(par))) {
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

    private int ReadDeckCountFile(String s) {
        int x = 0;
        try (Scanner sc = new Scanner(new File(s + "count.txt"))) {
            while (sc.hasNext()) {
                x = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }

        return x;

    }

    private LocalDateTime readStudyTime(String deckName) {
        String x = "";
        LocalDateTime y = null;
        try (Scanner sc = new Scanner(new File(deckName + "StudyTime.txt"))) {
            while (sc.hasNext()) {
                x = sc.nextLine();
                y = LocalDateTime.parse(x);
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }

        return y;
    }

    private void writeDueTimeToFile(String b) {
        try (PrintWriter pw = new PrintWriter(new File(b + "DueTime.txt"))) {
            pw.println(due);
        } catch (Exception e) {
            System.out.println("Got an 1exception");
        }
    }

    private String formatTime(LocalDateTime now) {
        String pattern = "dd/MM/yyy HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }

    private int ReadProgess(String b) {
        int x = 0;
        try (Scanner sc = new Scanner(new File(b + "Progress.txt"))) {
            while (sc.hasNext()) {
                x = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Got an exception");
        }
        return x;
    }
}
