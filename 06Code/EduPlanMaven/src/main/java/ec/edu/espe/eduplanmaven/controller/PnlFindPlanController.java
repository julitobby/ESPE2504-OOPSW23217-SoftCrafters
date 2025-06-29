package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.PnlFindPlan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public class PnlFindPlanController implements ItemListener {
    
    private static PnlFindPlanController instance;
    
    private PnlFindPlan pnlFindPlan;

    private PnlFindPlanController() {
        this.pnlFindPlan = PnlFindPlan.getInstance();
       
        //Combobox
        pnlFindPlan.getCmbListPlanification().addItemListener(this);
        pnlFindPlan.getCmbScopes().addItemListener(this);
        
    }
    
    public static PnlFindPlanController getInstance() {
        if (instance == null) {
            instance = new PnlFindPlanController();
        }
        return instance;
    }
    
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
    
}
