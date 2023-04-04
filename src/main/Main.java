package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nguye
 */
public class Main extends javax.swing.JFrame {
    
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        menu.setVisible(true);
        resetSelection();
        createNewDeck.setVisible(true);
        createNewDeck.setDeckHome(deckHome);
        deckList.setDeckHome(deckHome);
        deckHome.setStudy(study);
        study.setDeckList(deckList);
        
        menu.addEventCreate(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSelection();
                createNewDeck.init();
                createNewDeck.setVisible(true);
            }
        });
        
        menu.addEventDeckList(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSelection();
                deckList.init();
                deckList.setVisible(true);
            }
        });
        
        menu.addEventTest(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSelection();
                testYourself.init();
                testYourself.setVisible(true);
            }
        });
    }
    
    public void resetSelection() {
        createNewDeck.setVisible(false);
        deckList.setVisible(false);
        deckHome.setVisible(false);
        study.setVisible(false);
        testYourself.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testYourself = new menu.TestYourself();
        study = new menu.Study();
        deckHome = new menu.DeckHome();
        deckList = new menu.DeckList();
        menu = new menu.Menu();
        createNewDeck = new menu.CreateNewDeck();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(testYourself, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 620, 510));
        getContentPane().add(study, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 620, 510));
        getContentPane().add(deckHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 620, 510));
        getContentPane().add(deckList, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 620, 510));
        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 510));
        getContentPane().add(createNewDeck, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 620, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menu.CreateNewDeck createNewDeck;
    private menu.DeckHome deckHome;
    private menu.DeckList deckList;
    private menu.Menu menu;
    private menu.Study study;
    private menu.TestYourself testYourself;
    // End of variables declaration//GEN-END:variables
}
